package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.LoginDAO;
import tool.Action;

public class LoginAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Connection con=ConnectionManager.getConnection();
		
		HttpSession session=request.getSession();
		
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		LoginDAO dao=new LoginDAO();
		
		
		User user=dao.search(name, password);
		
		if(user!=null) {
			session.setAttribute("loginuser", user);
			return "login-success.jsp";
		}
		
		return "login-error.jsp";
	}

}
