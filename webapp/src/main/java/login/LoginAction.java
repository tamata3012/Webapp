package login;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.dao.LoginDao;
import reserve.ProductAction;
import tool.Action;
import tool.RentalException;
import tool.RentalRuntimeException;

public class LoginAction extends Action{
	


	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			
			HttpSession session=request.getSession();
			
			if(session.getAttribute("admin")!=null) {
				session.removeAttribute("admin");;
			}
			
			String page="login.jsp";
			
			ProductAction productAction=new ProductAction();
			
			String name=request.getParameter("username");
			String password=request.getParameter("password");
			LoginDao dao=new LoginDao();
			
			ArrayList<String> errorList=new ArrayList<>();
			
			if(name==null||name.equals("")) {
				errorList.add("名前が入力されてません");
			}
			if(password==null||password.equals("")) {
				errorList.add("パスワードが入力されてません");
			}
			
			if(errorList.isEmpty()) {
				User user=dao.search(name, password);
				if(user!=null) {
					session.setAttribute("user", user);
					page=productAction.excute(request, response);
				}else {
					errorList.add("ユーザー名かパスワードが間違っています。");
				}
			}
			request.setAttribute("errorMessageList", errorList);
			return page;
		}catch(RentalException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}catch(RentalRuntimeException e) {
			request.setAttribute("errorMessage", e.getMessage());
			return "../exception/rental-exception.jsp";
		}
	}

}
