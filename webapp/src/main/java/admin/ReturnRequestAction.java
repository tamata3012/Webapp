package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDao;
import tool.Action;

public class ReturnRequestAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReserveDao dao=new ReserveDao();
		dao.updateStatus(id,3);
		dao.registerReturn(id);
		
		return "AllRentalRequest.action";
	}

}
