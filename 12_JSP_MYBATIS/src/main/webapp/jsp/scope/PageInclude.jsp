<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include페이지</h2>
<h5>페이지영역에 저장된 속성</h5>
${pageInteger}
${pageString}
${pageObject}
<hr>
<h5>request영역에 저장된 속성</h5>
${requestString} / ${requestObject.title }
</body>
</html>