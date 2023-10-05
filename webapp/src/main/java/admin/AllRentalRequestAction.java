package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Rental;
import reserve.dao.ReserveDao;
import tool.Action;

public class AllRentalRequestAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
			
		ReserveDao dao=new ReserveDao();
		List<Rental> rentalList=dao.select();
		
		session.setAttribute("rentalList", rentalList);
		
		return "../admin/rental-allrequest.jsp";

	}


}
