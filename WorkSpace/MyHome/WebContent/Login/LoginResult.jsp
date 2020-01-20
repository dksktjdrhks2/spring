<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
	String msg = (String)request.getAttribute("msg");
	boolean check = (Boolean)request.getAttribute("check");
%>    

<%@include file="/Layout/Header.jsp" %>
<div align="center">
	<%=msg %><br>
	<%if(check) {%>
		MyPage | 회원탈퇴 |
	<%}else { %>
		ID찾기 | PW찾기 | 
		<a href = "/MyHome/Login/LoginForm.jsp">Login</a> | 
	<%} %>
	<a href = "/MyHome/Index.jsp">Home</a>
</div>
<%@include file="/Layout/Footer.jsp" %>