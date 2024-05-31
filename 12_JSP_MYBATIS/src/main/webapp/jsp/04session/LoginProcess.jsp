<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.human.dao.MemberDAO"%>
<%@page import="com.human.dto.MemberDTO"%>
<%@page import="com.human.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 사용자로 부터 입력 받은 id, pw에 해당하는 사용자가 있는지 확인  -->
id : ${param.user_id } <br>
pw : ${param.user_pw }
<%
	// 요청정보 수집
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	
	MemberDTO paramMember = new MemberDTO(id, pw); 
	out.print("------" + paramMember + "<br>");
	
	// 로그인처리
	MemberService service = new MemberService();
	out.print("=====loginMember_service : " + service.login(paramMember));
	
	MemberDTO loginMember = service.login(paramMember);
	
	if(loginMember == null){
		request.setAttribute("msg", "아이디 비밀번호를 확인해주세요.");
		request.getRequestDispatcher("LoginMain.jsp")
									.forward(request, response);
	} else {
		// 로그인 성공
		// 세션에 사용자 정보를 저장해놓으므로 로그인이 유지될 수 있다!!!!!!
		session.setAttribute("userId", loginMember.getId());
		session.setAttribute("loginMember", loginMember);
		
		// request영역이 공유가 안된다!!
		response.sendRedirect("main.jsp");
		
	}
	
%>













</body>
</html>