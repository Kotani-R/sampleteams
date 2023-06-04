<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" href="../css/registerForm.css">
</head>
<body>
<p>新規会員登録</p>
<form action="LoginController" method="post">
UserID:<input type="text" name= "id"><br>
MailAddress:<input type="text" name= "address"><br>
PassWord:<input type="password" name= "pass"><br>
<input type="hidden" name = "newRegister" value="ok">
<input type="submit" value="登録">
</form>
<a href="LoginController">ログイン画面へ</a>
</body>
</html>