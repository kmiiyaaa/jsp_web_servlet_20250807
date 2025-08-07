<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%--
		<%
			String id = (String) session.getAttribute("id"); 
		%>
		 --%>
		 
		 
		<%   // 로그인 하지 않고 welcome 페이지 들어오지못하게 처리
			if(session.getAttribute("sid") == null) { 
				response.sendRedirect("login.do");
			};
		%>
		 
		 
		<h2>로그인 성공</h2>
	<hr>
	<h3>[${mid}]님 환영합니다!</h3>
	<hr>
	<a href="freeboard.do">게시판보기</a>
	<hr>
	<a href="logout.do">로그아웃</a>
	
</body>
</html>