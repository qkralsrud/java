<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
도서정보 조회
<form action="/bookDetail" method="get">
	<input type="text" name="no" value="1">
	<button>도서조회</button>
</form>

도서목록 조회
BookListController
/bookList

/book/bookList.jsp

도서 입력
/bookInsert 요청을 BookInsertController 가 받아서 /book/bookInsert.jsp 를 출력하세요
도서 삭제
/bookDelete 요청을 BookDeleteController 가 받아서 /book/bookDelete.jsp 를 출력하세요
도서 수정
/bookUpdate 요청을 BookUpdateController 가 받아서 /book/bookUpdate.jsp 를 출력하세요

</body>
</html>