package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import reserve.dao.ReserveDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class RequestDeleteAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			HttpSession session=request.getSession();
			Rental rental=(Rental) session.getAttribute("rental");
			RentalRequestAction action=new RentalRequestAction();
			if(session.getAttribute("user")==null) {
				return "../login/login-return.jsp";
			}
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			ReserveDao dao=new ReserveDao();
			int count=dao.delete(id);
			
			if(count!=1){
				return "rental-detail.jsp";
			}
			
			int number=rental.getRentalNumber();
			id=rental.getProductId();
			
			ProductDao product=new ProductDao();
			
			product.changeNumber(id, number);
			String page=action.excute(request, response);
			
			return page;
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}
}
