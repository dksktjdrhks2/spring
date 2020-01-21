<%@page import="member.memberDAO.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%	
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	String name = null;
	String msg = null;
	boolean check = false;
	
	MemberDAO dao = new MemberDAO();
	name = dao.checkLogin(id, password);
	if(name != null){
		msg = name + "님 환영합니다!!!";
		check = true;
		
		session.setAttribute("login", id);
		
		//쿠키생성
		String ckid = request.getParameter("ckid");
		
		if(ckid != null){
			Cookie ck = new Cookie("ckid",id);
			ck.setMaxAge(60 * 60);
			response.addCookie(ck);//쿠키파일 생성
		}else{
			Cookie[] cks = request.getCookies();
			if(cks != null){
				for(Cookie ck : cks){
					if(ck.getName().equals("ckid")){
						if(ck.getValue().equals(id)){
							ck.setMaxAge(0);
							response.addCookie(ck);
						}
						break;
					}
				}
			}
		}
	}else{
		msg = "아이디 혹은 비밀번호가 잘못되었습니다.";
	}
	
	request.setAttribute("name", name);
	request.setAttribute("msg", msg);
	request.setAttribute("check", check);
	
	
	
	pageContext.forward("/Login/LoginResult.jsp");
%> --%>














