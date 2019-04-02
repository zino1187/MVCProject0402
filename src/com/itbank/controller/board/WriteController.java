package com.itbank.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.controller.Controller;
import com.itbank.exception.RegistFailException;
import com.itbank.model.domain.Board;
import com.itbank.model.service.BoardService;

//글쓰기를 담당하는 컨트롤러!!
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
			//유저들이 에러를 봐야 하므로, 즉 view page까지 가져갈 것이 
			//있다,..따라서 저장할 데이터 있다는 것임...
			request.setAttribute("errorMessage", e.getMessage());
		}
		System.out.println("글씨기를 원하는 군요");	
	}
	public String getResultView() {
		return "/board/write/view";
	}
	//포워드 여부를 반환한다!!
	public boolean isForward() {
		return false;
	}
}





