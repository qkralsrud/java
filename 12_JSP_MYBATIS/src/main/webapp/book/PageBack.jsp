<%@page import="com.human.dto.PageDto"%>
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
	// 공통모듈!
	// PageDto객체만 있으면 페이지블럭을 그릴수 있다!!!!
	// 1. 서버측에서 request영역에 pageDto객체를 pageDto이름으로 저장
	// 2. 리스트페이지에서 PageBlock.jsp를 include 지시자를 이용하여 출력
	
	/*
	// 사용자로부터 요청페이지번호를 받아옵니다
	String pageNoStr = request.getParameter("pageNo");
	int pageNo = 1;
	if(pageNoStr != null && !"".equals(pageNoStr)){
		pageNo = Integer.parseInt(pageNoStr);
	}
	
	// 총건수, 요청페이지번호, 페이지당게시물수를 이용하여 PageDto를 초기화 합니다.
	// 페이지블럭당 페이지의수는 5로 고정되 있다!!
	PageDto pageDto = new PageDto(1000, pageNo, 10);
	*/
	
	// 서버로 부터 전달 받아 옵니다.
	if(request.getAttribute("pageDto") == null){
		out.print("pageDto is null");
	} else {
	
		PageDto pageDto = (PageDto)request.getAttribute("pageDto");
		out.print("<hr>");
		System.out.println("요청페이지번호 : " + pageDto.getPageNo() + "<br>");
		System.out.println("블럭의시작번호 : " + pageDto.getStartNo() + "<br>");
		System.out.println("블럭의끝번호 : " + pageDto.getEndNo() + "<br>");
		System.out.println("실제끝페이지번호(게시물의수/페이지당게시물) : " + pageDto.getRealEndNo() + "<br>");
		
		if(pageDto.isPrev()){
			out.print("<a href='/bookList?pageNo="+(pageDto.getStartNo()-1)+"'>");
			out.print(" ◀ ");  
			out.print("</a>");
		}
		
		// 페이지 블럭의 시작번호 ~ 끝번호 출력 
		for(int i=pageDto.getStartNo();i<=pageDto.getEndNo();i++){
			if(pageDto.getPageNo() == i){
				out.print("<b>"+i+"</b> ");	
			} else {
				out.print("<a href='/bookList?pageNo="+i+"'>");
				out.print(i);
				out.print("</a>");
				out.print(" ");
			}
		}
		
		if(pageDto.isNext()){
			out.print("<a href='/bookList?pageNo="+(pageDto.getEndNo()+1)+"'>");
			out.print(" ▶ ");  
			out.print("</a>");
		}
	}
	
	
%>

</body>
</html>