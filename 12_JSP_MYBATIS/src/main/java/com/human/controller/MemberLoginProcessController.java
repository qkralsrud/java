package com.human.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.human.dto.MemberDTO;
import com.human.service.MemberService;

/**
 * Servlet implementation class MemberLoginProcess
 */
@WebServlet("/LoginProcess")
public class MemberLoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("id : " + request.getAttribute("id"));
		
		response.getWriter().append("{'res' : 'ok'}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청정보 수집
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		MemberDTO paramMember = new MemberDTO(id, pw); 
		
		// 로그인처리
		MemberService service = new MemberService();
		MemberDTO loginMember = service.login(paramMember);
		
		if(loginMember == null){
			request.setAttribute("msg", "아이디 비밀번호를 확인해주세요.");
			request.getRequestDispatcher("/jsp/04session/LoginMain.jsp")
										.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			
			// 로그인 성공
			// 세션에 사용자 정보를 저장해놓으므로 로그인이 유지될 수 있다!!!!!!
			session.setAttribute("userId", loginMember.getId());
			session.setAttribute("loginMember", loginMember);
			
			// request영역이 공유가 안된다!!
			response.sendRedirect("/jsp/04session/main.jsp");
			
		}
	}

}
