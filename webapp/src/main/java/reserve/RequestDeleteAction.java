package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ProductDao;
import reserve.dao.ReserveDao;
import tool.Action;

public class RequestDeleteAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		Lental lental=(Lental) session.getAttribute("lental");
		if(session.getAttribute("user")==null) {
			return "../login/login-return.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReserveDao dao=new ReserveDao();
		int count=dao.delete(id);
		
		if(count!=1){
			return "lental-detail.jsp";
		}
		
		int number=lental.getLentalNumber();
		id=lental.getProductId();
		
		ProductDao product=new ProductDao();
		
		product.changeNumber(id, number);		
		return "../reserve/LentalRequest.action";
	}

}
