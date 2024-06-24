<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">


</style>
<script type="text/javascript">
	var checkBox;
	function changeAdminYN(checkBox){
		window.checkBox=checkBox;
		console.log(checkBox);
		// 태그에 저장된 데이터 속성을 읽어 옵니다
		console.log(checkBox.dataset.memberid);	// 사용자 ID
		console.log(checkBox.dataset.adminyn);	// 관리자여부
		
		let changeAdminYN = checkBox.dataset.adminyn == 'Y' ? 'N': 'Y';
		
		// 서버에 전달할 데이터를 자바스크립트 오브젝트 형태로 생성
		let data = {id : checkBox.dataset.memberid
					, admin_yn : changeAdminYN};
		
		console.log('data', data);
		
		// 서버에 요청 POST방식으로 요청
		// POST방식으로 요청시 url의 다음 인자로 옵션을 설정
		// 공통으로 작성할 경우, 공통함수를 호출하고 데이터입력, 콜백함수 작성만 해주면 된다
		fetch_post('/changeAdminYN', data, fetch_res);
		
		
	}

	function fetch_res(data){
		console.log('data', data);
		// 업데이트 실패
		if(data.res != 1){
			// 기존 체크박스의 상태로 변경
			checkBox.checked = checkBox.dataset.adminyn == 'Y' ? true : false;
		} else {
			// 데이터 변경
			checkBox.dataset.adminyn = changeAdminYN;
		}
	}
</script>
</head>
<body>
<!-- header -->
<!-- 부트스트랩 css -->
<%@include file="../common/header.jsp" %>
<c:set var="list" value="${map.list }"></c:set>
<!-- main -->
<main>
	<h2>회원목록</h2>

	<!--  -->
	<div class="d-flex justify-content-center">
		<div class="w-75">
			<form action="/memberList" name="searchForm" class="row g-3">
				<input type="hidden" name="pageNo" value="${map.pageDto.pageNo }">
				<br>
				  <div class="col-md-3">
				  
				    <select class="form-select form-select-sm" name="searchField">
				      <option value="id" ${param.searchField eq "id" ? "selected" : ""}>아이디</option>
				      <option value="name" ${param.searchField eq "name" ? "selected" : ""}>이름</option>
				      <option value="all" ${param.searchField eq "all" ? "selected" : ""}>아이디&이름</option>
				    </select>
				  </div>
				  <div class="col-md-6">
				    <input type="text" class="form-control form-control-sm" name="searchWord" value="${param.searchWord }">
				  </div>
				  <div class="col-md-3">
				  	<button class="form-control btn btn-dark btn-sm">검색</button>
				  </div>
			</form>
		</div>
	</div>	
	
	
	<div class="text-end">
  		<button class="btn btn-dark">회원등록</button>
  	</div>
	
		
	<p></p>	
			<!-- 
			
			searchField - 아이디, 이름, searword
			1. 서버에 값을 전달
			2. 서버에서 값을 받아서 확인
			3. 쿼리 수정
			4. 쿼리 테스트
		 	-->
		
		
      <div class="table-responsive small">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">아이디</th>
              <th scope="col">이름</th>
              <th scope="col">가입일</th>
              <th scope="col">관리자</th>
            </tr>
          </thead>
          <tbody>
          	<c:choose>
          		<c:when test="${empty list }">
          			<tr><td colspan="5">데이터가 없습니다</td></tr>
          		</c:when>
          		<c:otherwise>
		          	<c:forEach items="${list }" var="member">
			          	<tr>
			              <td>${member.rn }</td>
			              <td>${member.id }</td>
			              <td>${member.name }</td>
			              <td>${member.reg_date }</td>
			              <td>
			              	<div class="form-check form-switch">
			              		<!-- admin_yn='Y'이면 checked 상태 -->
							  <input class="form-check-input" type="checkbox" role="switch" 
							  			data-memberId = "${member.id }"
							  			data-adminYN = "${member.admin_yn }"
							  			onclick="changeAdminYN(this)"
							  			id="adminActionBtn" ${member.admin_yn eq 'Y' ? 'checked' : '' }>
							</div>
						  </td>
			            </tr>
		          	</c:forEach>
          		</c:otherwise>
          	</c:choose>
            
          </tbody>
        </table>
      </div>

	<%@include file="../common/pageNavi.jsp" %>
</main>

<!-- footer -->
<!-- 부트스트랩 js -->
<%@include file="../common/footer.jsp" %>
</body>
</html>