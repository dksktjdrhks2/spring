<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function send( f ){
			
			var title = f.title.value;
			var photo = f.photo.value;
			
			if( title == '' ){
				alert("제목을 입력하세요");
				f.title.focus();
				return;
			}
			
			if( photo == '' ){
				alert("전송할 사진을 선택하세요");
				return;
			}
			
			f.action = "upload.do";
			f.submit();
			
		}//send()
	</script>

</head>
<body>

	<!-- 파일업로드를 위해서는 반드시 POST타입으로 전송해야 하며, enctype이 필요하다 -->
	<form method="POST" enctype="multipart/form-data">

		제목:<input name="title"><br>
		사진:<input type="file" name="photo"><br>
		<input type="button" value="전송" onclick="send(this.form);">

	</form>
	
</body>
</html>