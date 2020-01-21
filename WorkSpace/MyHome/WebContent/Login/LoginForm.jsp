<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	boolean check = false;

	if(id == null){
		Cookie[] cks = request.getCookies();
		
		if(cks != null){
			for(Cookie ck : cks){
				if(ck.getName().equals("ckid")){
					id = ck.getValue();
					check = true;
					break;
				}
			}
		}
		
		if(id == null){
			id = "";
		}
	}
	

	
%>   

<script type="text/javascript">
	function check(){
		if(document.login.id.value == ""){
			alert("아이디를 입력하십시오!!!");
		}else if(document.login.password.value == ""){
			alert("비밀번호를 입력하십시오!!!");
		}else{
			document.login.submit();
		}
	}
</script>
<%@include file="/Layout/Header.jsp" %>
<div align="center">
	<form action="/MyHome/Login/CheckLogin" method="post" name = "login">
		<table id = "border" style="border-spacing: 0px;">
			<tr>
				<th id = "border">ID</th>
				<td id = "border"><input type="text" name = "id" value = "<%=id %>"></td>
			</tr>
			<tr>
				<th id = "border">PW</th>
				<td id = "border"><input type="password" name = "password"></td>
			</tr>
			<tr>
				<td colspan="2" align="right" id = "border">
					<%if(check) {%>
						<input type="checkbox" value = "true" name = "ckid" checked="checked">
					<%}else { %>
						<input type="checkbox" value = "true" name = "ckid">
					<%} %>
					<font size="1">아이디기억하기</font>
					<input type="button" value="Login" onclick="javascript:check()">
					<input type="button" value="Cancle" onclick="document.login.reset()">
				</td>
			</tr>
		</table>
	</form>
		<a href = "/MyHome/Login/IDFindForm.jsp">ID찾기</a>
</div>
<%@include file="/Layout/Footer.jsp" %>












