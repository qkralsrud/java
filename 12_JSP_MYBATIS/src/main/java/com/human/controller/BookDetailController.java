package com.human.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dto.BookDTO;
import com.human.service.BookService;

/**
 * 서블릿을 호출 하는 방법
 * localhost:8080/bookDetail
 */
@WebServlet("/bookDetail")
public class BookDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글깨짐을 방지하기 위해 인코딩 설정을 해줍니다.
		response.setCharacterEncoding("utf-8");
		
		
		// 웹브라우져 화면에 출력
		//response.getWriter().append("no: ").append(request.getParameter("no"));
		// 콘솔창에 출력
		System.out.println(request.getParameter("no"));
		BookService service = new BookService();
		
		BookDTO book = service.selectBook(request.getParameter("no"));
		request.setAttribute("book", book);
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", "id");
		
		
		System.out.println("book : " + book);
		// 서블릿을 통해 화면을 구현하는것은 매우 번거로우므로
		// 사용자의 요청 수집및 비지니스로직의 처리는 서블릿을 이용하고
		// 화면은 JSP로 만들어서 반환하도록 처리
		request.getRequestDispatcher("/book/bookDetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
