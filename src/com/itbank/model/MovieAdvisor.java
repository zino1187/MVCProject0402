/*
  �� Ŭ������ ���̰�, �����̰� ��� java�� �÷������� ���
  ������ �߸����� Ŭ������ �����ϰڴ�!! 
 */
package com.itbank.model;
public class MovieAdvisor{
	public String getAdvice(String movie) {
		String msg=null;
		if(movie.equals("ĸƾ����")){
	 		msg="������� �������� �� ������";
		}else if(movie.equals("��")){
	 		msg="�ֽ� ���Ŀ�� �ٷ� ��ȭ";
		}else if(movie.equals("��������")){
	 		msg="�ẹ �ڹ� �׼�";
		}
		return msg;
	}
}









