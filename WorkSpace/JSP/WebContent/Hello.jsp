<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int age = 17;

	public void ageAdd(){
		age++;
	}

%>  
<%
	String name = "김민준";
	//int age = 17;
	
	//ageAdd();
	
	age++;

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--  <%=	ageAdd() %>--%>
	<div align="center">
		이름 : <%=name %><br>
		나이 : <%=age %><br>
		<%if(age >= 20) {%>
			성인입니다.<br>
		<%} else {%>
			미성년자입니다.<br>		
		<%} %>		
	</div>
</body>
</html>












