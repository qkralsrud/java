<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서등록</title>
<script type="text/javascript">
	window.addEventListener('load', ()=>{
		i = 0;
		console.log('load');
		attachFileAddBtn.addEventListener('click', ()=>{
			console.log('btn 클릭!');
			// 요소생성
			let newElement = document.createElement('p');
			// 파일을 추가
			// 첨부파일을 서버에 전송 하기 위해서 이름속성을 지정
			// 이름이 중복될 경우, 파일이 저장되지 않으므로 이름에 순서를 부여
			// querySelector : 무조건 하나의 요소만 반환
			// querySelectorAll : 여러개의 요소를 선택 할 때 사용
			// error : 파일의 갯수에 따라 번호를 부여할 경우 
			// 삭제시 중복된 번호가 부여될수 있으므로 
			// let i = document.querySelectorAll('input[type=file]').length;
			
			// ++ 또는 --를 앞에 붙여주면 코드가 실행되기 전 증감 처리
			// 뒤에 붙이면 코드가 실행된 후 증감 처리 
			newElement.innerHTML = 
							 '<input type="file" name="uploadFile'+ ++i +'">'
							+'<button type="button" id="fileDelbtn" onclick="delFile(this)">x</button>';
			// 요소를 화면에 추가
			fileBox.appendChild(newElement);
		});
		
	});
	
	function delFile(delBtn){
		console.log('delBtn click!!');
		// 요소.parentElement : 부모의 요소를 반환
		// 요소.remove() : 요소를 제거
		delBtn.parentElement.remove();

	}
	
	
</script>
</head>
<body>
<%@include file="../common/header.jsp" %>

<h2>도서등록</h2>
<form action="/bookRegAction" enctype="multipart/form-data" method="post">
	제목 : <input type="text" name="title">
	<br>작가 : <input type="text" name="author">
	<br>출판사 : <input type="text" name="publisher">
	<br>가격 : <input type="text" name="price">

<hr>
	<button type="button" id="attachFileAddBtn">첨부파일 추가</button>
<hr>

	<div id="fileBox">
		<p><input type='file' name = "uploadFile0"></p>
	
	</div>
	
	
	<br><br>


<button>전송</button>
</form>
<%@include file="../common/footer.jsp" %>

</body>
</html>
