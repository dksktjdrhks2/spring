<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table id = "table" border="1">
			<tr>
				<th id = "border">번호</th>
				<th id = "border">글제목</th>
				<th id = "border">아이디</th>
				<th id = "border">작성일</th>
				<th id = "border">조회수</th>
			</tr>
			<c:choose>
				<c:when test="${list != null }">
					<c:forEach var = "vo" items="${list }">
						<tr>
							<td id = "border" align="center">${vo.seq }</td>
							<td id = "border" width="200px"><a href="board_content.do?seq=${vo.seq }" style="text-decoration: none; font-weight: bold;" >${vo.title }</a></td>
							<td id = "border" align="center">${vo.id }</td>
							<td id = "border" align="center">${vo.logtime }</td>
							<td id = "border" align="center">${vo.hit }</td>
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
	</div>
</body>
</html>