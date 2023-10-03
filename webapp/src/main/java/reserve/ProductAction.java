package reserve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import tool.Action;

public class ProductAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null&&session.getAttribute("admin")==null) {
			return "../login/login-return.jsp";
		}
		
		String keyword=request.getParameter("keyword");
		
		if(keyword==null) {
			keyword="";
		}
		
		ProductDao dao=new ProductDao();
		List<Product> productList=dao.select(keyword);
		
		session.setAttribute("productList", productList);
		
		if(session.getAttribute("admin")!=null) {
			return "../admin/admin-home.jsp";
		}
		
		return "../reserve/home.jsp";
	}


}
