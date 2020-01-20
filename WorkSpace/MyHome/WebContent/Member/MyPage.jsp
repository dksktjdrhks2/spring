<%@page import="member.memberDTO.MemberDTO"%>
<%@page import="member.memberDAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("login");
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.memberInfo(id);
	session.setAttribute("member", dto);
%>

<%@include file = "/Layout/Header.jsp" %>
 <table border="1" width = "450">
 	<tr>
 		<td>번호</td>
 		<td><%=dto.getNo() %></td>
 	</tr>
 	<tr>
 		<td>아이디</td>
 		<td><%=dto.getId() %></td>
 	</tr>
 	 	<tr>
 		<td>이름</td>
 		<td><%=dto.getName() %></td>
 	</tr>
 	 	<tr>
 		<td>이메일</td>
 		<td><%=dto.getEmail() %></td>
 	</tr>
 	 	<tr>
 		<td>전화번호</td>
 		<td><%=dto.getTel1() %>-<%=dto.getTel2() %>-<%=dto.getTel3() %></td>
 	</tr>
 	<tr>
 		<td colspan="2" align="right">
 			<input type="button" value = "수정" onclick="location.href = '/MyHome/Member/UpdateForm.jsp'">
 			<input type="button" value = "회원탈퇴" onclick="location.href = '/MyHome/Member/DeleteForm.jsp'">
 		</td>
 	</tr>
 </table>
<%@include file = "/Layout/Footer.jsp" %>