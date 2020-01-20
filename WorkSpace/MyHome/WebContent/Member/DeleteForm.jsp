<%@page import="member.memberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDTO dto = (MemberDTO)session.getAttribute("member");
%>
<script type="text/javascript">
	function check(){
		if(document.del.password.value == ""){
			alert("비밀번호를 입력하십시오!!!");
		}else{
			document.del.submit();
		}
	}
</script>
<%@include file="/Layout/Header.jsp" %>
<div align="center">
	<form action="/MyHome/Member/CheckDelete.jsp" method="post" name = "del">
		<table border="1">
			<tr>
				<th><%=dto.getId() %>님의 비밀번호 확인</th>
			</tr>
			<tr>
				<td>
					<input type="password" name = "password" placeholder="비밀번호 확인">
				</td>
			</tr>
			<tr>
				<td align="right">
					<input type="button" value="탈퇴" onclick="javascript:check()">
					<input type="button" onclick="history.back()" value="돌아가기">				
				</td>
			</tr>
		</table>
	</form>
</div>


<%@include file="/Layout/Footer.jsp" %>