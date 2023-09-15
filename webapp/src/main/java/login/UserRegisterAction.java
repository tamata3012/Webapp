package login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.LoginDAO;
import tool.Action;

public class UserRegisterAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String phoneNumber=request.getParameter("phone");
		LoginDAO dao=new LoginDAO();
		
ArrayList<String> errorList=new ArrayList<>();
		
		if(name==null||name.equals("")) {
			errorList.add("名前が入力されてません");
		}
		if(password==null||password.equals("")) {
			errorList.add("パスワードが入力されてません");
		}	
		if(phoneNumber==null||phoneNumber.equals("")) {
			errorList.add("電話番号が入力されてません");			
		}
		if(errorList.isEmpty()) {
			int count=dao.register(name, password,phoneNumber);
			
			if(count==1) {
				String message="ユーザー新規登録が完了しました。";
				request.setAttribute("message", message);
				return "login.jsp";
			}
		}
		request.setAttribute("errorMessageList", errorList);
		return "login-register.jsp";
	}

}
