package com.spring.ex001.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.spring.ex001.dto.CriteriaDTO;
import com.spring.ex001.dto.MemberDTO;

/**
 * 1. mapper는 인터페이스로 생성
 * 2. Mapper어노테이션 지정
 */
@Mapper
public interface MemberMapper {

	@Select("select * from member where id=#{id}")
	MemberDTO login(MemberDTO member);

	List<MemberDTO> getMemberList(CriteriaDTO cri);

	@Select("select count(*) from member")
	int getTotalCnt();
	
	@Select("select * from member where id = #{id}")
	MemberDTO checkId(MemberDTO member);

	int regMember(MemberDTO member);

	int updatePW(MemberDTO member);

	@Update("update member set admin_yn=#{admin_yn} where id=#{id}")
	int changeAdminYN(MemberDTO member);
}
