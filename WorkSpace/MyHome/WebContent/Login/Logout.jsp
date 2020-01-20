<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session.removeAttribute("login");

	session.invalidate();//세션 초기화

	session = request.getSession();
	
	session.setAttribute("login", null);
	
	out.println("<script>");
	out.println("alert('로그아웃되었습니다.');");
	out.println("location.href = '/MyHome/Index.jsp';");
	out.println("</script>");

%>