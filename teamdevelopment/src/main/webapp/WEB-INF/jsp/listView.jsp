<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="object.userList, java.util.List" %>
<%
List<userList> userlist = (List<userList>)request.getAttribute("userlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th>ID</th>
<th>名前</th>
</tr>
<% for (userList use : userlist) { %>
<tr>
<td><a href="Choose_Id?id=<%= use.getId() %>"><%= use.getId() %></a></td>
<td><%= use.getName() %></td>
</tr>
<% } %>
</table>
</body>
</html>