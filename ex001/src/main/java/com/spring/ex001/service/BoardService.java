package com.spring.ex001.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.PageDto;
import com.spring.ex001.dto.BoardDTO;
import com.spring.ex001.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	PageDto pageDto;
	
	
	
	
	public Map<String, Object> getList(CriteriaDTO cri){
		System.out.println("cri=========" + cri.getSearchField());
		System.out.println("cri=========" + cri.getSearchWord());
		
		Map<String, Object> map = new HashMap<String, Object>();
		// 리스트 조회및 map에 저장
		List<BoardDTO> list = mapper.getList(cri);
		map.put("list", list);
		// 페이지 네비게이션 출력을 위한 객체
		int totalCnt = mapper.getTotalCnt(cri);
		pageDto.setPageDto(totalCnt, cri.getPageNo(), cri.getAmount());
		map.put("pageDto", pageDto);
		return map;
	}

	public BoardDTO boardDetail(int board_no) {
		// 조회수 업
		int res = mapper.upCount(board_no);
		// 게시물의 정보를 반환
		return mapper.boardDetail(board_no);
		
	}
}
