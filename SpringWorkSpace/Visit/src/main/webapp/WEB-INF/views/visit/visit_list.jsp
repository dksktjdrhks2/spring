<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/visit.css">
<script type="text/javascript">
	function modify( f ) {
		
	}
	
	function del( f ) {
		
	}
</script>
</head>
<body>
	<!-- 현재 ContextPath : ${pageContext.request.contextPath }<br> -->
	<div id="main_box">
	<h1>::::방명록 리스트::::</h1>
	<div align="center">
		    <input type="button"  value="글쓰기" 
		           onclick="javascript:location.href='insert_form.do'">
		</div>
		
		<!--  for(VisitVo vo : list ) -->
		<c:forEach var="vo" items="${ list }">
	
			<div class="visit_box">
			  <div class="type_content">${ vo.content }</div>
			  <div class="type_name">작성자:${ vo.name } (${ vo.ip })</div>
			  <div class="type_regdate">작성일자:${ vo.regdate }</div>
	
			  <div>
				  <form>   
				      <input type="hidden" name="idx" value="${ vo.idx }">
				      <input type="hidden" name="pwd" value="${ vo.pwd }">
				      
				      비밀번호(${ vo.pwd }):<input type="password"  name="c_pwd">
				      
				      <input type="button"    value="수정" 	
									onclick="modify(this.form);">
				             
				      <input type="button"    value="삭제"  
									onclick="del(this.form);">
				  </form>    
			  </div>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>