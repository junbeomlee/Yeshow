<%@page contentType="text/html; charset=euc-kr"%>
<html>
<head>
	<title>����Ϸ�������</title>
</head>
<body>
	<h3>������ �Ϸ�Ǿ����ϴ�!</h3>
	<%request.setCharacterEncoding("UTF-8");%>
	�̸�: <%=request.getParameter("user_name")%><br>
	��¥: <%=request.getParameter("reservation_date")%><br>
	�ð�: <%=request.getParameter("reservation_time")%><br>
	�����: <%=request.getParameter("server_name")%><br>
	���� ����: <%=request.getParameter("reservation_etc")%><br>

</body>
</html>