package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;
import reserve.dao.ProductDAO;
import reserve.dao.ReserveDAO;
import tool.Action;

public class ReserveAction extends Action {

	public ReserveAction() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		ReserveDAO reserveDao=new ReserveDAO();
		ProductDAO productDao=new ProductDAO();
		User user=(User) session.getAttribute("user");
		int count=0;
		
		if(user==null) {
			return "../login/login.jsp";
		}
		
		String username=user.getName();
		
		int productId=Integer.parseInt(request.getParameter("productid"));
		int number=Integer.parseInt(request.getParameter("lentalnumber"));
		String returnDate=request.getParameter("date");	
		
		count=reserveDao.register(productId, number,username,returnDate);
		
		if(count!=1) {
			return "lental-false.jsp";
		}
		productDao.changeNumber(productId, number);
		return "lental-success.jsp";
	}

}
