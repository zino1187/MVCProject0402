package com.itbank.context;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.itbank.controller.Controller;

//dispatcher 서블릿이 사용할 컨트롤러의 인스턴스를 생성해주는 전담객체
//이 객체로 인하여 dispatcher 서블릿은 if문이 사라지게 된다..
//따라서 컨트롤러의 수가 늘어나도 두번다시 DispatcherServlet 코드는
//수정할 필요가 없게 된다...
public class ApplicationContext {
	JSONParser jsonParser;
	FileReader reader;
	JSONObject json; //파싱한 결과 객체!!
	
	//서블릿으로부터 빈 설정파일의 경로를 넘겨받자!!!
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
	
	//인수로 클라이언트가 전송한 요청 uri 가 들어오면, 
	//해당 요청을 처리할 Controller를 반환하겠음
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
	
	//키값을 이용하여 뷰페이지를 반환하는 메서드 정의
	public String getViewPage(String resultKey) {
		JSONObject obj=(JSONObject)json.get("view");
		return (String)obj.get(resultKey);//jsp page
	}
}











