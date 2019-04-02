package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 하위 컨트롤러들의 최상위 객체이다!!
// 인터페이스로 정의하여 미래에 정의될 컨트롤러들로 하여금, 반드시 
// 지정된 메서드를 구현하도록 강제하자!!
public interface Controller {
	public void execute(HttpServletRequest request, 
			HttpServletResponse resonse);
	
	//어떤 뷰페이지를 사용할지 여부를 당연히 동생이 담당해야 한다..
	public String getResultView();
	
	//요청을 유지할지 여부를 판단해주는 메서드 
	public boolean isForward();
}













