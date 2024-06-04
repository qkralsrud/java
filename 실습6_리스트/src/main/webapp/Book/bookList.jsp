<%@page import="com.human.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록 조회</title>
<script type="text/javascript">
	function go(pageNo){
		document.location='/bookList?pageNo='+pageNo;
	}
</script>
</head>
<body>
<h2>도서목록</h2>
<%
	System.out.print("목록 : " + request.getAttribute("list"));
	if(request.getAttribute("list") != null){
		List<BookDTO> list = (List<BookDTO>)request.getAttribute("list");
		for(BookDTO book : list){
			out.print(book.getTitle() + " ");
			out.print(book.getAuthor() + " ");
			out.print(book.getRent_yn() + " <br>" );
		}
	}else{
		out.print("게시글이 존재하지 않습니다.");
	}
%>
<!-- 외부파일을 불러옵니다. -->
<%@ include file = "/common/pageNavi.jsp" %>
</body>
</html>