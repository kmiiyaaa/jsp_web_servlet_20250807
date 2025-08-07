<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h2>로그인 성공</h2>
		<hr>
		<%--
		<%
			String id = (String) session.getAttribute("id"); 
		%>
		 --%>
		 
		 
		 <%
			if(session.getAttribute("sid") == null) {
				response.sendRedirect("login.do");
			};
		%>
		 
		 
		<h2>로그인 성공</h2>
	<hr>
	<h3>[${sessionScope.sid }]님 환영합니다!</h3>
</body>
</html>