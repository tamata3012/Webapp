package login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.Admin;
import login.dao.LoginAdminDao;
import reserve.ProductAction;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class LoginAdminAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			HttpSession session=request.getSession();
	
			if(session.getAttribute("user")!=null) {
				session.removeAttribute("user");
			}
			
			String page="login-admin.jsp";
			
			ProductAction productaction=new ProductAction();
			
			String name=request.getParameter("adminname");
			String password=request.getParameter("password");
			LoginAdminDao dao=new LoginAdminDao();
			
			ArrayList<String> errorList=new ArrayList<>();
			
			if(name==null||name.equals("")) {
				errorList.add("名前が入力されてません");
			}
			if(password==null||password.equals("")) {
				errorList.add("パスワードが入力されてません");
			}
			
			if(errorList.isEmpty()) {
				Admin admin=dao.search(name, password);
				if(admin!=null) {
					session.setAttribute("admin", admin);
					page=productaction.excute(request, response);
				}else {
					errorList.add("ユーザー名かパスワードが間違っています。");
				}
			}
			request.setAttribute("errorMessageList", errorList);
			return page;
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}

}
