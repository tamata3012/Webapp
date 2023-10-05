package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDao;
import tool.Action;

public class RequestRemandAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReserveDao dao=new ReserveDao();
		int count=dao.updateStatus(id,-1);
		
		return "../admin/rental-allrequest.jsp";
	}

}
