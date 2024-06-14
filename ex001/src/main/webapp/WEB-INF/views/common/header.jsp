<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.form-control-dark {
  border-color: var(--bs-gray);
}
.form-control-dark:focus {
  border-color: #fff;
  box-shadow: 0 0 0 .25rem rgba(255, 255, 255, .25);
}

.text-small {
  font-size: 85%;
}

.dropdown-toggle:not(:focus) {
  outline: 0;
}
</style>

<script type="text/javascript">
	window.onload = function(){
		let logoutBtn = document.querySelector( "#logoutBtn");
		let loginBtn = document.querySelector("#loginBtn");
		let signupBtn = document.querySelector("#signupBtn");
		
		if(logoutBtn != null){
				// 로그아웃 버튼이 클릭되면 실행 함수를 추가
			logoutBtn.addEventListener('click',function(){
				location.href="/logout";
			});
		}
		if(loginBtn != null){
			loginBtn.addEventListener('click',function(){
				//로그인 페이지로 이동
				location.href="/login";
				//alert('클릭'); alert을 해둔건 작동이 되는지 확인하기 위함 
			});
			signupBtn.addEventListener('click',function(){
				//회원가입 페이지로 이동
				location.href="/signup";
			});
		}
	}
</script>

</head>
<body>

<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-3 mb-2 mb-md-0">
        <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
          <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
        </a>
      </div>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="#" class="nav-link px-2 link-secondary">Home</a></li>
        <li><a href="#" class="nav-link px-2">Features</a></li>
        <li><a href="#" class="nav-link px-2">Pricing</a></li>
        <li><a href="#" class="nav-link px-2">FAQs</a></li>
        <li><a href="#" class="nav-link px-2">About</a></li>
      </ul>

      <div class="col-md-3 text-end">
      <c:choose>
      	<c:when test="${empty sessionScope.id }">
	      	<button type="button" id="loginBtn" class="btn btn-outline-primary me-2">Login</button>
	        <button type="button" id="signupBtn" class="btn btn-primary">Sign-up</button>
      	</c:when>
      	<c:otherwise>
      		<button type="button" id="logoutBtn" class="btn btn-outline-primary me-2">Logout</button>
      	</c:otherwise>
      </c:choose>
      
      
        
      </div>
    </header>
</div>

</body>
</html>