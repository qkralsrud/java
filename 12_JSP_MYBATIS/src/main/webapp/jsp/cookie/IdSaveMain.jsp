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
<%
	//cookie값에 loginId가 있는지 확인후 있다면 id 필드에 출력
	//체크박스에 체크!
	String loginId ="";
	String checkd = "";
	/*
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie c : cookies){
			if("loginId".equals(c.getName())){
				loginId = c.getValue();
				checkd = "checked";
			}
		}		
	}
	*/
	//request 영역으로 부터 쿠키값을 읽어서 반환
	loginId = CookieManager.getCookieValue(request,"loginId");
	//쿠키에 값이 존재하는 경우, 체크박스에 체크를 하기 위해서 변수에 checked값을 저장 
	checkd = loginId.equals("") ? "" : "checked"; 
%>
    <h2>로그인 페이지</h2>
    <form action="IdSaveProcess.jsp" method="post">
    아이디 : <input type="text" name="user_id" value="<%=loginId %>" /><br />
    
    패스워드 : <input type="text" name="user_pw" value=""/><br />
    <input type="checkbox" name="save_check" value="Y" <%=checkd %>/>
        아이디 저장하기
    <br />
    <input type="submit" value="로그인하기" />
    </form>
</body>
</html>