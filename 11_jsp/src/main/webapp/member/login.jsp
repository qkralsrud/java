<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<!-- 서버에 요청 하는 방법
	주소표시줄에 url입력
	form 태그에 action 지정 
	링크를 걸어주거나 
-->
${msg}
<form action="/member/loginAction" method= "post">
	<input type="text" name="id" value="momo"><br>
	<input type="text" name="pw" value="1234"><br>
	<button>로그인</button>
</form>

</body>
</html>













































