package login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.LoginDAO;
import tool.Action;

public class LoginAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session=request.getSession();
		
		String page="login.jsp";
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		LoginDAO dao=new LoginDAO();
		
		ArrayList<String> errorList=new ArrayList<>();
		
		if(name==null||name.equals("")) {
			errorList.add("名前が入力されてません");
		}
		if(password==null||password.equals("")) {
			errorList.add("パスワードが入力されてません");
		}
		
		if(!errorList.isEmpty()) {
			request.setAttribute("errorMessageList", errorList);
		}
		
		User user=dao.search(name, password);
		
		if(user!=null) {
			session.setAttribute("user", user);
			page= "../reserve/home.jsp";
		}else {
			errorList.add("ユーザー名かパスワードが間違っています。");
		}
		
		return page;
	}

}
