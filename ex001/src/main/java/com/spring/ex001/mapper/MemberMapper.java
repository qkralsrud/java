package com.spring.ex001.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.ex001.dto.MemberDTO;

/**
 * 1. mapper는 인터페이스로 생성
 * 2. Mapper어노테이션 지정
 */
@Mapper
public interface MemberMapper {

	@Select("select * from member where id=#{id} and pw=#{pw}")
	MemberDTO login(MemberDTO member);

}
