<%@page import="java.util.List"%>
<%@page import="ex.MyList"%>
<%@page import="java.util.Set"%>
<%@page import="ex.MySet"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	WebApplicationContext wc = WebApplicationContextUtils.getWebApplicationContext(application);

	//MySet mySet = (MySet)wc.getBean("mySetBean");
	MyList myList = wc.getBean("myListBean", MyList.class);
	
	List list = myList.getList();
	
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<ul>
		<c:forEach var="furit" items="${list }">
			<li>${furit }</li>
		</c:forEach>
	</ul>
</body>
</html>