package reserve;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;
import reserve.dao.ProductDao;
import reserve.dao.ReserveDao;
import tool.Action;

public class ReserveAction extends Action {

	public ReserveAction() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		ReserveDao reserveDao=new ReserveDao();
		ProductDao productDao=new ProductDao();
		User user=(User) session.getAttribute("user");
		Product product=(Product) session.getAttribute("product");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int count=0;
		
		if(user==null||product==null) {
			return "../login/login-return.jsp";
		}
		
		int userId=user.getId();
		
		int productId=Integer.parseInt(request.getParameter("productid"));
		String rentalNumber=request.getParameter("rentalnumber");
		
		int productnumber=product.getRentalNumber();
		String returnDate=request.getParameter("date");	
		Date todayDate=new Date();
		ArrayList<String> errorList=new ArrayList<>();
		
		if(rentalNumber==null||rentalNumber.equals("")) {
			errorList.add("申請数を入力してください。");
		}else if(Integer.parseInt(rentalNumber)>productnumber) {
			errorList.add("貸出可能数を超えた申請数です。");
		}
		if(returnDate==null||returnDate.equals("")) {
			errorList.add("返却期限を入力してください。");
		}else {
			Date date=format.parse(returnDate);
			if(date.before(todayDate)) {
				errorList.add("返却期限の入力が不正です。");
			}
		}
		
		if(errorList.isEmpty()) {
			count=reserveDao.register(productId,Integer.parseInt(rentalNumber),userId,returnDate);
			
			if(count!=1) {
				return "rental-false.jsp";
			}
			productDao.changeNumber(productId, Integer.parseInt(rentalNumber)*-1);
			return "rental-success.jsp";
		}
		request.setAttribute("errorMessageList", errorList);
		return "rentalreserve.jsp";
	}

}
