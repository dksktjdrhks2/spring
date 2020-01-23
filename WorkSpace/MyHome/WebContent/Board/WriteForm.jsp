<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<script>
	function checkWrite() {
		if(document.write.title.value == ""){
			alert('제목을 입력하십시오!');
		}else if(document.write.content.value == ""){
			alert('내용을 입력하십시오!');
		}else{
			document.write.submit();
		}
	}
</script>    

<jsp:include page="/Layout/Header.jsp"/>

<div align="center">
	<form action="/MyHome/CheckWrite.brd" method="post" name = "write"
			enctype="multipart/form-data"> <!-- 데이터까지 전송 -->
		<input type="hidden" name = "id" value="${login }">
		<table id = "table">
			<tr>
				<th width="60" id = "border">제목</th>
				<td id = "border"><input type="text" name = "title" size = "53"></td>
			</tr>
			<tr>
				<td colspan="2" id = "border">
					<textarea rows="15" cols="65" name = "content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" id = "border">
					<input type="file" name = "filename" size = "400">
				</td>
			</tr>
		</table>
		<div id = "button">
			<input type="button" value="쓰기" onclick="javascript:checkWrite()">
		</div>
	</form>
</div>

<jsp:include page="/Layout/Footer.jsp"/>