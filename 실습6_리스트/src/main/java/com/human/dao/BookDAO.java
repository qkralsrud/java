package com.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.human.dto.BookDTO;
import com.human.dto.CriteriaDTO;
import com.human.util.SqlSessionFactoryManager;

public class BookDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionFactoryManager.getInstance();
	
	public List<BookDTO> getBookList(CriteriaDTO cri) {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			List<BookDTO> list = sqlSession.selectList("com.human.mapper.BookMapper.getBookList", cri);
			return list;
		}
	}

	/**
	 * 테이블에 들어있는 데이터의 총 건수를 조회 합니다.
	 * 페이징 처리를 위해서 필요한 값
	 * @return
	 */
	public int getTotalCnt() {
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			int totalCnt = sqlSession.selectOne("com.human.mapper.BookMapper.getTotalCnt");
			return totalCnt;
		}
	}

	
	
	public static void main(String[] args) {
		BookDAO dao = new BookDAO();
		
		System.out.println("총건수 : " + dao.getTotalCnt());
		
		List<BookDTO> list = dao.getBookList(new CriteriaDTO("1"));
		for(BookDTO dto : list) {
			System.out.println(dto.getTitle());
			System.out.println(dto.getAuthor());
		}
	}
	
}
