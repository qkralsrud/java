package com.human.service;

import com.human.dao.MemberDAO;
import com.human.dto.MemberDTO;

public class MemberService {
	private MemberDAO dao = new MemberDAO();
	
	public MemberDTO login(MemberDTO paramMember) {
		System.out.println("====================" + paramMember);
		// 유효성 검사, Validation check : 입력값의 유효성을 검사하는 과정
		if(paramMember != null 
				&& paramMember.getId() != null 
				&& !paramMember.getId().equals("")
				&& paramMember.getPw() != null
				&& !paramMember.getPw().equals("")
				) {
			
			return dao.login(paramMember);
		} else {
			return null;
		}
	}
}
