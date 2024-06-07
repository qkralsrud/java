<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일업로드
	1. cos.jar 라이브러리 다운로드 
		WEB-INF/lib 폴더에 추가
	
	2. 입력 form 작성
		method : post방식으로 지정
		enctype = "multipart/form-data" <- 오타시 오류발생
		enctype : 폼 값을 서버로 전송할 때의 인코딩 방식을 지정하는 속성
 -->
 <form action="/fileUpload" method="post" 
 				enctype="multipart/form-data">
 				
 	<input type="text" name="name">
 	<input type="text" name="id">
 	<input type="file" name="file">
 	<button>파일업로드</button>
 </form>
 
</body>
</html>