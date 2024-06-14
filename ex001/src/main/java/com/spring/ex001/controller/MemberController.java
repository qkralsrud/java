package com.spring.ex001.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.service.MemberService;
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping(value = "/memberList")
	public String memberList(CriteriaDTO cri
								, Model model) {
		System.out.println("searchField : " + cri.getSearchField());
		System.out.println("searchWord : " + cri.getSearchWord());
		
		
		// 회원의 목록을 조회 후 map에 담아서 반환
		Map<String, Object> map = service.getMemberList(cri);

		// 내장객체에 데이터를 저장후 반환
		model.addAttribute("map", map);
		
		return "/member/memberList";
	}
}
