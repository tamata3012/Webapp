package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Product;
import reserve.dao.ProductDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class ProductDetailAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session=request.getSession();
			
			if(session.getAttribute("admin")==null) {
				return "../login/login-return.jsp";
			}
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			ProductDao dao=new ProductDao();
			Product product=dao.selectById(id);
			
			session.setAttribute("product", product);
			
			return "product-detail.jsp";
		
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
		
	}

}
