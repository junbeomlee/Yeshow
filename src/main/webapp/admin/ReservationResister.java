package yeshow.reservation;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReservationResister extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestProcess(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		requestProcess(request,response);
	}

	public void requestProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out=response.getWriter();

		String user_name=request.getParameter("user_name");
		String user_phone=request.getParameter("user_phone");
		String reservation_date=request.getParameter("reservation_date");
		String reservation_time=request.getParameter("reservation_time");
		String server_name=request.getParameter("server_name");
		String reservation_etc=request.getParameter("reservation_etc");

		String str="<b>"+user_name+"</b>";
		out.println(str);
		out.close();
	}
}