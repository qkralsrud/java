<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>첨부파일 목록</h2>
<table border="1">
	
	<!-- 파일이 webapp경로에 존재 하는경우 - 서버에서 접근이 가능 -->
	<img src="/img/test.png" alt="여름이미지">
	<!-- 업로드된 이미지를 화면에 출력 -->
	<!-- sname : 다운로드 받을 파일의 이름, oname = 파일을 저장할 이름 -->
	<img src="/download?sname=test_20240610_1529302.png&oname=saveName.png" alt="여름이미지">
	<!-- 등록버튼 -->
	<tr>
		<td colspan="5" style="text-align:right">
			<button onClick="location.href='/jsp/08fileUpload/fileUpload.jsp'">파일등록</button>
		</td>
	</tr>

	<!-- 타이틀 -->
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>타이틀</td>
		<td>카테고리</td>
		<td>원본파일명</td>
		<!--  <td>저장파일명-파일을 다운로드받기위해서 필요한 정보</td> -->
	</tr>
	
	<!-- 리스트 출력 -->
	<c:choose>
		<c:when test="${empty map.list }">
			<tr>
				<td colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${map.list }" var="myfileDTO">
				<tr>
					<td>${myfileDTO.idx }</td>
					<td>${myfileDTO.name }</td>
					<td>${myfileDTO.title }</td>
					<td>${myfileDTO.cate }</td>
					<!-- ofile : 원본파일명
						 sfile : 저장파일명 -->
					<td><a href="/download?sname=${myfileDTO.sfile }&oname=${myfileDTO.ofile }">${myfileDTO.ofile }</a></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	
	<!-- 버튼 -->
	<tr>
		<td colspan="5" style="text-align:right">
			<button onClick="location.href='/jsp/08fileUpload/fileUpload.jsp'">파일등록</button>
		</td>
	</tr>
</table>



</body>
</html>








