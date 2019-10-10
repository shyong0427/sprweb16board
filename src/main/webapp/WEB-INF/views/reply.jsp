<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글</title>
	<script type="text/javascript">
		function check() {
			if(frm.name.value === "") {
				alert("이름을 입력해주세요.");
				frm.name.focus();
				return;
			}
			
			// 생략
			
			frm.submit();
		}
	</script>
</head>
<body>
	<h2>* 댓글 쓰기 *</h2>
	<form action="reply" method="post" name="frm">
	<input type="hidden" name="num" value="${data.num }">
	<input type="hidden" name="page" value="${page }">
	<input type="hidden" name="gnum" value="${data.gnum }">
	<input type="hidden" name="onum" value="${data.onum }">
	<input type="hidden" name="nested" value="${data.nested }">
	<input type="hidden" name="bip" value="${data.bip }">
		<table border="1">
			<tr>
				<td style="text-align: center;">작 성 자</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td style="text-align: center;">비밀번호</td>
				<td><input type="text" name="pass"></td>
			</tr>
			<tr>
				<td style="text-align: center;">이 메 일</td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td style="text-align: center;">제      목</td>
				<td><input type="text" name="title" value="[Re]:${data.title }" style="width: 95%"></td>
			</tr>
			<tr>
				<td style="text-align: center;">내      용</td>
				<td>
					<textarea rows="5" style="widht: 95%" name="cont"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="button" value="작성 완료" onclick="check()">&nbsp;
					<input type="button" value="목록 보기" onclick="location.href='list?page=${page}'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>