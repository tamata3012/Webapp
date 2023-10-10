package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import reserve.dao.ReserveDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class ReturnRequestAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			HttpSession session=request.getSession();
			
			if(session.getAttribute("admin")==null) {
				return "../login/login-adminreturn.jsp";
			}
			
			int id=Integer.parseInt(request.getParameter("id"));
			int productId=Integer.parseInt(request.getParameter("productId"));
			int number=Integer.parseInt((request.getParameter("rentalNumber")));
			ProductDao productDao=new ProductDao();
			
			ReserveDao dao=new ReserveDao();
			dao.updateStatus(id,3);
			dao.registerReturn(id);
			
			productDao.changeNumber(productId, number);
			
			return "AllRentalRequest.action";
			
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}

}
