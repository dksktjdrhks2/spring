<%@page import="member.memberDAO.MemberDAO"%>
<%@page import="member.memberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="member.memberDTO.MemberDTO" scope="page"/>
<jsp:setProperty property="*" name="dto"/>
<%
	//System.out.println(request.getCharacterEncoding());
	/*MemberDTO dto = new MemberDTO();
	dto.setId(request.getParameter("id"));
	dto.setPassword(request.getParameter("password"));
	dto.setName(request.getParameter("name"));
	dto.setEmail(request.getParameter("email"));
	dto.setTel1(request.getParameter("tel1"));
	dto.setTel2(request.getParameter("tel2"));
	dto.setTel3(request.getParameter("tel3"));*/

	MemberDAO dao = new MemberDAO();
	
	boolean check = dao.insert(dto);
	
	out.write("<script>");
	if(check){
		out.write("alert('회원가입에 성공하셨습니다!!로그인페이지로....');");
		out.write("location.href = '/MyHome/Login/LoginForm.jsp?id=" + dto.getId() + "';");
	}else{
		out.write("alert('회원가입에 실패하셨습니다!!이전페이지로....');");
		out.write("history.back();");
	}
	out.write("</script>");
%>





















