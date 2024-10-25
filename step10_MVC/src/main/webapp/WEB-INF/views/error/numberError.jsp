<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>숫자만 입력해주세요</h1>
<h3>
	예외메시지: ${msg}<br>
	예외클래스: ${errClass}<br>
	예외상태클래스(status): ${statusCode} <br>
	
	<a href="${pageContext.request.contextPath}/ex03_exception.html">이동</a>
	<!-- 항상 루트(pageContext.request.contextPath) 기준으로 경로 설정하기 -->
</h3>
</body>
</html>