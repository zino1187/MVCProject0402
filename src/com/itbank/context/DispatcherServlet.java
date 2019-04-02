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
 * �����ø����̼ǿ��� Ŭ���̾�Ʈ�� ��û�� ���ϸ��� �޾Ƶ��̴�
 * ��Ʈ�ѷ�... �� ��Ʈ�ѷ��� �� �ʿ��Ѱ�?? 
 * �� ����, ȿ������ ���� ó���� ����
 * 1)��û�� �޴´� 
 * 2)��û�� �м��Ѵ�(Ŭ���̾�Ʈ�� ������ ���ϴ���..)
 * 3)�Ͻ�Ų�� 
 * 4)View �� ������ ����� �ִٸ� ������� 
 * 5)������(���� � �䰡 ����� �������� ����)
 * */
public class DispatcherServlet extends HttpServlet{
	ApplicationContext context;
	
	//���� �� ������ ������ ���Ŀ�, �ʱ�ȭ �۾��� ȣ��Ǵ� �޼��尡 init �̴�
	//
	public void init(ServletConfig config) throws ServletException {
		//jsp������ ���ø����̼��� ������ ������ ���� application
		//���� ��ü�� ��� �ڷ����� ServletContext
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
		System.out.println("��� ��Ʈ�ѷ� ���� ����");
		//2�ܰ�: Ŭ���̾�Ʈ�� ���ϴ°� �������� �м�����!!
		String uri=request.getRequestURI();
		System.out.println("�����  ���ϴ� ����"+uri);
		
		//��ȭ�� ���ϴ� ��� 
		Controller controller=null;
		RequestDispatcher dis=null;
		//new ������ ������ if���� ����� �� ����..
		//�ذ�å?? new �����ڸ�����ߴ� ������ ��ü�� �ν��Ͻ���
		//           �����ϱ� �����̴�..�׷��ٸ�, ��ü���ν��Ͻ��� ����
		//           ������� �� new�� ������???  No
		//           Class  Ŭ������ �̿��ϸ� new ������ ���̵� �ν��Ͻ�
		//           �� ������ �� �ִ�..
		controller=context.getBean(uri);
		
		String resultKey=null;
		controller.execute(request, response);
		resultKey=controller.getResultView();
			
		//�Խ����� ����鼭 ������ forward �������� �������� �˾ƺ���!!
		dis=request.getRequestDispatcher(context.getViewPage(resultKey));
		dis.forward(request, response);
	}
}
















