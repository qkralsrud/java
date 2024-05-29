
<%@page import="com.human.dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 속성을 저장 이름을 지정해 주고 
	// 이름으로 꺼내오거나 삭제 할수 있다
	// 대소문자를 구분한다!!! -> 오타에 주의
	pageContext.setAttribute("pageInteger", 1000);
	pageContext.setAttribute("pageString", "페이지영역의 문자열");
	pageContext.setAttribute("pageObject", new BookDTO("1", "성낙현의JSP", "성낙현"));
	
%>

<h2>page영역의 속성값 읽어오기</h2>
<ul>
	<li>Integer : ${pageInteger} / <%= pageContext.getAttribute("pageInteger") %></li>
	<li>String : ${pageString} / <%= pageContext.getAttribute("pageString")%></li>
	<li>Object : ${pageObject}<br>${pageObject.title}<br>${pageObject.author}<br>
					<%= pageContext.getAttribute("pageObject")%>
					<%= ((BookDTO)pageContext.getAttribute("pageObject")).getTitle()%>
	<%
	if(pageContext.getAttribute("pageObjects") != null){
		// 해당 이름으로 저장된 값이 없는경우, null을 반환합니다
		BookDTO dto = (BookDTO)pageContext.getAttribute("pageObject");
		out.append(dto.getTitle());
	%>
		<%=dto.getTitle() %>
	<%
	}
	%>
	
	</li>
</ul>

<!-- 페이지 영역을 이용하면 include된 페이지까지 속성값이 공유 -->
<!-- 만약 include페이지가 존재 하지 않으면 404오류가 발생한다 -->
<%@include file="PageInclude.jsp" %>
<h2>링크를 이용하여 페이지를 다시 요청한 경우</h2>
<a href = "Location.jsp">Location바로가기</a>

<%
	request.getRequestDispatcher("Location.jsp").forward(request, response);
	//response.sendRedirect("Location.jsp");
%>
</body>
</html>