<%@page import="member.memberDAO.MemberDAO"%>
<%@page import="member.memberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDTO dto = (MemberDTO)session.getAttribute("member");
	dto.setEmail(request.getParameter("email"));
	dto.setTel1(request.getParameter("tel1"));
	dto.setTel2(request.getParameter("tel2"));
	dto.setTel3(request.getParameter("tel3"));
	
	MemberDAO dao = new MemberDAO();
	boolean check = dao.updateMember(dto);
	
	out.write("<script>");
	if(check){
		session.setAttribute("member", dto);
		out.write("alert('수정완료!!MyPage로...');");
		out.write("location.href = '/MyHome/Member/MyPage.jsp';");
	}else{
		out.write("alert('수정실패!!이전페이지로...');");
		out.write("history.back();");
	}
	out.write("</script>");
	
%>













