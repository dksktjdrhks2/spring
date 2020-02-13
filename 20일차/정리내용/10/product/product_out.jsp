<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<caption>::::출고목록::::</caption>
	<tr>
		<th>제품명</th>
		<th>수량</th>
		<th>입고일자</th>
	</tr>
	
	<c:if test="${ empty map.out_list }">
		<td colspan="3" align="center">
		   출고목록이 없습니다
		</td>
	</c:if>
	
	<c:forEach var="vo" items="${ map.out_list }">
		<tr>
			<td>${ vo.name }</td>
			<td>${ vo.cnt }</td>
			<td>${ vo.regdate }</td>
		</tr>
	</c:forEach>
	
</table>


</body>
</html>