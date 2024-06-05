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
<h4>choose 태그로 홀짝 판단하기</h4>
<c:set var="num" value="100"></c:set>
<c:choose>
	<c:when test="${num mod 2 eq 0}">
	<!-- 조건이 true이면 실행 -->
	${num }은 짝수 입니다.
	</c:when>
	<c:otherwise>
	<!-- 아니면 실행 -->
	${num }은 홀수 입니다.
	</c:otherwise>
</c:choose>

<h4>국,영 점수를 입력하면 평균을 내어 학점 출력</h4>
<form>  <!-- 점수 입력 폼 -->
    국어 : <input type="text" name="kor" /> <br />
    영어 : <input type="text" name="eng" /> <br />
    <input type="submit" value="학점 구하기" />
</form>


	${empty param.kor }
    ${not empty param.kor }
    ${not empty param.kor and not empty param.eng}
    <!-- 파라메터로 전달받은 2개의 값이 비어있지 않으면 -->
    <hr>
    <c:if test="${not empty param.kor and not empty param.eng}">
		<c:set var="avg" value="${(param.kor+param.eng)/2 }"></c:set>
		국어 : ${param.kor }, 영어 : ${param.eng } <br>
		평균 : ${avg }    	
    	<c:choose>
    		<c:when test="${avg ge 90 }">A학점</c:when>
    		<c:when test="${avg ge 80 }">B학점</c:when>
    		<c:when test="${avg >= 70 }">C학점</c:when>
    		<c:when test="${avg >= 60 }">D학점</c:when>
    		<c:otherwise>F학점</c:otherwise>
    	</c:choose>
    
    </c:if>
    <br>
    











</body>
</html>