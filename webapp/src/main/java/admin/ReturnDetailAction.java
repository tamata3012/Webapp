package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Rental;
import reserve.dao.ReserveDao;
import tool.Action;

public class ReturnDetailAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-return.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReserveDao dao=new ReserveDao();
		Rental rental=dao.selectByReturn(id);
		
		session.setAttribute("rental", rental);
		
		return "../admin/adminrental-detail.jsp";
	}

}
