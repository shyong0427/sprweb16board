<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 쓰기</title>
	<script type="text/javascript">
		function check() {
			if(frm.name.value === "") {
				alert("작성자를 입력해주세요.");
				frm.name.focus();
				return;
			}
			
			// 생략
			
			frm.submit();
		}
	</script>
</head>
<body>
	<h2>** 글쓰기 **</h2>
	<form action="write" method="post" name="frm">
		<table border="1" style="width: 80%">
			<tr>
				<td width="100" style="text-align: center;">이      름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="100" style="text-align: center;">비밀번호</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td width="100" style="text-align: center;">이 메 일</td>
				<td><input type="email" name="mail"></td>
			</tr>
			<tr>
				<td width="100" style="text-align: center;">글 제 목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td width="100" style="text-align: center;">글 내 용</td>
				<td>
					<textarea rows="10" cols="50" name="cont"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right;">
					<input type="hidden" name="bip" value="<%=request.getRemoteAddr() %>">
					<input type="button" value="작 성" onclick="check()">
					<input type="button" value="목 록" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>