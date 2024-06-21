package com.spring.ex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.ex001.dto.BoardDTO;
import com.spring.ex001.dto.CriteriaDTO;

@Mapper
public interface BoardMapper {

	public List<BoardDTO> getList(CriteriaDTO criteriaDTO);

	
	public int getTotalCnt(CriteriaDTO criteriaDTO);


	@Update("update board set counts=counts+1 where board_no=${board_no}")
	public int upCount(int board_no);


	@Select("select * from board where board_no=${board_no}")
	public BoardDTO boardDetail(int board_no); 
}
