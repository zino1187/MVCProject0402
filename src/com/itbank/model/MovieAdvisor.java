/*
  이 클래스는 웹이건, 응용이건 모든 java의 플랫폼에서 사용
  가능한 중립적인 클래스로 정의하겠다!! 
 */
package com.itbank.model;
public class MovieAdvisor{
	public String getAdvice(String movie) {
		String msg=null;
		if(movie.equals("캡틴마블")){
	 		msg="엔드게임 보기전에 꼭 봐야함";
		}else if(movie.equals("돈")){
	 		msg="주식 브로커를 다룬 영화";
		}else if(movie.equals("극한직업")){
	 		msg="잠복 코믹 액션";
		}
		return msg;
	}
}









