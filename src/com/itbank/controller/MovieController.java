package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MovieAdvisor;

//���� �����ϴ� ��Ʈ�ѷ� Ŭ����!!!
public class MovieController implements Controller{
	MovieAdvisor advisor=new MovieAdvisor();
	
	public void execute(HttpServletRequest request, HttpServletResponse resonse) {
		//3�ܰ�: ����Ͻ� ���� ��ü�� �� ��Ű��!!
		String movie=request.getParameter("movie");
		String msg=advisor.getAdvice(movie);
		
		//4�ܰ�: �信 ������ ���� �ֱ� ������ ��� ����...
		//  session�� ���� ���� ������, �̹� request�� �����ϰ� �ֱ�
		//  ������ request�� �̿��ϰڴ�
		request.setAttribute("msg",msg);//����!!!
	}
	@Override
	public String getResultView() {
		return "/movie/view";
	}
}





