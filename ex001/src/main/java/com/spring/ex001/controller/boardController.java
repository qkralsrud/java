package com.spring.ex001.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.BoardDTO;
import com.spring.ex001.service.BoardService;

@Controller
public class boardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/boardList")
	public String getList(CriteriaDTO cri, Model model) {
		try {
			// 게시물의 목록을 조회후 화면에서 출력 하기 위해 map에 저장
			model.addAttribute("map", service.getList(cri));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "/common/msgBox";
		} 
		return "/board/boardList";
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(@RequestParam(value = "board_no", required = false) Integer board_no, Model model) {
		BoardDTO board = service.boardDetail(board_no);
		model.addAttribute("board", board);
		return "/board/boardDetail";
	}
	
	
	@GetMapping("/boardDelete")
	public String boardDelete(BoardDTO board
								, @RequestParam(value = "pageNo", required = false) Integer pageNo
								, HttpSession session
								, Model model
								, RedirectAttributes rttr
								) {
		String login_id = "";
		if(session.getAttribute("id") != null) {
			login_id = (String)session.getAttribute("id");  
		}
		board.setUser_id(login_id);
		
		int res = service.boardDelete(board);
		
		if(res>0) {
			// 페이지 번호를 유지하기 위해서 화면으로 부터 페이지 번호를 받아 옵니다.
			rttr.addAttribute("pageNo", pageNo);
			// 삭제성공
			// 왜 redirect 하는지 생각해보기
			return "redirect:/boardList";
		} else {
			model.addAttribute("msg", "삭제중 예외사항이 발생 하였습니다. 관리자에게 문의해주세요.");
			// 삭제실패
			return "/common/msgBox";
		}
		
	}
	
	
	
	
	
	
	
	
}
