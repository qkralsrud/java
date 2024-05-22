package com.human.service;

import com.human.dao.MemberDAO;
import com.human.vo.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public void insertMember(MemberVO vo) {
		int res = dao.insertMember(vo);
		if( res > 0 ) {
			System.out.println("등록 되었습니다.");
		} else {
			System.out.println("등록 실패! 관리자에게 문의하세요!");
		}
	}
	
	public boolean checkId(String id) {
		boolean res = dao.checkId(id);
		if(!res) {
			System.out.println("중복된 아이디 입니다.");
		}
		return res;
	}

	public MemberVO login(String id, String pw) {
		MemberVO vo = dao.login(id, pw);
		if(vo == null) {
			System.out.println("아이디/비밀번호를 확인 해주세요.");
		}
		return vo;
	}
	
	
	
}
