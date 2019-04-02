<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function send(){
	form1.method="post";
	form1.action="/movie.do";
	form1.submit();
}
</script>
</head>
<body>
	<form name="form1">
		<select name="movie">
			<option>영화선택</option>
			<option value="캡틴마블">캡틴마블</option>
			<option value="돈">돈</option>
			<option value="극한직업">극한직업</option>
		</select>
		<button type="button" onClick="send()">전송</button>
	</form>	
</body>
</html>
















