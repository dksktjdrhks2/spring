<%@page import="vo.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PersonVO p1 = new PersonVO();
	p1.setName("YSK");
	p1.setAge(20);
	p1.setTel("010-2342-3341");
	
	PersonVO p2 = new PersonVO("YYY", 25, "010-3809-0281");
	
	pageContext.setAttribute("p1", p1);
	request.setAttribute("p2", p2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<p>${p1.name } / ${p1.age } / ${p1.tel }</p>
		<p>${p2.name } / ${p2.age } / ${p2.tel }</p>
	</div>
</body>
</html>