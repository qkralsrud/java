package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.BookDTO;
import com.human.service.BookService;

/**
 * Servlet implementation class BookUpdateController
 */
@WebServlet("/bookUpdate")
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 도서정보를 수정
		BookService service = new BookService();
		BookDTO book = new BookDTO(request.getParameter("no")
									, request.getParameter("title")
									, request.getParameter("author"));
		int res = service.bookUpdate(book);
		
		if(res > 0) {
			request.setAttribute("msg", res + "건 수정 되었습니다.");
		} else {
			request.setAttribute("msg", request.getParameter("no") + "번 도서정보 수정실패!!");
		}
		// JSP 페이지로 응답
		//	sendredirec - 요정정보를 공유하지 않음, 주소표시줄이 새로운 요청으로 변경
		// 	forward - 요청정보를 공유, 주소표시줄의 요청주소가 변하지 않음
		request.getRequestDispatcher("/book/bookUdate.jsp").forward(request, response);
	}

}
