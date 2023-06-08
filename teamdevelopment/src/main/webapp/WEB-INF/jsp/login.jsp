<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="./css/login.css">
</head>

<body>
	<!-- headerのインクルード -->
	<jsp:include page="header.jsp" />

	<div class="form">
		<h1>ログイン</h1>
		<!-- postリクエスト -->
		<!-- UserIDとPassWordを送信 -->
		<form action="LoginController" method="post">
			<div class="inputs">
				<label class="label">UserID</label> <input class="input_form"
					type="text" name="id">
			</div>
			<div class="inputs">
				<label class="label">Password</label> <input class="input_form"
					type="password" name="pass">
			</div>

			<input type="hidden" name="newRegister" value="no">
			<div class="btn-area">
				<input type="submit" value="ログイン">
			</div>
		</form>
		<p class="link">
			<!-- 新規下院登録画面へ遷移 -->
			<a href="LoginController?action=new">新規会員登録はこちら</a>
		</p>
	</div>
</body>
</html>