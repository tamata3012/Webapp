package admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Product;
import reserve.ProductAction;
import reserve.dao.ProductDao;
import tool.Action;

public class ProductRegisterAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session=request.getSession();
		ProductDao dao=new ProductDao();
		ProductAction action=new ProductAction();
		String page="../admin/product-register.jsp";
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
		String name=request.getParameter("productName");
		int lentalnumber=Integer.parseInt(request.getParameter("rentalNumber"));
		
		Product product=dao.selectByName(name);
		if(product==null) {
			dao.register(name,lentalnumber);
			page=action.excute(request, response);
		}
		return page;
	}

}
