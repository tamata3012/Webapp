package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class RentalAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response){
		
		try {
			HttpSession session=request.getSession();
			
			if(session.getAttribute("user")==null) {
				return "../login/login-return.jsp";
			}
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			ProductDao dao=new ProductDao();
			Product product=dao.selectById(id);
			
			session.setAttribute("product", product);
			
			return "rentalreserve.jsp";
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}
}
