<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	//뭘 원하는지 여부는 클라이언트가 결정해줘야 한다...
	form1.action="/food.do";
	form1.submit();
}
</script>
</head>
<body>
	<form name="form1">
		<select name="food">
			<option>음식선택</option>
			<option value="스파게티">스파게티</option>
			<option value="김치찌게">김치찌게</option>
			<option value="초밥">초밥</option>
		</select>
		<button type="button" onClick="send()">전송</button>
	</form>	
</body>
</html>
















