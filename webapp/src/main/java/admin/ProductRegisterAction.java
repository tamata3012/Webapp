package admin;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.Product;
import reserve.ProductAction;
import reserve.dao.ProductDao;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class ProductRegisterAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page="../admin/product-register.jsp";
		
		try {
			HttpSession session=request.getSession();
			ProductDao dao=new ProductDao();
			ProductAction action=new ProductAction();
			
			ArrayList<String> errorList=new ArrayList<>();
			
			if(session.getAttribute("admin")==null) {
				return "../login/login-adminreturn.jsp";
			}
			
			String name=request.getParameter("productName");
			String rentalnumber=request.getParameter("rentalNumber");
			
			if(name==null||name.equals("")) {
				errorList.add("名前が入力されてません");
			}
			if(rentalnumber==null||rentalnumber.equals("")) {
				errorList.add("数量が入力されてません");
			}
			
			if(errorList.isEmpty()) {
				Product product=dao.selectByName(name);
				if(product==null) {
					dao.register(name,Integer.parseInt(rentalnumber));
					page=action.excute(request, response);
				}
			}
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page= "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page="../exception/rental-exception.jsp";
		}
		return page;
	}

}
