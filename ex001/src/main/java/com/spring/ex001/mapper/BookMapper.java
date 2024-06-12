package com.spring.ex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.ex001.dto.BookDTO;

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
	 */
	public List<BookDTO> getBookList();
	
}
