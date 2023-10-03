package login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAdminAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")!=null) {
			session.invalidate();
			return "../login/login-admin.jsp";
		}
		
		return "../login/logout-adminerror.jsp";
	}

}
