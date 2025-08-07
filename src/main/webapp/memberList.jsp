<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
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
</head>
<body>
		<h2>회원 목록 보기</h2>


		<table>
				<tr>
					<th>No.</th>
					<th>회원 아이디</th>
					<th>회원 이름</th>
					<th>회원 나이</th>
					<th>회원 등록일</th>
				</tr>
				
				<c:forEach var="memberDto" items="${memberList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${memberDto.mid}</td>
					<td>${memberDto.mname}</td>
					<td>${memberDto.mage}</td>
					<td>${memberDto.mdate}</td>
			
				</tr>
				
				
				
				</c:forEach>
		
		</table>
		
		  <a href = "welcome.do"> 뒤로 돌아가기 </a>
		<!-- 자바 스크립트 뒤로가기
		<a href = "javascript:history.go(-1);">뒤로 돌아가기</a> 그냥 뒤로가는거만은 이걸 더 쓴다 --> 
		<input type="button" value="뒤로가기" onclick="javascript:history.go(-1)">

</body>
</html>