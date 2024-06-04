<%@page import="com.human.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
memberList
<hr>
<%
	if(request.getAttribute("list") != null && !"".equals(request.getAttribute("list"))){
		List<MemberDTO> list = (List<MemberDTO>)request.getAttribute("list");
		for(MemberDTO member : list){
			out.print(member.getID() + " ");
			out.print(member.getPW() + " ");
			out.print(member.getNAME() + " ");
			out.print(member.getADMIN_YN() + " <br>");
		}
	}
%>

<!-- 페이지 블럭을 그려주는 페이지를 불러옵니다 -->
<%@include file="/common/pageNavi.jsp" %>

</body>
</html>