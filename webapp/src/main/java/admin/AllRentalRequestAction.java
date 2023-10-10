package admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Rental;
import reserve.dao.ReserveDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class AllRentalRequestAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			HttpSession session=request.getSession();
			
			if(session.getAttribute("admin")==null) {
				return "../login/login-adminreturn.jsp";
			}
			
				
			ReserveDao dao=new ReserveDao();
			List<Rental> rentalList=dao.select();
			List<Rental> returnList=dao.selectReturn();
			
			session.setAttribute("rentalList", rentalList);
			session.setAttribute("returnList", returnList);
			
			return "../admin/rental-allrequest.jsp";
			
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}
}
