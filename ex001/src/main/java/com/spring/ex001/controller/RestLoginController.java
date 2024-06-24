package com.spring.ex001.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.service.MemberService;

/**
 * 객체나 문자열을 반환
 * 
 * @RestController 를 이용하면 .jsp를 반환하지 않는다
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
	
	@PostMapping("/changeAdminYN")
	// @RequestBody : JSON형식의 문자열을 전달 받아서 자바 객체로 변환
	public ResponseEntity changeAdminYN(@RequestBody MemberDTO member) {
		System.out.println("member" + member);

		// member정보 업데이트
		int res = service.changeAdminYN(member);
		
		
		// 키의 타입, 값의 타입
		Map<String, Object> map = new HashMap<String, Object>();
		// 어드민YN값을 업데이트후 결과를 반환
		map.put("res", res);
		
		Map<String, Object> memberMap = service.getMemberList(new CriteriaDTO());
		map.put("memberMap", memberMap);
		

		// 웹브라우저로 전달할 객체를 생성
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<Map<String, Object>>(map, header, HttpStatus.OK);
	}
}





















