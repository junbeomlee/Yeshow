<%@page contentType="text/html; charset=euc-kr"%>
<html>
<head>
	<title>예약완료페이지</title>
</head>
<body>
	<h3>예약이 완료되었습니다!</h3>
	<%request.setCharacterEncoding("UTF-8");%>
	이름: <%=request.getParameter("user_name")%><br>
	날짜: <%=request.getParameter("reservation_date")%><br>
	시간: <%=request.getParameter("reservation_time")%><br>
	담당자: <%=request.getParameter("server_name")%><br>
	서비스 내용: <%=request.getParameter("reservation_etc")%><br>

</body>
</html>