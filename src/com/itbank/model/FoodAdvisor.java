/*
  이 클래스는 웹이건, 응용이건 모든 java의 플랫폼에서 사용
  가능한 중립적인 클래스로 정의하겠다!! 
 */
package com.itbank.model;
public class FoodAdvisor{
	public String getAdvice(String food) {
		String msg=null;
		if(food.equals("스파게티")){
	 		msg="가장 인기있는 이탈리안 푸드";
		}else if(food.equals("김치찌게")){
	 		msg="최고의 한국음식";
		}else if(food.equals("초밥")){
	 		msg="최고의 일본음식";
		}
		return msg;
	}
}









