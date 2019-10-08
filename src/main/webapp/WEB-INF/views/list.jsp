<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/board.css">
<title>게시판</title>
</head>
<body>
	<h2>* 게시판(@MVC + MyBatis) *</h2>
	<table>
		<tr>
			<td>
				[<a href="list?page=1">최근 목록</a>]&nbsp;
				[<a href="write">새 글 작성</a>]
			</td>
		</tr>
		<tr>
			<td>
				<table border="1">
					<tr>
						<th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
					</tr>
					<c:forEach var="b" items="${data }">
						<tr>
							<td>${b.num }</td>						
							<td>
								<a href="detail?num=${b.num }&page=${page }">${b.title }</a>
							</td>						
							<td>${b.name }</td>						
							<td>${b.bdate }</td>						
							<td>${b.readcnt }</td>						
						</tr>
					</c:forEach>
<!-- paging 처리 -->
					<tr style="text-align: center;">
						<td colspan="5">
							<c:forEach var="i" begin="1" end="${pageNum }">
								<c:if test="${i == page }">
									<b>${i }</b>
								</c:if>
								<c:if test="${i != page }">
								<a href="list?page=${i }">${i }</a>
								</c:if>
							</c:forEach>
						</td>
					</tr>
				</table>
			</td>
		</tr>
<!-- 검색 -->
		<tr style="text-align: center;">
			<td colspan="5">
				<form action="search" method="post">
					<select name="searchName">
						<option value="name">작성자</option>
						<option value="title">글제목</option>
					</select>
					<input type="text" name="searchValue">
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>