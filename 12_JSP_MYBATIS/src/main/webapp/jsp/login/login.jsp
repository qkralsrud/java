<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>id, pw 를 출력</h2>
<%=request.getParameter("id") %>
<%=request.getParameter("pw") %>
${param.id }
${param.pw }
<hr>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	if(id.equals("momo") && pw.equals("1234")){
		// welcome.jsp 페이지로 리다이렉트
		// ./ : 나의 현재경로를 기준으로
		// / : 루트를 기준으로
		// 세션에 저장 하여 출력하거나 쿼리스트링을 이용해서 출력 할 수 있다
		session.setAttribute("id", id);//  -> ${id}
		response.sendRedirect("./welcome.jsp?id="+id); // -> ${param.id}
	}else{
		// forward하기 전에 전달할 값을 저장 해야 한다!!
		request.setAttribute("msg", "아이디 비밀번호를 확인해주세요");
		// main.jsp 페이지로 포워드
		request.getRequestDispatcher("./main.jsp?loginErr=1").forward(request, response);
		
	}
%>

id=user01, pw=1234 이면 
welcome 페이지로 아니면 login페이지로 이동

welcome페이지에서는 ~님 환영합니다.
login페이지에서는 아이디/비밀번호르 확인해주세요

</body>
</html>