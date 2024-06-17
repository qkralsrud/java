<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msgBox{
	color:red;
}
</style>

</head>
<script type="text/javascript" src="/resources/js/signup.js"></script>
<%@include file="../common/header.jsp" %>
<%@include file="../common/modal.jsp" %>

<body>

<h2>회원가입</h2>
<form name="signupForm" action="/signupAction">
<div id="msgBox" style="color:red">아이디 중복체크후 메세지를 출력하는 부분</div>
아이디 : <input type="text" id="id" value=""><button id="checkIdBtn" type="button">아이디 중복체크</button>
<br>중복검사성공:1<input type="text" value="" id="checkIdTxt">
<br>비밀번호 : <input type="text" value="" id="pwTxt">
<br>비밀번호확인 : <input type="text" value="" id="pwCheckTxt">
<br><button id="signupActionBtn" type="button">회원가입</button>
</form>

<%@include file="../common/footer.jsp" %>
</body>
</html>