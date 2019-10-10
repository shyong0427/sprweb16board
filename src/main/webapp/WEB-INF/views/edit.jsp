<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>
	<h2>* 글 수 정 * </h2>
	<form action="edit" method="post" name="frm">
		<table border="1">
			<tr>
				<td>이      름</td>
				<td>
					<input type="text" name="name" value="${data.name }">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="text" name="pass">
				</td>
			</tr>
			<tr>
				<td>메일주소</td>
				<td>
					<input type="text" name="mail" value="${data.mail }">
				</td>
			</tr>
			<tr>
				<td>제      목</td>
				<td>
					<input type="text" name="title" value="${data.title }">
				</td>
			</tr>
			<tr>
				<td>내      용</td>
				<td>
					<textarea rows="5" cols="50" name="cont">${data.cont }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="button" value="수정 완료" onclick="chk()">&nbsp;
					<input type="button" value="목록 보기" onclick="location.href='list?page=${page}'">&nbsp;
				</td>
			</tr>
		</table>
	</form>
</body>
</html>