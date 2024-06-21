package com.spring.ex001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
