package com.human.mapper;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.human.dto.BookDTO;

public class MapperTest {
	
	public static void main(String[] args) {
		
		String resource = "com/human/config/mybatis-config.xml";
		InputStream inputStream ;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println(sqlSessionFactory);
			
			try (SqlSession session = sqlSessionFactory.openSession()) {
				  BookDTO dto = session.selectOne("com.human.mapper.BookMapper.selectBook", 1);
				} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}	
