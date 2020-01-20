<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script type="text/javascript">
	function check(){
		if(document.form.name.value == ""){
			alert("이름을 입력하십시오!!!");
		}else if(document.form.tel2.value == "" || document.form.tel3.value == ""){
			alert("전화번호를 하십시오!!!");
		}else{
			document.form.submit();
		}
	}

</script>
<%@include file="/Layout/Header.jsp" %>
<div align="center">
	<form action = "/MyHome/Login/CheckId.jsp" name = "form" method="post">
		<table border="1">
			<tr>
				<th colspan="2">아이디 찾기</th>
			</tr>
			<tr>
				<th>Name</th>
				<td><input type="text" name = "name"></td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>
					<select name = "tel1">
						<option value="010" selected="selected">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="019">019</option>
					</select>
					-<input type="text" size = "5" maxlength = "4" name = "tel2">
					-<input type="text" size = "5" maxlength = "4" name = "tel3">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="Find" onclick = "javascript:check()">
					<input type="button" value="Back" onclick = "history.back()">
				</td>
			</tr>
		</table>	
	</form>
</div>
<%@include file="/Layout/Footer.jsp" %>













