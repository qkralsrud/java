package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.service.BookService;

/**
 * Servlet implementation class BookDeleteController
 */
@WebServlet("/bookDelete")
public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteController() {
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
		// 필터를 이용한 한글깨짐 처리 (web.xml파일)
		// SetCharacterEncodingFilter 를 이용해서 처리
		//request.setCharacterEncoding("utf-8");
		BookService service = new BookService();
		String no = request.getParameter("no");
		int res = service.bookDelete(no);
		
		if(res > 0) {
			request.setAttribute("msg", res + "건 삭제 되었습니다.");
		} else {
			request.setAttribute("msg", no + "번 삭제 실패!!");
		}
		
		request.getRequestDispatcher("/book/bookDelete.jsp").forward(request, response);
	}

}
