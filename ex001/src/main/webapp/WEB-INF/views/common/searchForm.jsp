<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>
<!-- 검색 폼 -->
<div class="d-flex justify-content-center">
	<div class="w-75">
		<form action="" name="searchForm" class="row g-3">
			<input type="hidden" name="pageNo" value="${map.pageDto.pageNo }">
			<br>
			  <div class="col-md-3">
			  
			    <select class="form-select form-select-sm" name="searchField" id="searchField">
			      <!-- 옵션 -->
			    </select>
			  </div>
			  <div class="col-md-6">
			    <input type="text" class="form-control form-control-sm" name="searchWord" value="${param.searchWord }">
			  </div>
			  <div class="col-md-3">
			  	<button id="searchFormBtn" class="form-control btn btn-dark btn-sm">검색</button>
			  </div>
		</form>
	</div>
</div>
</body>
</html>