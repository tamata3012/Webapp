package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.ProductAction;
import reserve.dao.ProductDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class ProductEditAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page="../login/login-adminreturn.jsp";
		
		try {
		HttpSession session=request.getSession();
			ProductDao dao=new ProductDao();
			ProductAction action=new ProductAction();
			
			if(session.getAttribute("admin")!=null) {
			
				int lentalnumber=Integer.parseInt(request.getParameter("rentalnumber"));
				int id=Integer.parseInt(request.getParameter("productid"));
				
				int count=dao.updateNumber(id,lentalnumber);
				
				if(count==0) {
					page="../login/login-admin.jsp";
				}
				page=action.excute(request, response);
			}
			
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page="../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page="../exception/rental-exception.jsp";
		}
			return page;
	}

}
