package reserve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;
import reserve.dao.ReserveDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class RentalRequestAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			HttpSession session=request.getSession();
			User user=(User) session.getAttribute("user");
			
			if(session.getAttribute("user")==null) {
				return "../login/login-return.jsp";
			}
			
			int id=user.getId();
				
			ReserveDao dao=new ReserveDao();
			List<Rental> rentalList=dao.selectByUserId(id);
			
			session.setAttribute("rentalList", rentalList);
			
			return "../reserve/rental-request.jsp";
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}
}
