package com.human.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.human.dto.BookDTO;

public class SqlSessionFactoryManager {
	private static SqlSessionFactory sqlSessionFactory;
	
	//생성자를 이용해서 생성하지 못하도록 처리
	private SqlSessionFactoryManager() {}
	
	
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) {
			String resource = "com/huam/comfig/mtbatis-config.xml";
			try {
			
				InputStream inputStream	= Resources.getResourceAsStream(resource);
				SqlSessionFactory sqlSessionFactory =	new SqlSessionFactoryBuilder().build(inputStream);
				System.out.println(sqlSessionFactory);
				
								
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		
		return sqlSessionFactory;
	}
	
}
