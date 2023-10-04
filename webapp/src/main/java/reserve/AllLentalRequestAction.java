package reserve;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import reserve.dao.ReserveDao;
import tool.Action;

public class AllLentalRequestAction extends Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("admin")==null) {
			return "../login/login-adminreturn.jsp";
		}
		
			
		ReserveDao dao=new ReserveDao();
		List<Lental> lentalList=dao.select();
		
		session.setAttribute("lentalList", lentalList);
		
		return "../admin/lental-allrequest.jsp";

	}


}
