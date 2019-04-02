<%@page import="com.itbank.model.domain.Board"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Board> boardList=(List)request.getAttribute("boardList");
	out.print("게시물 갯수"+boardList.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
목록입니다
</body>
</html>