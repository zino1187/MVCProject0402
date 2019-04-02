package com.itbank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itbank.model.MovieAdvisor;

//��ȭ�� ���� ��û�� ó���ϴ� ��Ʈ�ѷ�!!!
//������ �츮�� ������ ������Ʈ ������ jsp �ȿ��Բ� �����߾���..
//������ �̷� ����� �������� ����ϴ� jsp�� �����Ǿ�����, ��Ʈ�ѷ�
//�� ������ �ްԵȴ�...�� ������ �ذ��ϱ� ���� jsp�ȿ� ����ִ� ��Ʈ��
//�� ������ �и����Ѻ���!!  == MVC �� ����!!
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
	
	//get , post ������� ��û�� ����ȭ ��Ű�� ���� �޼��� ����
	protected void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		out.print("���� ���� ���� ����!!");
		
		/*��� ��Ʈ�ѷ��� ������ ���� 
		 * 1) ��û�� �޴´� 
		 * 2) Ŭ���̾�Ʈ�� ������ �پ��� ��� ��û�� �м��Ѵ�
		 * 3) ����Ͻ� ���� ��ü�� �𵨿��� �� ��Ų��!!
		 * 4) ������ �����Ͱ� ������ �����Ѵ�
		 *     �� �ƴ� �ٸ� �����̳� ����� ����ϴ� jsp���� �����͸�
		 *     �׷��� �����Ͽ� ��������, request, session�� ����..
		 * 5) �˸´� ��� �������� �����Ѵ� 
		 * */
		
		//�Ķ������ ��� ���ڵ� ó��
		req.setCharacterEncoding("utf-8");
		String movie=req.getParameter("movie");
		
		String msg=advisor.getAdvice(movie);
		
		//result.jsp�� ������ ����!!
		req.setAttribute("msg", msg); //����!!
		RequestDispatcher dis=req.getRequestDispatcher("/movie/result.jsp");
		dis.forward(req, resp);//������ ����!!!
	}
	
}








