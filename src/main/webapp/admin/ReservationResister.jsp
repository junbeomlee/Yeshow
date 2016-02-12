<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.*"%>
<html>
<head>
	<title>예약접수</title>
</head>
<body>
	<h3>예약접수</h3>
	<%
		String user_name = request.getParameter("user_name");
		String user_phone = request.getParameter("user_phone");
		String reservation_date = request.getParameter("reservation_date");
		String reservation_time = request.getParameter("reservation_time");
		String server_name = request.getParameter("server_name");
		String reservation_etc = request.getParameter("reservation_etc");
	%>

	고객이름 : <%=user_name%> <br>
</body>
</html>