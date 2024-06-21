<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.addEventListener('load', ()=>{
		listBtn.addEventListener('click', ()=>{
			// 리스트로 이동시 페이지 번호를 전달
			// 페이지 번호를 전달 하지 않으면 무조건 1페이지로 (cri의 기본값)
			// 사용자가 보고있던 페이지를 보여주기 위해서 pageNo 파라메터가 필요
			
			// 링크를 이용해서 화면을 이동
			//location.href = "/bookList?pageNo=${param.pageNo}";
			
			// form을 이용해서 화면을 이동
			detailForm.action = '/bookList';
			detailForm.submit();
		});
		delBtn.addEventListener('click', ()=>{
			detailForm.action = '/delBook';
			// form 전송
			detailForm.submit();
		});
	});
</script>
</head>
<body>
<%@include file="../common/header.jsp" %>
<main>
<h2>상세보기</h2>
<form action="" method="get" name="detailForm">
	<input type="text" name="pageNo" value="${param.pageNo }">
	<input type="text" name="no" value="${param.no }">
</form>
<table class="table">
	<tr>
		<th class="table-active">제목</th>
		<td>${map.book.title }</td>
		<th class="table-active">대여여부</th>
		<td>${map.book.rent_yn_str }</td>
	</tr>
	<tr>
		<th class="table-active">작가</td>
		<td>${map.book.author }</td>
		<th class="table-active">가격</td>
		<td>${map.book.price }</td>
	</tr>
	<tr>
		<th class="table-active">출판사</td>
		<td>${map.book.publisher }</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<th class="table-active">첨부파일</td>
		<td colspan="3">
			
			<c:choose>
				<c:when test="${empty map.fileList }">
					등록된 첨부파일이 없습니다.
				</c:when>
				<c:otherwise>
					<c:forEach items="${map.fileList }" var="file">
						<!-- 파일 다운로드를 위해 원본파일명과 저장된 파일명을 서버에 파라메터로 전달합니다 -->
						<a href = "/download?oname=${file.ofilename }&sname=${file.sfilename }">
									${file.ofilename }</a><br>
									
					</c:forEach>
					<!-- 업로드된 파일을 화면에 이미지로 출력 하는 방법
							파일명의 확장자가 이미지인 경우, 이미지로 보여줄수 있도록 처리-->
					<img src = "/download?oname=img.png&sname=test (2)_20240620_152247695.png">
					<hr>
					<!-- 서버에서 서비스 하는 경로 /webapp/resources 폴더에 있는 경우-->
					<img src = "/resources/img/img.png">
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<td colspan="4" class="text-center">
			<!-- 버튼을 클릭하면 이벤트가 실행 - 목록으로 이동하기 -->
			<button type ="button" id="listBtn" class="btn btn-primary">도서목록</button>
			<c:if test="${memberDto.admin_yn eq 'Y'}">
				<button type ="button" id="editBtn" class="btn btn-success">수정</button>
				<button type ="button" id="delBtn" class="btn btn-danger">삭제</button>
			</c:if>
		</td>
	</tr>
	

</table>



</main>
<%@include file="../common/footer.jsp" %>
</body>
</html>