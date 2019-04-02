package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MovieAdvisor;

//무비를 전담하는 컨트롤러 클래스!!!
public class MovieController implements Controller{
	MovieAdvisor advisor=new MovieAdvisor();
	
	public void execute(HttpServletRequest request, HttpServletResponse resonse) {
		//3단계: 비즈니스 로직 객체에 일 시키기!!
		String movie=request.getParameter("movie");
		String msg=advisor.getAdvice(movie);
		
		//4단계: 뷰에 가져갈 것이 있기 때문에 결과 저장...
		//  session에 담을 수도 있지만, 이미 request를 보유하고 있기
		//  때문에 request를 이용하겠다
		request.setAttribute("msg",msg);//저장!!!
	}
	@Override
	public String getResultView() {
		return "/movie/view";
	}
}





