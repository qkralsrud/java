package com.human.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.human.dto.MyFileDTO;
import com.human.util.SqlSessionFactoryManager;

public class MyfileDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionFactoryManager.getInstance();
	
	public int insertMyfile(MyFileDTO dto) {
		int res = 0;
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
			res = sqlSession.insert("com.human.mapper.MyfileMapper.insertMyfile", dto);
		}
		return res;
	}
	
	public static void main(String[] args) {
		MyfileDAO dao = new MyfileDAO();
		System.out.println(dao.getList());
		/* insert
		MyFileDTO dto = new MyFileDTO("name1", "title1", "cate1", "ofile1", "sfile1");
		int res = dao.insertMyfile(dto);
		System.out.println(res + "건 입력 되었습니다.");
		*/
	}

	public List<MyFileDTO> getList() {
		// 리스트 조회
		try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
			List<MyFileDTO> list = sqlSession.selectList("com.human.mapper.MyfileMapper.getList");
			return list;
		}
	}
}
