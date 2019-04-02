package com.itbank.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.controller.Controller;
import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.service.BoardService;

//�۾��⸦ ����ϴ� ��Ʈ�ѷ�!!
public class WriteController implements Controller{
	private BoardService boardService;
	public WriteController() {
		boardService = new BoardService();
	}
	public void execute(HttpServletRequest request, HttpServletResponse resonse) {
		
		Board board  =new Board();
		board.setWriter(request.getParameter("writer"));
		board.setTitle(request.getParameter("title"));
		board.setContent(request.getParameter("content"));
		
		try {
			boardService.insert(board);
		} catch (RegistFailException e) {
			e.printStackTrace();
			//�������� ������ ���� �ϹǷ�, �� view page���� ������ ���� 
			//�ִ�,..���� ������ ������ �ִٴ� ����...
			request.setAttribute("errorMessage", e.getMessage());
		}
		System.out.println("�۾��⸦ ���ϴ� ����");	
	}
	public String getResultView() {
		return "/board/write/view";
	}
	//������ ���θ� ��ȯ�Ѵ�!!
	public boolean isForward() {
		return false;
	}
}





