package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class RentalDetailAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			HttpSession session=request.getSession();
			
			if(session.getAttribute("user")==null) {
				return "../login/login-return.jsp";
			}
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			ReserveDao dao=new ReserveDao();
			Rental rental=dao.selectById(id);
			
			session.setAttribute("rental", rental);
			
			return "rental-detail.jsp";
			
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}

}
