<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="object.userList, java.util.List, java.util.Arrays"%>
<%
userList user = (userList) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介</title>
<link rel="stylesheet" href="https://unpkg.com/modern-css-reset/dist/reset.min.css">
<link rel="stylesheet" href="./css/styleList.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="center1">
		<h1>自己紹介</h1>
		<table>
			<tr>
				<td class="left1">管理番号</td>
				<td class="right1"><%= user.getKanri()%></td>
			</tr>
			<tr>
				<td class="left1">名前</td>
				<td class="right1"><%= user.getName()%></td>
			</tr>
			<tr>
				<td class="left1">性別</td>
				<td class="right1"><%= user.getSex()%></td>
			</tr>
			<tr>
				<td class="left1">趣味</td>
				<td class="right1">
				<% for (int i = 0; i < user.getHobby().length; i++) { %>
					<%= user.getHobby()[i] %>
					<% if (i < user.getHobby().length - 1) { %>
					,
					<% } %>
				<% } %>
				</td>
			</tr>
			<tr>
				<td class="left1">一言</td>
				<td class="right1"><%= user.getSelf_intro()%></td>
			</tr>
		</table>
		<div class="order">
			<a href="ListView" class="blue">戻る</a> 
			<a href="" class="blue">編集</a> 
			<% if (user.getId().equals("ponsan")) { %>
			<a href="Delete_User_Info?id=<%= user.getId()%>" class="red">削除</a>
			<% } %>
		</div>
	</div>
	<script src="./js/keikoku.js"></script>
</body>
</html>