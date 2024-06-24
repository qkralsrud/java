package com.spring.ex001.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.dto.PageDto;
import com.spring.ex001.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper mapper;
	
	@Autowired
	PageDto pageDto;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	/**
	 * 암호화된 비밀번호를 조회 하고 사용자가 입력한 비밀번호와 일치하는지 확인
	 * @param member
	 * @return
	 */
	public MemberDTO login(MemberDTO member) {
		
		// 해당 아이디의 사원의 정보를 조회
		MemberDTO dbMember = mapper.login(member);
		if(dbMember == null) {
			return dbMember;
		}
		
		// 사용자가 입력한 비밀번호와 데이터 베이스에 입력된 비밀번호가 일치하는지 확인
		if(encoder.matches(member.getPw(), dbMember.getPw())) {
			// 로그인 성공
			return dbMember;
		}else {
			// 로그인 실패
			return null;
		}
		
		//return mapper.login(member);
	}

	public Map<String, Object> getMemberList(CriteriaDTO cri) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 회원목록
		List<MemberDTO> list = mapper.getMemberList(cri);
		
		// 페이지 블럭을 그리기 위해 총건수를 조회 합니다
		int totalCnt = mapper.getTotalCnt();
		
		// 페이지DTO
		pageDto.setPageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		
		map.put("list", list);
		map.put("pageDto", pageDto);
		
		// map에 저장
		return map;
	}

	public MemberDTO checkId(MemberDTO member) {
		return mapper.checkId(member);
	}

	/**
	 * 회원가입
	 * @param member
	 * @return
	 */
	public int regMember(MemberDTO member) {
		
		// 비밀번호 암호화 처리
		member.setPw(encoder.encode(member.getPw()));
		return mapper.regMember(member);
	}

	public int changeAdminYN(MemberDTO member) {
		return mapper.changeAdminYN(member);
	}
}



















