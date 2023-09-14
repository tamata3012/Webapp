package login;

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
		
		if(name!=null) {
			if(password!=null) {
				if(phoneNumber!=null) {
					
					int count=dao.register(name, password,phoneNumber);
					
					if(count==1) {
						return "login.jsp";
					}
					
				}
			}
		}	
		return "login-register.jsp";
	}

}
