<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>userResult page</h1>
	이름:${userVo.name}<br><!-- userVo 에서 get -->
	아이디:${userVo.id}<br>
	나이:${userVo.age}<br>
	주소:${userVo.addr}<br>
	
	이름:${user.name}<br><!-- userVo 에서 get -->
	아이디:${user.id}<br>
	나이:${user.age}<br>
	주소:${user.addr}<br>
	
	메시지:${msg}<br>
	메뉴:${menu}
</body>
</html>