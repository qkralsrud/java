<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.addEventListener('load', ()=>{
		// 페이지처리
		searchForm.action = "/boardList";
		
		// 검색 옵션 등록
		let opt = document.createElement('option');
		opt.text='제목';
		opt.value='title';
		searchField.appendChild(opt);
		
		let opt1 = document.createElement('option');
		opt1.text='작성자';
		opt1.value='user_id';
		searchField.appendChild(opt1);
		
		let opt2 = document.createElement('option');
		opt2.text='내용';
		opt2.value='contents';
		searchField.appendChild(opt2);
		
		let trList = document.querySelectorAll("tr");
		// 배열의 각요소에 이벤트를 적용
		trList.forEach(
			function(item){
	    		item.addEventListener('click', function(){
		        	let board_no = item.dataset.no;
		        	location.href="/boardDetail?board_no="+board_no+"&pageNo=${map.pageDto.pageNo}";
	    	})
		});
	})
</script>
</head>
<body>
pageDto : ${map.pageDto }
<%@include file="../common/header.jsp" %>

<main>
<h2>자유게시판</h2>
<%@include file="../common/searchForm.jsp" %>
<table class="table table-striped">
	<thead>
	<tr>
		<th>no</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	</thead>
	
	<c:choose>
		<c:when test="${empty map.list }">
			<tr><td colspan="5">게시글이 존재하지 않습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${map.list }" var="board">
			<!-- 
				
				1. 태그의 속성에 데이터 값을 보관 
				data-* : HTML요서에 추가적인 데이터 속성을 저장 하고 
						javaScript에서 불러다 사용
				2. 보관된 데이터를 가지고 오는 방법
				요소선택.dataset.변수명
			-->
			<tr data-no="${board.board_no }">
				<td>
					<c:choose>
						<c:when test="${board.board_type eq '추천'}">
							추천
						</c:when>
						<c:otherwise>
							${board.board_no }							
						</c:otherwise>
					</c:choose>
				
				
				</td>
				<!-- ${board.board_type } : 통합게시판용 컬럼 -->
				<td>${board.title }</td>
				<td>${board.user_id }</td>
				<td>${board.created_time }</td>
				<td>${board.counts }</td>
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
</table>
<%@include file="../common/pageNavi.jsp" %>
</main>
<%@include file="../common/footer.jsp" %>
</body>
</html>