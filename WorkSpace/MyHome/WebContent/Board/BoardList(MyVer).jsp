<%@page import="board.boardDTO.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.boardDAO.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="/Layout/Header.jsp" %>

<style type="text/css">
	#header , #footer {
		border: 1px solid black;
		height: 40px;
		width: 600px;
		padding-top: 12px;
	}
	
	#main{
		width: 600px;
		min-height: 400px;
		padding-top: 15px;
	}
	
	#border{
		border: 1px solid black;
	}
	
	#table {
		width: 450px;
		border : 1px solid black;
		border-spacing: 0px
	}
	#button{
		width : 450px;
		text-align: right;
		padding-top: 15px;
	}
	
	#border {
		border : 1px solid black;
	}
	
	#link{
		text-decoration: none;
		font-weight: bold;
	}	
</style>

<%
				BoardDAO dao = BoardDAO.getInstance();
				ArrayList<BoardDTO> list = dao.getList();
				int count = list.size();
%>

<table id = "table">
					<tr>
						<th id = "border">번호</th>
						<th id = "border">글제목</th>
						<th id = "border">아이디</th>
						<th id = "border">작성일</th>
						<th id = "border">조회수</th>
					</tr>
					<%
						for(BoardDTO dto : list){
					%>
						<tr>
							<td id = "border" align="center"><%= dto.getSeq() %></td>
							<td id = "border" width="200px"><%= dto.getTitle() %></a></td>
							<td id = "border" align="center"><%= dto.getId() %></td>
							<td id = "border" align="center"><%= dto.getLogtime() %></td>
							<td id = "border" align="center"><%= dto.getHit() %></td>
						</tr>
						<tr><td colspan="5"><hr></tr>
					<% 		
						}
					%>
</table>

<%@include file="/Layout/Footer.jsp" %>