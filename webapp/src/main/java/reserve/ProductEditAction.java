package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import tool.Action;

public class ProductEditAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		HttpSession session=request.getSession();
		ProductDao dao=new ProductDao();
		ProductAction action=new ProductAction();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
		int lentalnumber=Integer.parseInt(request.getParameter("lentalnumber"));
		int id=Integer.parseInt(request.getParameter("productid"));
		
		int count=dao.updateNumber(id,lentalnumber);
		
		if(count==0) {
			return "../login/login-admin.jsp";
		}
		
		String page=action.excute(request, response);
		
		return page;
	}

}
