package com.human.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {
	private static SqlSessionFactory sqlSessionFactory;
	
	// 생성자를 이용해서 생성하지 못하도록 처리
	private SqlSessionFactoryManager() {}
	
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory == null) {
			// 설정파일의 위치
			String resource = "com/human/config/mybatis-config.xml";
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}
	
}
