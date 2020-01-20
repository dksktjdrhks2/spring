<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = (String)request.getAttribute("id");
%>    
    
<%@include file="/Layout/Header.jsp" %>
<div align="center">
	<table border="1">
		<tr>
			<th colspan="2">Find Result</th>
		</tr>
		<tr>
			<th>ID</th>
			<td>
				<%if(id != null) {
					out.print(id);
				  }else {
					out.print("결과 없음");  
				  }
				%>
			</td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<%if(id != null) {%>
					<button onclick="location.href = '/MyHome/Login/LoginForm.jsp?id=<%=id %>'">Login</button>
				<%}else { %>
					<button onclick="location.href = '/MyHome/Login/IDFindForm.jsp'">Login</button>
				<%} %>
				<button onclick="location.href = '/MyHome/Login/PWFindForm.jsp<%=id != null ? "?id=" + id : "" %>'">PW찾기</button>
			</td>
		</tr>
	</table>
</div>
<%@include file="/Layout/Footer.jsp" %>















