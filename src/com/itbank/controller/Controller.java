package com.itbank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��� ���� ��Ʈ�ѷ����� �ֻ��� ��ü�̴�!!
// �������̽��� �����Ͽ� �̷��� ���ǵ� ��Ʈ�ѷ���� �Ͽ���, �ݵ�� 
// ������ �޼��带 �����ϵ��� ��������!!
public interface Controller {
	public void execute(HttpServletRequest request, 
			HttpServletResponse resonse);
	
	//� ���������� ������� ���θ� �翬�� ������ ����ؾ� �Ѵ�..
	public String getResultView();
	
	//��û�� �������� ���θ� �Ǵ����ִ� �޼��� 
	public boolean isForward();
}













