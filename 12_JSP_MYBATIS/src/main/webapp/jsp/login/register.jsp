<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form action="/register">
	아이디 : <input type="text" name="id" value="momo"><br>
	성별 : <input type="radio" name="sex" value="M">남자
		  <input type="radio" name="sex" value="F" checked>여자<br>   
	관심사항 : <input type="checkbox" name="favo" value="eco">경제
			 <input type="checkbox" name="favo" value="pol" checked>정치
			 <input type="checkbox" name="favo" value="ent">연예<br>
	자기소개 : <textarea name="intro" rows="5" cols="30"></textarea><br>
	
	<button>전송</button>
	
	
	
</form>
</body>
</html>