<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		제목 : ${vo.title }<br>
		<img src="resources/upload/${vo.filename }" width="200px"><br>
		<a href="insert_form.do" style="text-decoration: none;">다시 등록하기</a>
	</div>
</body>
</html>