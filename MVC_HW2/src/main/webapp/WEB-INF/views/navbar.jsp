<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <nav id="navbar">
    <!-- 5개의 메뉴생성 -->
      <ul>
        
        <c:if test="${userDto!=null}">
             <li class="nav-item">${sessionScope.userDto.name}님</li>
        </c:if>
        
        <li class="nav-item logo"><a href="index.jsp"><img src="${pageContext.request.contextPath}/resources/images/logo.jpg" alt="로고입니다." ></a></li>
       <li class="nav-item"> <a href="${pageContext.request.contextPath}/personal">개인</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/business">기업</a></li>
        
       <c:choose>
         <c:when test="${empty sessionScope.userDto}">
               <li class="nav-item"><a href="${pageContext.request.contextPath}/login">로그인</a></li>
               <li class="nav-item"><a href="${pageContext.request.contextPath}/register">회원가입</a></li>
         </c:when>
         <c:otherwise>
             <li class="nav-item"><a href="#" onclick="logout('${pageContext.request.contextPath}')">로그아웃</a></li>
         </c:otherwise>
       </c:choose>
        
        
      </ul>
      
    </nav>



</body>
</html>