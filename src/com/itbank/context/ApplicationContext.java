package com.itbank.context;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.itbank.controller.Controller;

//dispatcher ������ ����� ��Ʈ�ѷ��� �ν��Ͻ��� �������ִ� ���㰴ü
//�� ��ü�� ���Ͽ� dispatcher ������ if���� ������� �ȴ�..
//���� ��Ʈ�ѷ��� ���� �þ�� �ι��ٽ� DispatcherServlet �ڵ��
//������ �ʿ䰡 ���� �ȴ�...
public class ApplicationContext {
	JSONParser jsonParser;
	FileReader reader;
	JSONObject json; //�Ľ��� ��� ��ü!!
	
	//�������κ��� �� ���������� ��θ� �Ѱܹ���!!!
	public ApplicationContext(String contextConfigLocation) {
		try {
			reader = new FileReader(contextConfigLocation);
			jsonParser = new JSONParser();
			json=(JSONObject)jsonParser.parse(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//�μ��� Ŭ���̾�Ʈ�� ������ ��û uri �� ������, 
	//�ش� ��û�� ó���� Controller�� ��ȯ�ϰ���
	public Controller getBean(String uri) {
		Class instance=null;
		Controller controller=null;
		
		JSONObject obj=(JSONObject)json.get("controller");
		
		try {
			instance=Class.forName((String)obj.get(uri));
			controller=(Controller)instance.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return controller;
	}
	
	//Ű���� �̿��Ͽ� ���������� ��ȯ�ϴ� �޼��� ����
	public String getViewPage(String resultKey) {
		JSONObject obj=(JSONObject)json.get("view");
		return (String)obj.get(resultKey);//jsp page
	}
}











