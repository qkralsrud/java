<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>1. 쿠키(Cookie) 설정</h2>
    <%
    Cookie cookie = new Cookie("myCookie", "쿠키를만들어요");
    cookie.setPath("/"); // 경로
    
    out.print("getContextPath : " + request.getContextPath());
    cookie.setMaxAge(60*60); // 유지 기간
    
    // 웹브라우저에 전달
    response.addCookie(cookie);	
    %>
    
    <h2>2. 쿠키 설정 직후 쿠키값 확인하기</h2>
    <%
    Cookie[] cookies = request.getCookies();
    String myCookie = "";
    if(cookies != null){
	    for(Cookie c : cookies){
	    	String name = c.getName();
	    	String value = c.getValue();
	    	out.print(name + "/" + value + "<br>");
	    	
	    	if("myCookie".equals(name)){
	    		
	    		myCookie = value;
	    		request.setAttribute("myCookie", value);
	    	}
	    }
    }
    %>
    <%-- ${} : 내장객체를 이용한 경우, 파라메터를 이용한 경우 
    html주석을 이용할 경우 오류가 발생 할 수 있다--%>
    <!-- 변수에 선언된 값을 출력 할경우, 표현식을 이용해야 합니다.-->
    myCookie = ${myCookie } <%=myCookie%>
    
</body>
</html>