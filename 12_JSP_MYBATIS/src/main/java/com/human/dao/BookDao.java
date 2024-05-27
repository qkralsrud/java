package com.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huam.comfig.MyApp1;
import com.human.dto.BookDTO;
import com.human.util.SqlSessionFactoryManager;


public class BookDao {
	
	final static Logger logger = LoggerFactory.getLogger(MyApp1.class);

	private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryManager.getInstance();
	
	/**
	 * 입력
	 * @param book
	 * @return
	 */
	public int insert(BookDTO book) {
		int res = 0;
		try(SqlSession session = sqlSessionFactory.openSession(true)){
			res  = session.insert("com.human.mapper.BookMapper.insertBook", book);
		}
		System.out.println("실행결과 : " + res + "건");
		return res;
	}
	
	/**
	 * 수정
	 * @param book
	 * @return
	 */
	public int update(BookDTO book) {
		int res = 0;
		try(SqlSession session = sqlSessionFactory.openSession(true)){
			res  = session.insert("com.human.mapper.BookMapper.updateBook", book);
		}
		System.out.println("실행결과 : " + res + "건");
		return res;
	}
	
	/**
	 * 삭제
	 * @param book
	 * @return
	 */
	public int delete(int no) {
		int res = 0;
		try(SqlSession session = sqlSessionFactory.openSession(true)){
			res  = session.insert("com.human.mapper.BookMapper.deleteBook", no);
		}
		System.out.println("실행결과 : " + res + "건");
		return res;
	}
	
	public BookDTO selectBook(int no) {
		BookDTO book = null;
		try(SqlSession session = sqlSessionFactory.openSession(true)){
			book  = session.selectOne("com.human.mapper.BookMapper.selectBook", no);
		}
		return book;
	}
	
	public List<BookDTO> selectBookList() {
		List<BookDTO> list = null;
		try(SqlSession session = sqlSessionFactory.openSession(true)){
			list  = session.selectList("com.human.mapper.BookMapper.selectBookList");
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		BookDao dao = new BookDao();
		BookDTO book = new BookDTO();
		book.setTitle("제목update");
		book.setAuthor("작가update");
		// 입력테스트
		//int res = dao.insert(book);
		// 삭제 테스트
		//dao.delete(52);
		// 수정 테스트
		book.setNo(52);
		int res = dao.update(book);
		logger.info(res + "건 처리 되었습니다.");
		
		System.out.println(dao.selectBook(1));
		logger.info(dao.selectBookList().toString());
		
		/*
		try (SqlSession session = dao.sqlSessionFactory.openSession()) {
			// 도서 조회(상세보기)
			//BookDTO book = session.selectOne("com.human.mapper.BookMapper.selectBook", 1);
			//System.out.println(book.getTitle());
			//System.out.println(book.getAuthor());
			
			// 도서목록 조회(리스트)
			List<BookDTO> list = session.selectList("com.human.mapper.BookMapper.selectBookList");
			session.de
			System.out.println(list);
		  
		  // try문장의 ()에서 생성 하게 되면 코드블럭이 종료되면 생성된 자원도 함께 반납 
		  //session.close();
		  
		}
		*/
	}
}









