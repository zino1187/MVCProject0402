package com.itbank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.FoodAdvisor;

/* 이 세상의 모든 어플리케이션에서 (웹, 응용 상관없이) 
 * 모든 컨트롤러들은 공통된 업무 처리 과정이 있다..
 * 1.요청을 받는다 
 * 2.요청을 분석한다 (분석할게 있다면..) 
 *    클라이언트의 요청이 음식, 영화인지..즉 무엇인지??
 * 3.일을 시킨다 (모델 객체에게...)
 * 4.뷰로 가져갈 데이터를 저장 (저장할게 있다면..)
 * 5.알맞는 뷰 지정 (우리의 경우는 result.jsp)    
 */
public class FoodController_Back extends HttpServlet{
	FoodAdvisor foodAdvisor=new FoodAdvisor();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//요청을 받는다!!
		String food=request.getParameter("food");
		
		//3단계: 일시킨다
		String msg=foodAdvisor.getAdvice(food);
		
		//4단계: 가져갈 것이 있으므로 결과 저장 
		request.setAttribute("msg", msg);
		
		//5단계: 알맞는 뷰 지정 
		//        요청을 끊을지(redirect), 요청을 유지할지(포워딩)
		RequestDispatcher dis=request.getRequestDispatcher("/food/result.jsp");
		dis.forward(request, response);
	}
	
}



















