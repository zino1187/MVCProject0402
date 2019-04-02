package com.itbank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MovieAdvisor;

//영화에 대한 요청을 처리하는 컨트롤러!!!
//기존에 우리가 제작한 프로젝트 에서는 jsp 안에함께 공존했었다..
//하지만 이런 방식은 디자인을 담당하는 jsp가 삭제되어질때, 컨트롤러
//도 영향을 받게된다...이 문제를 해결하기 위해 jsp안에 들어있던 컨트롤
//러 마저도 분리시켜보자!!  == MVC 로 구현!!
public class MovieController_Back extends HttpServlet{
	MovieAdvisor advisor;
	
	public MovieController_Back() {
		advisor = new MovieAdvisor();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doRequest(req, resp);
	}
	
	//get , post 상관없이 요청을 공통화 시키기 위한 메서드 정의
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.print("나의 서블릿 동작 성공!!");
		
		/*모든 컨트롤러의 공통적 역할 
		 * 1) 요청을 받는다 
		 * 2) 클라이언트의 종류가 다양할 경우 요청을 분석한다
		 * 3) 비즈니스 로직 객체인 모델에게 일 시킨다!!
		 * 4) 저장할 데이터가 있으면 저장한다
		 *     나 아닌 다른 서블릿이나 결과를 담당하는 jsp에게 데이터를
		 *     그래도 유지하여 보내려면, request, session에 저장..
		 * 5) 알맞는 결과 페이지를 선택한다 
		 * */
		
		//파라미터의 언어 인코딩 처리
		req.setCharacterEncoding("utf-8");
		String movie=req.getParameter("movie");
		
		String msg=advisor.getAdvice(movie);
		
		//result.jsp로 포워딩 하자!!
		req.setAttribute("msg", msg); //저장!!
		RequestDispatcher dis=req.getRequestDispatcher("/movie/result.jsp");
		dis.forward(req, resp);//포워딩 시점!!!
	}
	
}








