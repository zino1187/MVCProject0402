package com.itbank.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.repository.BoardDAO;
import com.itbank.mybatis.config.MybatisManager;

//DAO 에게 일 시킬뿐만 아니라 , DAO가 할수없는 모든
//로직을 제어한다!! 특히 트랜잭션을!!!!!!!!
public class BoardService{
	private MybatisManager manager;
	private BoardDAO boardDAO;
	
	public BoardService() {
		manager=MybatisManager.getInstance();
		boardDAO = new BoardDAO();
	}
	public void insert(Board board) throws RegistFailException{
		SqlSession sqlSession=manager.getSqlSession();
		boardDAO.setSqlSession(sqlSession);//DAO 주입!!
		//주입하는 이유?? 트랜잭션 처리때문에...지금은 트랜잭션 상황이
		//아니지만,....
		try {
			int result=boardDAO.insert(board);
			if(result==0) {
				throw new RegistFailException("등록실패");
			}
			sqlSession.commit();
		}finally {
			manager.release(sqlSession);
		}
	}
	public List selectAll() {
		SqlSession sqlSession=manager.getSqlSession();
		boardDAO.setSqlSession(sqlSession);
		List list=boardDAO.selectAll();
		manager.release(sqlSession);
		return list;
	}
}










