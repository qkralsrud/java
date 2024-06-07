package com.human.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.CriteriaDTO;
import com.human.dto.MemberDTO;
import com.human.dto.PageDto;
import com.human.service.MemberService;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberList")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 수집
		String searchWord = request.getParameter("searchWord");
		String searchField = request.getParameter("searchField");
		String pageNo = request.getParameter("pageNo");
		
		// 요청정보로 부터 pageNo를 받아 옵니다
		CriteriaDTO cri = new CriteriaDTO(pageNo, searchField, searchWord);
		
		// 리스트 조회및 페이지 DTO생성
		MemberService service = new MemberService();
		Map<String, Object> map = service.getMemberList(cri);
		
		// 페이지 전환후 출력을 위해 내장객체의 영역에 저장 합니다.
		// 페이지블럭을 출력하기 위해서 pageNavi.jsp를 인클루드 해야 합니다!!!!!
		request.setAttribute("map", map);
		
		// jsp 페이지로 전환(이동)
		// reqeust 영역을 공유하기 위해서 forward방식으로 화면을 전환
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
