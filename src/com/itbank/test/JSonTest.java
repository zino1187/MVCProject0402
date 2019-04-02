package com.itbank.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//�ڹٿ��� json �� �����غ���!! (�ļ��� �ʿ��ϴ�..)
public class JSonTest {
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();
		String path="D:/java_developer/spring_workspace/MVCProject/WebContent/WEB-INF/dispatcher-servlet.txt";
		FileReader reader = null;
		
		try {
			reader=new FileReader(path);
			JSONObject json=(JSONObject)parser.parse(reader); //������ �ε��� �����̹Ƿ�..
			
			System.out.println(json.get("/movie.do"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			if(reader !=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}




