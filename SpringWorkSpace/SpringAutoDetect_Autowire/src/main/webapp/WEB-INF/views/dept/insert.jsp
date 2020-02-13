<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
	function send1( f ) {
		f.action = "insert.do";
		f.submit();
	}
	</script>
	<body>
	
		<div align="center">
				<form>
					<table border="1">
						<tbody>
							<tr>
								<th>부서번호</th>
								<td>
									<input type="text" name="deptno">
								</td>
							</tr>	
							<tr>
								<th>부서명</th>
								<td>
									<input type="text" name="dname">
								</td>
							</tr>
							<tr>
								<th>위치</th>
								<td>
									<input type="text" name="loc">
								</td>
							<tr>
								<td colspan="2" align="right">						
									<button type="button" onclick="send1(this.form)">작성</button>
								</td>
							</tr>			
						</tbody>			
					</table>
				</form>
		</div>
	</body>
</html>