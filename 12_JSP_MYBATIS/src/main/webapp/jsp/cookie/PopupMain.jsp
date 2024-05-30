
<%@page import="com.human.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div#popup {
        position: absolute; top:100px; left:50px; color:yellow;  
        width:270px; height:100px; background-color:gray;
    }
    div#popup>div {
        position: relative; background-color:#ffffff; top:0px;
        border:1px solid gray; padding:10px; color:black;
    }
    .off {
    	display:none;
    }
</style>
</head>
<body>
<%
	for(int i =0;i<20;i++){
		out.print( "PopupClose 쿠키의 값 :"+ CookieManager.getCookieValue(request, "PopupClose") );
	}
%>

PopupClose 쿠키의 값 : <%=CookieManager.getCookieValue(request, "PopupClose") %>

<!-- class속성에 none을 지정 하면 더이상 화면에 출력되지 않아요! -->
<div id="popup" class="<%=CookieManager.getCookieValue(request, "PopupClose") %>">
	<h2> 공지사항 팝업 입니다.</h2>
	<div>
		.......
		<br><br>
		<!-- 같은경로에 있으므로 파일명만 적어도 되고 ./를 적어도 됨! -->
		<form action="./PopupCookie.jsp">
			<!-- 체크박스는 체크된 요소만 서버에 값(value속성의값)을 전달 합니다. -->
			<input type="checkbox" id="inactiveToday" 
								name="inactiveToday" value="1">
			하루 동안 열지 않기
			<!-- 사용자가 닫기 버튼을 클릭하면 서버에 PopupCookie.jsp 페이지를 요청  
				inactiveToday가 체크되어 있으면 쿠키를 생성(PopupClose, off)
				PopupCookie.jsp 에서는 파라메터로 넘어온 inactiveToday를 출력 하세요!!!!
			--> 
			<button>닫기</button>
		</form>
	</div>
</div>
</body>
</html>