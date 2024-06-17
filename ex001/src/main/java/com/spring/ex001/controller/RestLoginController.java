package com.spring.ex001.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ex001.dto.MemberDTO;

/**
 * 객체나 문자열을 반환
 */
@RestController
public class RestLoginController {

	@GetMapping("/checkId")
	public @ResponseBody MemberDTO checkId(
											// DTO객체가 정의되지 않은경우, 파라메터를 전달 받는 방법
											//@RequestParam(required = false) String id
											MemberDTO member) {
		
		// 서비스를 통해서 파라메터로 전달받은 id가 데이터 데이스에 존재하는지 확인
		
		System.out.println("id : " + member.getId());
		//return "res";
		// @ResponseBody 타입
		// 객체를 json형식의 문자열로 반환
		return member;
	}
	
	
	public @ResponseBody String getStr() {
		// @ResponseBody를 붙이지 않으면 jsp를 찾아감
		return "res";
	}
}
