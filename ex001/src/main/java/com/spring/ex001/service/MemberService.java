package com.spring.ex001.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public MemberDTO login(MemberDTO member) {
		return mapper.login(member);
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

}