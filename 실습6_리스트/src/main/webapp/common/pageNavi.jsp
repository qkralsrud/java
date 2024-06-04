<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ch.qos.logback.core.recovery.ResilientSyslogOutputStream"%>
<%@page import="com.human.dto.PageDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 
pageNavi.jsp는 공통으로 이용되는 페이지입니다.
리스트를 요청하기 위해서 함수를 이용합니다.
하단의 함수를 리스트페이지에 작성 해주세요!!
url을 요청 경로로 변경 해야 합니다.

<script type="text/javascript">
	function go(pageNo){
		document.location='url?pageNo='+pageNo;
	}
</script>
-->
</head>
<body>
<hr>
<h3>pageNavi.jsp</h3>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("pageDto", new PageDto(30, 1, 5));
	request.setAttribute("map", map);

	Map<String, Object> m = (Map<String, Object>)request.getAttribute("map"); 
	PageDto pageDto = (PageDto)m.get("pageDto");
	
	// controller로 부터 reqeust영역에 저장된 pageDto를 꺼내옵니다.
	// 이름이 다른경우, pageNavi.jsp를 include하지 않은경우 페이지 블럭이 나오지 않습니다.
	
	/*
	if(request.getAttribute("pageDto") !=null){
	
		PageDto pageDto = (PageDto)request.getAttribute("pageDto");
	*/
		// 이전블럭
		if(pageDto.isPrev()){
			// 맨처음으로 
		%>
			<a href='javascript:go(1)'>☜</a>
			<a href='javascript:go(<%= pageDto.getStartNo()-1%>)'>◀</a>
		<%
			//out.print("<a href='javascript:go("+(pageDto.getStartNo()-1)+")'>");
			//out.print("◀");
			//out.print("</a>");
		}
		
		System.out.print("요청페이지번호 : " + pageDto.getPageNo());
		// 페이지 번호 출력
		for(int i=pageDto.getStartNo();i<=pageDto.getEndNo();i++){
			if(i == pageDto.getPageNo()){
				out.print("<b>"+i+"</b> ");
			} else {
				//out.print("<a href='/memberList?pageNo="+i+"'>");
				// go(1)
				out.print("<a href='javascript:go("+i+")'>");
				out.print(i);
				out.print("</a>");
				out.print(" ");
			}
		}
		
		// 다음블럭
		if(pageDto.isNext()){
			out.print("<a href='javascript:go("+(pageDto.getEndNo()+1)+")'>");
			out.print("▶");
			out.print("</a>");
			
			// 맨 마지막 페이지로 이동
			%>
			<a href="javascript:go(<%=pageDto.getRealEndNo()%>)">☞</a>
			<%
		}
	/*
	} else {
		out.print("pageDto is null");
	}
	*/
%>

</body>
</html>