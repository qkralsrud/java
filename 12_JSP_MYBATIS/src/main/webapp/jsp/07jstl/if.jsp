<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 변수선언 -->
<c:set var="number" value="100"></c:set>
<c:set var="string" value="JSP"></c:set>

<h4>JSTL의 if 태그로 짝수/홀수 판단하기</h4>
<c:if test="${number mod 2 eq 0}" var="result">
<!-- test결과가 참이면 실행 -->
${number }는 짝수 입니다.
</c:if>
result : ${result }

<h4>문자열 비교와 else 구문 흉내내기</h4>
<c:if test="${string eq 'Java' }" var="result2"> 
	문자열은 Java입니다.
</c:if>
<c:if test="${not result2}">
	문자열은 Java가 아닙니다.
</c:if>

<h4>조건식 주의사항</h4>
<c:if test="문자100" var="result3">
	EL표현식이 아닌경우 값이 입력된경우 false
</c:if>
result3 : ${result3 }
<br>
<c:if test="truE" var="result4">
	EL표현식이 아닌경우 true는 대소문자 구분없이 true
</c:if>
result4 : ${result4 }

<c:if test=" truE" var="result5">
	EL표현식이 아닌경우 true에 공백이 들어간 경우 false
</c:if>
result5 : ${result5 }







</body>
</html>