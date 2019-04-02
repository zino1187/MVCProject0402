package com.itbank.mybatis.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	private static MybatisManager instance=new MybatisManager();
	InputStream inputStream;
	SqlSessionFactory sqlSessionFactory;
	
	private MybatisManager() {
		String resource = "com/itbank/mybatis/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
	}
	
	public static MybatisManager getInstance() {
		return instance;
	}
	
	//SqlSession 을 반환하는 메서드 추가 
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
	//닫기
	public void release(SqlSession sqlSession) {
		sqlSession.close();
	}
	
}








