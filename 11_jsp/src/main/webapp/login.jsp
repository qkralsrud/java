<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello JSP</title>
</head>
<body>
<!-- 
1. 플젝 생성 - Dynamic Web Project 
2.웰컴파일 작성 합니다. 
	-web.xml 파일에서 웰컴파일목록을 확인 할 수 있음
	-wbd-app 폴더에 작성(index.jsp)
3.서버에 플젝을 추가하고 실행 
	-jsp파일 실행시 ctrl + f11 서버를 선택 하는 창이 뜨고 서버를 선택후 실행
		> 자동으로 웹 브라우져를 띄워줌 
	-서버 탭에서 서버를 선택후 마우스 우클릭 > add and remove 메뉴를 선택후 finish
		서버탭에서 서버를 실행 > 웹브라우저에 주소를 입력하여 요청
--> 
로그인 <br>
<a href="/bookList">도서목록 바로가기</a>
<!-- login.jsp > 서블릿 요청 (/member/loginAction)
		  > loginAction.jsp페이지 전환 --> 

<!-- 요청할 페이지 정보와 요청방식을 지정 -->
<h1>서블릿을 요청해봅시다 </h1>
${msg }
<br>

<form action="/member/loginAction" method="post">
	id <input type="text" name="id" value="momo"><br>
	pw <input type="text" name="pw" value="1234"><br>
	<button>로그인 </button>
</form>

</body>
</html>