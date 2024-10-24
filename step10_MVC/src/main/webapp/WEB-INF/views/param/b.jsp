<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> param/b.do 요청결과 입니다 : </h1>
	<h3> ${list}</h3>
	
	<c:forEach var="item" items="${list}">
		<li>${item}</li>
	</c:forEach>
</body>
</html>