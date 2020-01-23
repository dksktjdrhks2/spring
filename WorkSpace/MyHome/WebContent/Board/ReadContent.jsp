<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/Layout/Header.jsp"/>

<div align="center">
		<table id = "table">
			<tr>
				<th id = "border">제목</th>
				<td id = "border"></td>
				<th id = "border">작성일</th>
				<td id = "border"></td>
			</tr>
			<tr>
				<th id = "border">작성자</th>
				<td id = "border"></td>
				<th id = "border">조회수</th>
				<td id = "border"></td>
			</tr>
			<tr>
				<td colspan="4" id = "border" >
					
				</td>
			</tr>
			<tr>
				<th id = "border">첨부파일</th>
				<td id = "border" colspan="3">
					<a href = "" id = "link"></a>
				</td>
			</tr>
		</table>
		<div id = "button" align="right">
			<input type="button" value = "목록으로" onclick="location.href = '/MyHome/Board/BoardList.jsp'">
		</div>	
	</div>

<jsp:include page="/Layout/Footer.jsp"/>