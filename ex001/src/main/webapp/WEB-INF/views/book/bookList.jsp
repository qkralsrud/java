<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<!-- 부트스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
	<style type="text/css">
		main {
			margin:0 auto;
			width:800px;
			/*border:1px solid;
			border-radius: 20px;*/
			padding:20px;
		}
	</style>
	
	<script type="text/javascript">
	window.addEventListener('load', function(){
		// 버튼 선택
		let bookRegBtn = document.querySelector('#bookRegBtn'); 
		// 버튼 클릭이벤트 부여
		bookRegBtn.addEventListener('click', function(){
			// 페이지 이동 /bookReg
			location.href = "/bookReg";
		});
		
	});
	
	</script>
</head>
<body>

<!-- header -->
<%@include file="../common/header.jsp" %>

<!-- id : ${id } / modelId : ${modelId } / rttrId : ${rttrId } / 총 건수 : ${map.pageDto.totalCnt } -->
<main>
	<h2>도서목록</h2>
	<form action="/bookList" name="searchForm">
		<input type="hidden" name="pageNo" value="${map.pageDto.pageNo }">
	</form>
	<button type="button" id="bookRegBtn" class="btn btn-dark">도서등록</button>
	<table class="table table-striped">
	  <thead>
	  	<!-- 타이틀 -->
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">도서명</th>
	      <th scope="col">작가명</th>
	      <th scope="col">대여여부</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${map.list }" var="book">
	    <tr>
	      <th scope="row">${book.no }</th>
	      <td><a href="/detailBook?no=${book.no }">${book.title }</a></td>
	      <td>${book.author }</td>
	      <td>${book.rent_yn_str }</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
	<%@ include file="/WEB-INF/views/common/pageNavi.jsp" %>
	
	
</main>


<%@include file="../common/footer.jsp" %>	
<!-- 부트스트랩 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>