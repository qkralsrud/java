package com.spring.ex001.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.service.MemberService;

/**
 * 객체나 문자열을 반환
 */
@RestController
public class RestLoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/checkId")
	public ResponseEntity<String> checkId(
											// DTO객체가 정의되지 않은경우, 파라메터를 전달 받는 방법
											//@RequestParam(required = false) String id
											MemberDTO member) {
		
		String msg = "";
		System.out.println("id : " + member.getId());

		// 파라메터로 아이디가 넘어오지 않은경우
		if(member.getId() == null || "".equals(member.getId())) {
			msg = "아이디를 입력 해주세요.";
		}else {	
			// 서비스를 통해서 파라메터로 전달받은 id가 데이터 데이스에 존재하는지 확인
			MemberDTO res = service.checkId(member);
			if(res == null) {
				// 사용가능한 ID
				
			} else {
				// 사용불가능한 ID
				msg = "이미 사용중인 ID 입니다.";
			}
		}
		
		// import Spring header
		// ResponseEntity : HTTP헤더 정보와 추가적인 데이터를 전달할 때 사용
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		
		// JSON형식의 문자열을 생성 {"키":"값", "msg":"아이디를 입력해주세요"}
		String jsonMsg = "{\"msg\": \""+msg+"\"}";
		
		return new ResponseEntity<String>(jsonMsg, header, HttpStatus.OK);
		
		
		//return "res";
		// @ResponseBody 타입
		// 객체를 json형식의 문자열로 반환
		//return msg;
	}
	
	@GetMapping("/test")
	public @ResponseBody String getStr() {
		// @ResponseBody를 붙이지 않으면 jsp를 찾아감
		return "1";
	}
}