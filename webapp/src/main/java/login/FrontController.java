package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/login/LoginServlet"})
public class FrontController extends HttpServlet{

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String url="login-error.jsp";
		//String url=null;
		
		LoginAction action=new LoginAction();
		
		try {
			url=action.excute(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		doPost(request,response);
	}

	
}
