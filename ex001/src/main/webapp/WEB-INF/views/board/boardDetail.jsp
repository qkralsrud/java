<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener('load', function(){
		listBtn.addEventListener('click', function(){
			console.log('listBtn Click');
			location.href = "/boardList?pageNo=${param.pageNo}"
		});
		
		if(${board.user_id eq id}){
			editBtn.addEventListener('click', function(){
				console.log('editBtn Click');
				
			});
			
			delBtn.addEventListener('click', function(){
				console.log('delBtn Click');
				location.href="/boardDelete?board_no=${board.board_no}&pageNo=${param.pageNo}";
				
			});
		}
	})
</script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<main>
<h2>게시판 상세</h2>

<table class="table table-striped table-sm">
	<tr>
		<td>제목</td>
		<td>${board.title }</td>
		<td>작성자</td>
		<td>${board.user_id }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td colspan="3">${board.title }</td>
	</tr>
	<tr>
		<td colspan="4">
			<button type="button" id="listBtn">리스트</button>
			<!-- 게시글의 작성자만 보여줌 -->
			<c:if test="${board.user_id eq id }">
				<button type="button" id="editBtn">수정</button>
				<button type="button" id="delBtn">삭제</button>
			</c:if>
		</td>
	</tr>
</table>

</main>
<%@ include file="../common/footer.jsp" %>
</body>
</html>