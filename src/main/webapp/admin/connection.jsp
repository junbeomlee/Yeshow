<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.*"%>
<html>
<head>
	<title>데이터베이스 연결하기</title>
</head>
<body>
	<h3>데이터베이스 연결 테스트</h3>
	<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/yeshow","root","1234");
		if (conn!=null){
		out.println("yeshow데이터베이스로 연결했습니다. <br>");
		
	}
		else {
		out.println("yeshow데이터베이스로 연결할 수 없습니다.<br>");
	}

	Statement stmt = conn.createStatement();

	stmt.executeQuery("select * from user;");
	%>
</body>
</html>