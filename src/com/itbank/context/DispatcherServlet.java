package com.itbank.context;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.controller.Controller;
/*
 * 웹어플리케이션에서 클라이언트의 요청을 제일먼저 받아들이는
 * 컨트롤러... 이 컨트롤러가 왜 필요한가?? 
 * 더 많은, 효율적인 업무 처리를 위해
 * 1)요청을 받는다 
 * 2)요청을 분석한다(클라이언트가 무엇을 원하는지..)
 * 3)일시킨다 
 * 4)View 로 가져갈 결과가 있다면 결과저장 
 * 5)뷰지정(뷰중 어떤 뷰가 결과를 보여줄지 결정)
 * */
public class DispatcherServlet extends HttpServlet{
	ApplicationContext context;
	
	//현재 이 서블릿이 생성된 이후에, 초기화 작업시 호출되는 메서드가 init 이다
	//
	public void init(ServletConfig config) throws ServletException {
		//jsp에서의 어플리케이션의 전역적 정보를 가진 application
		//내장 객체는 사실 자료형이 ServletContext
		String contextConfigLocation=config.getInitParameter("contextConfigLocation");
		ServletContext application=config.getServletContext();
		String realPath=application.getRealPath(contextConfigLocation);
		System.out.println("realPath :" +realPath);
		
		context=new ApplicationContext(realPath);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("대왕 컨트롤러 동작 성공");
		//2단계: 클라이언트가 원하는게 무엇인지 분석하자!!
		String uri=request.getRequestURI();
		System.out.println("당신이  원하는 것은"+uri);
		
		//영화를 원하는 경우 
		Controller controller=null;
		RequestDispatcher dis=null;
		//new 연산자 때문에 if문이 사라질 수 없다..
		//해결책?? new 연산자를사용했던 이유는 객체의 인스턴스를
		//           생성하기 위함이다..그렇다면, 객체의인스턴스를 생성
		//           방법에는 꼭 new만 있을까???  No
		//           Class  클래스를 이용하면 new 연산자 없이도 인스턴스
		//           를 생성할 수 있다..
		controller=context.getBean(uri);
		
		String resultKey=null;
		controller.execute(request, response);
		resultKey=controller.getResultView();
			
		//게시판을 만들면서 무조건 forward 했을때의 문제점을 알아보자!!
		dis=request.getRequestDispatcher(context.getViewPage(resultKey));
		dis.forward(request, response);
	}
}
















