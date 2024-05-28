package com.human.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dto.BookDTO;
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
		
		BookService service = new BookService();
		List<BookDTO> list = service.selectBookList();
		
		// 화면에 보여주기 위해서 내장객체 request에 저장
		request.setAttribute("list", list);
		
		// 사용자의 요청 URL에 매핑 되어 있는 서블릿이 실행 되고 
		// JSP페이지를 반환하기 위해 forward 처리
		request.getRequestDispatcher("/book/bookList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
