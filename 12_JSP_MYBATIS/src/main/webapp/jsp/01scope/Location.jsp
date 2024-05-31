<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>페이지 영역에 저장된 속성을 출력</h2>
<hr>
<!-- 값이 존재 하지 않는 경우, null을 출력 -->
<%=pageContext.getAttribute("pageInteger") %>

<!-- 값이 존재 하지 않는경우 아무것도 찍히지 않음-->
${pageInteger}
${pageString}
<!-- 존재하지 않는 객체의 경우, 속성에 접근시 오류가 발생 하지 않음-->
${pageObject.title}
<hr>
<h5>request 영역에 저장된 속성을 출력</h5>
<!-- request.getAttribute() -->
${requestString} / ${requestObject.title } <br> 
<!-- param으로 시작 하는 것은 request.getparamater() -->
${param.param}

<h5>session 영역에 저장된 속성을 출력</h5>
${userId }님 환영합니다.

<h5>Application 영역에 저장된 속성을 출력</h5>
${book }







</body>
</html>