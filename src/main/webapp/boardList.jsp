<%@page import="com.kmii.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<style>
	body {
		font-family: '맑은 고딕', sans-serif;
		background-color: #f9f9f9;
		padding: 30px;
	}

	h2 {
		color: #003366;
		border-bottom: 2px solid #003366;
		padding-bottom: 10px;
		width: 800px;
		margin-bottom: 20px;
	}

	table {
		width: 700px;
		border-collapse: collapse;
		background-color: white;
		box-shadow: 0 0 10px rgba(0,0,0,0.1);
	}

	th, td {
		border: 1px solid #ccc;
		padding: 12px;
		text-align: center;
		font-size: 15px;
	}

	th {
		background-color: #004080;
		color: white;
	}

	tr:nth-child(even) {
		background-color: #f2f6fb;
	}

	tr:hover {
		background-color: #dce6f1;
	}

	a {
		text-decoration: none;
		color: #004080;
		font-weight: bold;
	}

	a:hover {
		color: #00264d;
		text-decoration: underline;
	}
</style>


<title>자유 게시판</title>
</head>
<body>
	
	<h2>자유 게시판 목록</h2>
	<hr>
	<table >
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>
		
		
		<c:forEach var="boardDto" items="${boardList}" varStatus="status">  <!--  boardDto는 임시이름 / items안에는 배열과 collection / 순서가 없는건 들어올 수 없다 -->
			<tr>
				<td>${status.count}</td>
				<td>
				<!-- 게시판 글 제목이 30자 이상일때 30자 이상은 ...표시  -->
					<c:choose>
						<c:when test="${fn:length(boardDto.btitle)>30}">
							<a href="#">${fn:substring(boardDto.btitle,0,30)}...</a>
						</c:when>
						<c:otherwise>
							<a href="#">${boardDto.btitle}</a>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${boardDto.bwriter}</td>
				<td>${boardDto.bdate}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>