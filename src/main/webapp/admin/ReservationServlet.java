import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class ReservationServlet extends HttpServlet {
	public void doPost(HttpServletRequest request,
	HttpServletResponse response)
	throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String user_name = request.getParameter("user_name");
	String user_phone = request.getParameter("user_phone");
	String reservation_date = request.getParameter("reservation_date");
	String reservation_time = request.getParameter("reservation_time");
	String server_name = request.getParameter("server_name");
	String reservation_etc = request.getParameter("reservation_etc");

	response.setContentType("text/html; charset=euc-kr");
	

	PrintWriter out= response.getWriter();
	out.println("<HTMl>");
	out.println("<HEAD><TITLE>������Ȳ</TITLE></HEAD>");
	out.println("<BODY>");
	out.printf("%s�� %s %s �� %s���� %s�� ����Ǽ̽��ϴ�.",user_name,reservation_date,reservation_time,server_name,reservation_etc);
	out.println("</BODY>");
	out.println("</HTML>");
	}
}