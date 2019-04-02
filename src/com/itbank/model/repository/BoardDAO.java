package com.itbank.model.repository;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itbank.model.domain.Board;
public class BoardDAO {
	private SqlSession sqlSession;
	
	//for setter injection 
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insert(Board board) {
		int result=0;
		result=sqlSession.insert("Board.insert", board);
		return result;
	}
	
	public List selectAll() {
		return sqlSession.selectList("Board.selectAll");
	}
}










