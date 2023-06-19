<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規会員登録</title>
<link rel="stylesheet" href="./css/sanitize.css">
<link rel="stylesheet" href="./css/registerForm.css">

</head>
<body>
	<jsp:include page="header.jsp" />
	<h1>新規会員登録</h1>
	<form action="LoginController" method="post">
		<div class="inputs">
			<label class="label">UserID</label> <label class="requiredItems">必須</label>
			<%-- ID入力欄 --%>
			<input type="text" name="id">
		</div>
		<div class="inputs">
			<label class="label">MailAddress</label> <label class="requiredItems">必須</label>
			<%-- メールアドレス入力欄 --%>
			<input type="email" name="address">
		</div>

		<div class="inputs">
			<label class="label">PassWord</label> <label class="requiredItems">必須</label>
			 <%-- パスワード入力欄 --%>
			<input type="password" name="pass">
		</div>
		<input type="hidden" name="newRegister" value="ok">
		<div class="btn-area">
			<%-- 送信ボタン --%>
			<input type="submit" value="登録">
		</div>
	</form>
	<p class="link">
		<a href="LoginController">ログイン画面へ</a>
</body>
</html>