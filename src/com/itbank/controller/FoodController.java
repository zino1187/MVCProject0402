package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.FoodAdvisor;

//���� �����ϴ� ��Ʈ�ѷ� Ŭ����!!!

public class FoodController implements Controller{
	FoodAdvisor advisor=new FoodAdvisor();
	
	public void execute(HttpServletRequest request, HttpServletResponse resonse) {
		//3�ܰ�: ����Ͻ� ���� ��ü�� �� ��Ű��!!
		String food=request.getParameter("food");
		String msg=advisor.getAdvice(food);
		
		//4�ܰ�: �信 ������ ���� �ֱ� ������ ��� ����...
		//  session�� ���� ���� ������, �̹� request�� �����ϰ� �ֱ�
		//  ������ request�� �̿��ϰڴ�
		request.setAttribute("msg",msg);//����!!!
	}
	@Override
	public String getResultView() {
		return "/food/result.jsp";
	}
}





