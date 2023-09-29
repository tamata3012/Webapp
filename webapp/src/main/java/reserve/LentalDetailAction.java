package reserve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDao;
import tool.Action;

public class LentalDetailAction extends Action {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null) {
			return "../login/login-return.jsp";
		}
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		ReserveDao dao=new ReserveDao();
		Lental lental=dao.selectById(id);
		
		session.setAttribute("lental", lental);
		
		return "lental-detail.jsp";
	}

}
