package com.human.service;

import com.human.dao.MemberDao;
import com.human.dto.MemberDTO;

public class MemberService {
	MemberDao dao = new MemberDao();
	public boolean login(MemberDTO memberDTO) {
		boolean res = false;
		if(memberDTO.getId() != null && memberDTO.getPw() != null) {
			MemberDTO loginMember = dao.login(memberDTO);
			if(loginMember != null) {
				res = true;
			}
		}
		return res;
	}
}
