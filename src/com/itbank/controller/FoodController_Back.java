package com.itbank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.FoodAdvisor;

/* �� ������ ��� ���ø����̼ǿ��� (��, ���� �������) 
 * ��� ��Ʈ�ѷ����� ����� ���� ó�� ������ �ִ�..
 * 1.��û�� �޴´� 
 * 2.��û�� �м��Ѵ� (�м��Ұ� �ִٸ�..) 
 *    Ŭ���̾�Ʈ�� ��û�� ����, ��ȭ����..�� ��������??
 * 3.���� ��Ų�� (�� ��ü����...)
 * 4.��� ������ �����͸� ���� (�����Ұ� �ִٸ�..)
 * 5.�˸´� �� ���� (�츮�� ���� result.jsp)    
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
		
		//��û�� �޴´�!!
		String food=request.getParameter("food");
		
		//3�ܰ�: �Ͻ�Ų��
		String msg=foodAdvisor.getAdvice(food);
		
		//4�ܰ�: ������ ���� �����Ƿ� ��� ���� 
		request.setAttribute("msg", msg);
		
		//5�ܰ�: �˸´� �� ���� 
		//        ��û�� ������(redirect), ��û�� ��������(������)
		RequestDispatcher dis=request.getRequestDispatcher("/food/result.jsp");
		dis.forward(request, response);
	}
	
}



















