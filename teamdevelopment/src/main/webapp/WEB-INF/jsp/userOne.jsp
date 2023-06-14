<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="object.userList, java.util.List" %>
<%
userList user = (userList)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>自己紹介</h1>
<p><%= user.getName() %></p>
<p><%= user.getSex() %></p>
<p><%= user.getKanri() %></p>
<p><%= user.getSelf_intro() %></p>
<div>
<a href="ListView">戻る</a>
<a href="">編集</a>
<a href="Delete_User_Info?id=<%= user.getId() %>">削除</a>
</div>
</body>
</html>