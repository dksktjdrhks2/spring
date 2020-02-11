<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<th id = "border">제목</th>
				<td id = "border">${vo.title }</td>
				<th id = "border">작성일</th>
				<td id = "border">${vo.logtime }</td>
			</tr>
			<tr>
				<th id = "border">작성자</th>
				<td id = "border">${vo.name }</td>
				<th id = "border">조회수</th>
				<td id = "border">${vo.hit }</td>
			</tr>
			<tr>
				<td colspan="4" id = "border" style="min-height: 200px">
					${vo.content }
				</td>
			</tr>
			 <tr>
				<th id = "border">첨부파일</th>
				<td id = "border" colspan="3">
					<a href = "/MyHome/FileDownload.brd?filename=${vo.filename }" id = "link">${vo.filename }</a>
				</td>
			</tr>
		</table>
		<%-- <div id = "button" align="right">
			<c:if test="${sessionScope.login == dto.id }">
				<input type="button" value = "수정" onclick="location.href = '/MyHome/Board/Update.brd'">
				<input type="button" value = "삭제" onclick="location.href = '/MyHome/Board/Delete.brd'">
			</c:if>--%>
			<input type="button" value = "목록으로" onclick="location.href = 'list.do'">
		<%--</div>	 --%>
	</div>
</body>
</html>