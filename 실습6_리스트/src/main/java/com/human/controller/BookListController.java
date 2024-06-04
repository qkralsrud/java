package com.human.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.BookDTO;
import com.human.dto.CriteriaDTO;
import com.human.dto.PageDto;
import com.human.service.BookService;

/**
 * Servlet implementation class BookListController
 */
@WebServlet("/bookList")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청수집
		CriteriaDTO cri = new CriteriaDTO(request.getParameter("pageNo")); 
		
		// 리스트 조회
		BookService service = new BookService();
		List<BookDTO> list = service.getBookList(cri);
		int totalCnt = service.getTotalCnt();
		
		// PageDTO 생성
		// 타입 변수이름
		// 페이지 블럭을 그리기 위해서 PageDto객체 생성 합니다.
		// 페이지 블럭을 그리기 위해서 필요한 값은 총건수, 요청페이지번호, 페이지당 게시물수
		PageDto pageDto = new PageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		// 내장객체 영역에 저장
		request.setAttribute("list", list);
		request.setAttribute("pageDto", pageDto);
		
		// 화면을 전환
		// 경로를 지정하는 방법
		// / : 루트경로(webapp)을 기준으로
		// ../ : 상위경로
		// ./, 아무것도 없을때 : 현재요청된 url을 기준으로
		request.getRequestDispatcher("book/bookList.jsp").forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
