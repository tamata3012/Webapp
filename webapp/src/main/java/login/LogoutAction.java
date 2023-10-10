package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")!=null||session.getAttribute("user")!=null) {
			session.invalidate();
			return "../login/login.jsp";
		}
		return "../login/logout-error.jsp";
	}

}
