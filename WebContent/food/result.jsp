<%@page import="com.itbank.model.FoodAdvisor"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%! FoodAdvisor advisor=new FoodAdvisor();%>
<%
	//클라이언트가 전송한 파라미터 값 출력 
	request.setCharacterEncoding("utf-8");
	String food=request.getParameter("food");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
당신 선택한 음식은 <br>
<%
	String msg=advisor.getAdvice(food);
	out.print(msg);
%>
</body>
</html>










