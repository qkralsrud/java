package com.human.service;

import java.util.List;

import com.human.dao.MemberDAO;
import com.human.dto.CriteriaDTO;
import com.human.dto.MemberDTO;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public List<MemberDTO> getMemberList(CriteriaDTO cri){
		return dao.getMemberList(cri);
	}
	
	public int getTotalCnt() {
		return dao.getTotalCnt();
	}
}
