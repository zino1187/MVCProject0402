/*
  �� Ŭ������ ���̰�, �����̰� ��� java�� �÷������� ���
  ������ �߸����� Ŭ������ �����ϰڴ�!! 
 */
package com.itbank.model;
public class FoodAdvisor{
	public String getAdvice(String food) {
		String msg=null;
		if(food.equals("���İ�Ƽ")){
	 		msg="���� �α��ִ� ��Ż���� Ǫ��";
		}else if(food.equals("��ġ���")){
	 		msg="�ְ��� �ѱ�����";
		}else if(food.equals("�ʹ�")){
	 		msg="�ְ��� �Ϻ�����";
		}
		return msg;
	}
}









