package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDAO;
import tool.Action;

public class LentalAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null) {
			return "../login/login.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ProductDAO dao=new ProductDAO();
		Product product=dao.selectById(id);
		
		session.setAttribute("product", product);
		
		return "lentalreserve.jsp";
	}


}
