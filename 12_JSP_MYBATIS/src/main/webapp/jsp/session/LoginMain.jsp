<%@page import="com.human.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie - 아이디 저장하기</title>
</head>
<body>

세션아이디 : <%=session.getId() %>
<br>세션유지시간 : <%=session.getMaxInactiveInterval() %>
<br>로그인아이디: ${userId}

<%
	//cookie값에 loginId가 있는지 확인후 있다면 id 필드에 출력
	//체크박스에 체크!
	String loginId ="";
	String checkd = "";
	/*
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie c : cookies){
			out.print(c.getName()+"/"+c.getValue());
			if("loginId".equals(c.getName())){
				loginId = c.getValue();
				checkd = "checked";
			}
		}		
	}
	*/
	// request영역으로 부터 쿠키값을 읽어서 반환
	loginId = CookieManager.getCookieValue(request, "loginId");
	// 쿠키에 값이 존재하는경우, 체크박스에 체크를 하기 위해서 변수에 checked값을 저장
	checkd = loginId.equals("") ? "" : "checked";
	
	if(request.getParameter("user_id") != null 
			&& !request.getParameter("user_id").equals("")){
		loginId = request.getParameter("user_id");
	}
%>
    <h2>로그인 페이지</h2>
    ${msg }
    <!-- jsp호출 -->
    <!-- <form action="LoginProcess.jsp" method="post"> -->
    <!-- 서블릿 컨트롤러 호출 -->
    <!-- 나의 경로를 참조하는 경우, ./, 아무것도 입력하지 안았을때 -->
    <!-- 루트경로를 참조하는 경우 / -->
    <form action="/LoginProcess" method="post">
    아이디 : <input type="text" name="user_id" value="<%=loginId %>" required="required"/>
    <br />
    패스워드 : <input type="text" name="user_pw" value="" required="required"/>
     <br><input type="checkbox" name="save_check" value="Y" <%=checkd %>/>
        아이디 저장하기
    <br />
    <input type="submit" value="로그인하기" />
    </form>
</body>
</html>