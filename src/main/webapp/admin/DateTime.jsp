<%@page contentType="text/html; charset=euc-kr"%>
<%@page import="java.util.GregorianCalendar"%>
<html>
<head>
	<title>��¥�� �ð�</title>
</head>
<body>
	<%
		GregorianCalendar now= new GregorianCalendar();
		String date= String.format("%TF",now);
		String time= String.format("%TT",now);
	%>
	������ ��¥: <%= date%> <br>
	������ �ð�: <%= time%> <br>

</body>
</html>