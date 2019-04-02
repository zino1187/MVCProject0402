<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
당신 선택한 영화는 <br>
<%
	out.print(request.getAttribute("msg"));
%>
</body>
</html>










