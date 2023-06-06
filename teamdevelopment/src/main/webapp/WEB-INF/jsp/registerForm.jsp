<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" href="./css/registerForm.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>新規会員登録</h1>
	<form action="LoginController" method="post">
		<div class="inputs">
			<label class="label">UserID</label>
			<label class="requiredItems">必須</label>
			 <input class="input_form"
				type="text" name="id">
		</div>
		<div class="inputs">
			<label class="label">MailAddress</label>
			<label class="requiredItems">必須</label>
			 <input class="input_form"
				type="email" name="address">
		</div>

		<div class="inputs">
			<label class="label">PassWord</label> 
			<label class="requiredItems">必須</label>
			<input class="input_form"
				type="password" name="pass">
		</div>
		<input type="hidden" name="newRegister" value="ok"> 
		<div class="btn-area">
		<input type="submit" value="登録">
		</div>
	</form>
	<p class="link">
	<a href="LoginController">ログイン画面へ</a>
</body>
</html>