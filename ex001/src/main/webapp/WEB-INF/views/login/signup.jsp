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
<br>중복검사성공:1<input type="text" value="" id="checkIdTxt">


<div class="w-75 mx-auto">
	<h2>회원가입</h2>
	
	<!-- Form에 정의된 요소를 서버에 전달 하기 위해서 
				수집하려는 DTO의 필드에 맞춰서 name 속성을 지정 -->
	<form name="signupForm" action="/signupAction">
	<div id="msgBox"></div>
	<div class="row mb-3">
	  <div class="col">
	    <input type="text" class="form-control" placeholder="아이디" id="id" name="id">
	  </div>
	  <div class="col">
	    <button type="button" class="form-control btn btn-primary" id="checkIdBtn">아이디 중복체크</button>
	  </div>
	</div>
	<div class="mb-3">
	  <input type="text" class="form-control" placeholder="이름" id="name" name="name">
	</div>
	<div class="mb-3">
	  <input type="text" class="form-control" placeholder="비밀번호" id="pwTxt" name="pw">
	</div>
	<div class="mb-3">
	  <input type="text" class="form-control" placeholder="비밀번호 확인" id="pwCheckTxt">
	</div>
	<div class="mb-3">
	  <button type="button" class="form-control btn btn-primary" id="signupActionBtn">회원가입</button>
	</div>
	
	</form>
</div>
<%@include file="../common/footer.jsp" %>
</body>
</html>