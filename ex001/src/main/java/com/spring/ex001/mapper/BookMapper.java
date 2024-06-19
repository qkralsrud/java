package com.spring.ex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.ex001.dto.BookDTO;
import com.spring.ex001.dto.CriteriaDTO;

@Mapper
public interface BookMapper {
	
	/**
	 * 어노테이션을 이용하여 쿼리를 작성
	 * @return
	 */
	@Select("select sysdate from dual")
	public String select();
	
	/**
	 * 동적쿼리를 생성 하기 위해서 xml파일을 생성
	 * @param cri 
	 */
	public List<BookDTO> getBookList(CriteriaDTO cri);

	/**
	 * 페이징 처리를 위해 총 건수를 조회 합니다.
	 * @return
	 */
	@Select("select count(*) from book")
	public int getTotalCnt();
	/**
	 * 페이징 처리를 위해 총 건수를 조회 합니다.
	 * @return
	 */
	@Select("select count(*) from book where no>${pageNo}")
	public int getTotalCnt1(CriteriaDTO cri);
	
	public int regBook(BookDTO book);
}
