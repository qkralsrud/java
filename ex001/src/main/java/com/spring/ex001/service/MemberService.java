package com.spring.ex001.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex001.dto.MemberDTO;
import com.spring.ex001.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	MemberMapper mapper;
	
	public MemberDTO login(MemberDTO member) {
		
		return mapper.login(member);
	}

}
