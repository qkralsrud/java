<%@page import="com.human.util.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 표현식을 이용하여 출력하는경우 ;을 붙이지 않습니다!!!!!!!!! -->

<%=request.getParameter("inactiveToday") %>
<% 
	//inactiveToday가 1이면 쿠키를 생성후 response 객체에 추가 
	if(request.getParameter("inactiveToday") !=null 
			&& request.getParameter("inactiveToday").equals("1")){
		//체크박스가 선택 되었으면 쿠키를 추가합니다.
		CookieManager.makeCookie(response, "PopupClose", "off", 60*60*24);
		
	}

//request.getRequestDispatcher("PopupMain.jsp").forward(request, response);
	response.sendRedirect("PopupMain.jsp");
%>	

</body>
</html>