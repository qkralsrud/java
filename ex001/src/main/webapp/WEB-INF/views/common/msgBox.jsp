<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- msg를 출력 후 페이지를 이동 -->
<!-- 부트스트랩CSS, JS, 모달태그 복사, 스크립트 이용해서 출력 -->
<script type="text/javascript">
	let msg = '${msg}';
	let url = '${url}';

	// 내장객체에 저장된 메세지를 출력
	if(msg != ''){
		alert(msg);
	}
	
	// 내장객체의 영역에 url이 저장된 경우 url로 이동
	// 아니면 뒤로가기
	if(url != ''){
		location.href = url;
	} else {
		history.back();
	}
</script>

</body>
</html>