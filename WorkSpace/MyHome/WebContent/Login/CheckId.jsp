<%@page import="member.memberDAO.MemberDAO"%>
<%@page import="member.memberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");

	MemberDTO dto = new MemberDTO();
	dto.setName(name);
	dto.setTel1(tel1);
	dto.setTel2(tel2);
	dto.setTel3(tel3);
	
	MemberDAO dao = new MemberDAO();
	
	String id = dao.findID(dto);

	request.setAttribute("id", id);
	
	pageContext.forward("/Login/ResultId.jsp");
%>

















