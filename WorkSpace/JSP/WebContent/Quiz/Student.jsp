<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	//var a = 123.456789;
	//alert(a);
	function check(){
		if(document.f.name.value == ""){
			alert("이름을 입력하십시오!!!");
		}else if(document.f.java.value == ""){
			alert("Java를 입력하십시오!!!");
		}else if(document.f.jsp.value == ""){
			alert("Jsp를 입력하십시오!!!");
		}else if(document.f.spring.value == ""){
			alert("Spring를 입력하십시오!!!");
		}else{
			document.f.submit();
		}
		
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="/JSP/Quiz/StudentResult.jsp" method="post" name = "f">
			<table border="1">
				<tr>
					<th>Name</th>
					<td><input type="text" name = "name"></td>
				</tr>
				<tr>
					<th>Java</th>
					<td><input type="text" name = "java"></td>
				</tr>
				<tr>
					<th>JSP</th>
					<td><input type="text" name = "jsp"></td>
				</tr>
				<tr>
					<th>Spring</th>
					<td><input type="text" name = "spring"></td>
				</tr>
				<tr>
					<th colspan="2" align="right">
						<input type="button" value = "전송" onclick = "javascript:check()">
						<input type="button" value = "다시쓰기" onclick = "document.f.reset()">
					</th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>