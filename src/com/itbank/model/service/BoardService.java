package com.itbank.model.service;

import org.apache.ibatis.session.SqlSession;

import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.repository.BoardDAO;
import com.itbank.mybatis.config.MybatisManager;

//DAO ���� �� ��ų�Ӹ� �ƴ϶� , DAO�� �Ҽ����� ���
//������ �����Ѵ�!! Ư�� Ʈ�������!!!!!!!!
public class BoardService{
	private MybatisManager manager;
	private BoardDAO boardDAO;
	
	public BoardService() {
		manager=MybatisManager.getInstance();
		boardDAO = new BoardDAO();
	}
	public void insert(Board board) throws RegistFailException{
		SqlSession sqlSession=manager.getSqlSession();
		boardDAO.setSqlSession(sqlSession);//DAO ����!!
		//�����ϴ� ����?? Ʈ����� ó��������...������ Ʈ����� ��Ȳ��
		//�ƴ�����,....
		try {
			int result=boardDAO.insert(board);
			if(result==0) {
				throw new RegistFailException("��Ͻ���");
			}
			sqlSession.commit();
		}finally {
			manager.release(sqlSession);
		}
	}
}










