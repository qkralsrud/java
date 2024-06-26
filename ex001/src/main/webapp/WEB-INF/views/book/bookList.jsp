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
			
			/*
			width:800px;
			border:1px solid;
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
	
	<!-- 관리자인 경우에만 버튼이 보여질수 있도록 처리 -->
	관리자여부 : ${memberDto.admin_yn eq 'Y' }
	<!-- 타이포그래피 > 정렬 -->
	<c:if test="${memberDto.admin_yn eq 'Y' }">
		<div class="text-end">
			<button type="button" id="bookRegBtn" class="btn btn-dark">도서등록</button>
		</div>
	</c:if>
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
	      <!-- 상세페이지에서 리스트로 돌아올때 페이지번호를 유지하기 위해서 pageNo를 넘겨줘야 해요!!! 
	      		내장객체에 저장된 값을 출력하는경우 저장된 이름으로 접근
	      		요청으로 전달된 파라메터의 경우 param.이름 으로 접근
	      -->
	      
	      <td><a href="/detailBook?no=${book.no }&pageNo=${map.pageDto.pageNo}">${book.title }</a></td>
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