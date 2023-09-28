package reserve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;
import reserve.dao.ReserveDao;
import tool.Action;

public class LentalRequestAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null) {
			return "../login/login.jsp";
		}
		
		String name=user.getName();
		
		if(name==null) {
			name="";
		}
			
		ReserveDao dao=new ReserveDao();
		List<Lental> lentalList=dao.selectByUser(name);
		
		session.setAttribute("lentalList", lentalList);
		
		return "../reserve/lental-request.jsp";

	}


}
