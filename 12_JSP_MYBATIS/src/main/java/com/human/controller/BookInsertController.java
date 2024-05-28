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
 * Servlet implementation class BookInsertController
 */
@WebServlet("/bookInsert")
public class BookInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// jsp

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식의 한글깨짐 방지 -> 필터로 처리 하도록 설정
		request.setCharacterEncoding("utf-8");
		
		BookDTO book = new BookDTO();
		
		System.out.println("title : " + request.getParameter("title"));
		System.out.println("author : " + request.getParameter("author"));
		
		// 사용자의 입력 수집
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		
		// 입력 처리
		BookService service = new BookService();
		int res = service.bookInsert(book);
		
		if(res > 0) {
			request.setAttribute("msg", res + "건 등록 되었습니다.");
		} else {
			request.setAttribute("msg", "등록실패! 관리자에게 문의해주세요");
		}
		request.getRequestDispatcher("/book/bookInsert.jsp").forward(request, response);
	}

}
