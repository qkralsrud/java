<%@page import="com.spring.ex001.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.122.0">
    <title>로그인</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- 외부 CSS파일 연결-->
    <link rel="stylesheet" href="/resources/css/login.css">
	<!-- 외부 Script파일 연결-->
	<script type="text/javascript" src="/resources/js/login.js"></script>
	<script type="text/javascript" src="/resources/js/common.js"></script>
	
	
	
	
<%-- JSP주석
	String id = CookieManager.getCookieValue(request, "id");
--%>
    
    <!-- Custom styles for this template 
    <link href="sign-in.css" rel="stylesheet">-->
  </head>
  <body class="d-flex align-items-center py-4 bg-body-tertiary">
  <main class="form-signin w-100 m-auto">
  
  <!-- -----------------             로그인     ------------------------ -->
    <form action="/loginAction" method="post" id="loginForm">
      <!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
      <h1 class="h3 mb-3 fw-normal">영등포 도서관</h1>
		${msg }
      <div class="form-floating">
        <input type="text" class="form-control" name="id" id="floatingInput" placeholder="name@example.com"
        		 value="${saveCookieId }">
        <label for="floatingInput">id</label>
      </div>
      <div class="form-floating">
        <input type="password" class="form-control" name="pw" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Password</label>
      </div>

      <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" name="chkSaveId" value="1" id="flexCheckDefault"
        			${empty saveCookieId ? "":"checked" }>
        <label class="form-check-label" for="flexCheckDefault">
          아이디 저장
        </label>
      </div>
      <button class="btn btn-primary w-100 py-2" type="submit">로그인</button>
      <p></p>
      <button class="btn btn-secondary w-100 py-2" type="button" id="signupBtn">회원가입</button>
      <p class="text-center"> 
      	  <a href = "javascript:fn_findId()">아이디찾기</a>
      	  <a href = "javascript:fn_setPw()">비밀번호재설정</a>
      </p>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
    </form>
    
   <!-- -----------------             아이디찾기     ------------------------ --> 
    <form action="/findId" method="post" id="findId" class="none">
      <!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
      <h1 class="h3 mb-3 fw-normal">영등포 도서관</h1>
      	<!-- 아이디 찾기의 결과를 출력 -->
		<p id=findIdMsgBox></p>
      <div class="form-floating">
        <input type="text" class="form-control" name="name" id="findId_name">
        <label for="floatingInput">이름</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" name="email" id="findId_email">
        <label for="floatingPassword">이메일</label>
      </div>
      <p></p>
	  <p>
      	<button class="btn btn-primary w-100 py-2" type="button" onClick="fn_findIdAction()">아이디 찾기</button>
      </p>
      
      <p class="text-center"> 
      	  <a href = "javascript:fn_login()">로그인</a>
      	  <a href = "javascript:fn_setPw()">비밀번호재설정</a>
      </p>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
    </form>
   <!-- -----------------             비밀번호 재설정     ------------------------ --> 
    <form action="/findId" method="post" id="setPwForm" class="none">
      <!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
      <h1 class="h3 mb-3 fw-normal">영등포 도서관</h1>
      	<!-- 아이디 찾기의 결과를 출력 -->
		<p id=findIdMsgBox></p>
      <div class="form-floating">
        <input type="text" class="form-control" name="id" id="setPw_name">
        <label for="floatingInput">아이디</label>
      </div>
      <div class="form-floating">
        <input type="text" class="form-control" name="email" id="setPw_email">
        <label for="floatingPassword">이메일</label>
      </div>
      <p></p>
	  <p>
      	<button class="btn btn-primary w-100 py-2" type="button" onClick="fn_setPwAction()">비밀번호 재설정</button>
      </p>
      <div id="setPwBox">
      <p class="form-floating">
      	<input type="text" class="form-control" name="pw" id="setPw">
        <label for="setPw">비밀번호 재설정</label>
      </p>
      <p class="form-floating">
      	<input type="text" class="form-control" name="pw_check" id="setPw_check">
        <label for="setPw_check">비밀번호 확인</label>
      </p>
      <p>
      	<button class="btn btn-primary w-100 py-2" type="button" onClick="fn_setPwAction()">비밀번호 저장</button>
      </p>
      </div>
      <p class="text-center"> 
      	  <a href = "javascript:fn_login()">로그인</a>
      	  <a href = "javascript:fn_findId()">아이디찾기</a>
      </p>
      <p class="mt-5 mb-3 text-body-secondary">&copy; 2017–2024</p>
    </form> 
    
  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

    </body>
</html>
    