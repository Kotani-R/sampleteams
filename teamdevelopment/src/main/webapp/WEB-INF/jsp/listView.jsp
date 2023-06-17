<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="object.userList, java.util.List"%>
<%
List<userList> userlist = (List<userList>) request.getAttribute("userlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録者一覧</title>
<link rel="stylesheet"
	href="https://unpkg.com/modern-css-reset/dist/reset.min.css">
<link rel="stylesheet" href="./css/styleList.css">
</head>
<body>
	<div class="center">
		<p><h1>自己紹介登録者一覧</h1></p>
		<table>
			<tr>
				<th class="reft"><h2>ID</h2></th>
				<th class="right"><h2>名前</h2></th>
			</tr>
			<%
			for (userList use : userlist) {
			%>
			<tr>
				<td class="left change"><a href="Choose_Id?id=<%= use.getId() %>"><%= use.getId() %></a></td>
				<td class="right"><%= use.getName() %></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>