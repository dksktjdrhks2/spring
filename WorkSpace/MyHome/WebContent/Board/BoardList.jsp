<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/Layout/Header.jsp"/>
	<div align="center">
		<table id = "table">
			<tr>
				<th id = "border">번호</th>
				<th id = "border">글제목</th>
				<th id = "border">아이디</th>
				<th id = "border">작성일</th>
				<th id = "border">조회수</th>
			</tr>
			<c:choose>
				<c:when test="${list != null }">
					<c:forEach var = "dto" items="${list }">
						<tr>
							<td id = "border" align="center">${dto.seq }</td>
							<td id = "border" width="200px">${dto.title }</td>
							<td id = "border" align="center">${dto.id }</td>
							<td id = "border" align="center">${dto.logtime }</td>
							<td id = "border" align="center">${dto.hit }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<th colspan="5" id="border">작성한 글이 없습니다</th>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		<c:if test="${login != null }">
			<div id="button">
				<input type="button" value="글쓰기">
			</div>
		</c:if>
	</div>
<jsp:include page="/Layout/Footer.jsp"/>