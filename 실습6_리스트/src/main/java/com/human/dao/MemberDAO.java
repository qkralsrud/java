package com.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.human.dto.CriteriaDTO;
import com.human.dto.MemberDTO;
import com.human.util.SqlSessionFactoryManager;

public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory 
						= SqlSessionFactoryManager.getInstance();

	// 페이징처리및 검색을 하기 위해서 여러가지 파라메터를 수집 해야 합니다.
	// 페이징과 검색에 필요한 필드들을 모아서 정의한 클래스를 만들어 줍니다.
	public List<MemberDTO> getMemberList(CriteriaDTO cri){
		List<MemberDTO> list = null;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			list = sqlSession.selectList("com.human.mapper.MemberMapper.selectMemberList", cri);
		}
		
		return list;
	}
	
	/**
	 * 게시글의 총건수
	 * @return
	 */
	public int getTotalCnt() {
		int res = 0;
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
			res = sqlSession.selectOne("com.human.mapper.MemberMapper.getTotalCnt");
		}
		return res;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		System.out.println("총건수 : " + dao.getTotalCnt());
		System.out.println("===================================");
		//CriteriaDTO cri = new CriteriaDTO(); // 1페이지, 10건씩
		CriteriaDTO cri = new CriteriaDTO("3", 100); // 30페이지, 5건씩
		List<MemberDTO> list = dao.getMemberList(cri);
		for(MemberDTO dto : list) {
			System.out.println(dto.getID());
			System.out.println(dto.getNAME());
		}
	}
}
