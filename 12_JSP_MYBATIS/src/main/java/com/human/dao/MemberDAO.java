package com.human.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.human.dto.MemberDTO;
import com.human.util.SqlSessionFactoryManager;
/**
 * DAO 작성 -> DTO작성 -> Mapper 작성
 *  -> config파일에 Mapper를 등록
 */
public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryManager.getInstance();
	
	public MemberDTO login(MemberDTO paramMember) {
		MemberDTO member = null;
		
		try(SqlSession sqlSession= sqlSessionFactory.openSession()){
			
			member = sqlSession.selectOne(
							"com.human.mapper.MemberMapper.login"
							, paramMember);
		}
		
		return member;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO("momo", "momo");
		
		MemberDTO loginMember = dao.login(member);
		System.out.println(loginMember);
		
		
	}
	
	
}
