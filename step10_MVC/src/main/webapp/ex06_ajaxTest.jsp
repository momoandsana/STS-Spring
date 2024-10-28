<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script type="text/javascript">
  $(function(){
	  //alert("되니?");
	  
	  $("#btn").click(function(){
		  $.ajax({
      		url:"${pageContext.request.contextPath}/ajax.do",
      		type:"post",
      		data: {email:"jang" , pwd : "1234" } ,
      		dataType:"text", //text |xml | html | json
      		success: function(result){
      			console.log(result);
      		},
      		error : function(jqXHR, textStatus, errorThrown){
      			alert("문제 발생 : " + jqXHR.status)
      		}
      		
      	}); 
	  });//btnEnd
	  
$("#btn2").click(function(){
		  
		  let jsonData ={id:"jang" , name : "희정",   age:20 , addr:"서울" }
		  
		  $.ajax({
    		url:"${pageContext.request.contextPath}/ajax2.do",
    		type:"post",
    		data:jsonData ,
    		dataType:"text", //text |xml | html | json
    		success: function(result){
    			console.log(result);
    			
    		},
    		error : function(jqXHR, textStatus, errorThrown){
    			alert("문제 발생 : " + jqXHR.status)
    		}
    		
    	}); 
	  });//btnEnd
	  
	  
	  /**
	    JSON형태로 데이터 보내기 
	  */
	  $("#btn3").click(function(){
		  
		  let jsonData ={id:"jang" , name : "희정",   age:20 , addr:"서울" }
		  
		  $.ajax({
      		url:"${pageContext.request.contextPath}/ajax3.do",
      		type:"post",
      		contentType:"application/json;charset=UTF-8",
      		data:JSON.stringify(jsonData) ,
      		dataType:"text", //text |xml | html | json
      		success: function(result){
      			alert(result)
      			
      		},
      		error : function(jqXHR, textStatus, errorThrown){
      			alert("문제 발생 : " + jqXHR.status)
      		}
      		
      	}); 
	  });//btnEnd
	  
  })//readyEnd

</script>
</head>
<body>
<h2>AjaxTest</h2>
<button id="btn">클릭1</button>
<button id="btn2">클릭2</button>
<button id="btn3">클릭3</button>

</body>
</html>