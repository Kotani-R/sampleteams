<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body>
<header>
JavaTeamDevelopment
</header>
<main>
<h1>ログイン</h1>
<form action="LoginController" method="post">
UserID:<input type="text" name= "id"><br>
password:<input type="password" name= "pass"><br>
<input type="hidden" name = "newRegister" value="no">
<input type="submit" value="登録">
</form>
<p>
<a href="LoginController?action=new">新規会員登録はこちら</a>
</p>
</main>
</body>
</html>