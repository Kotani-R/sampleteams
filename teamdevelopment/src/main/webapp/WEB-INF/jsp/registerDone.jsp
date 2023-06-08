<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- インポートユーザー情報 -->
<%@ page import="object.User"%>
<%
// リクエストスコープでユーザー情報を取得!!!!!!!!!!!!!!!!!!!!!!!!!!
// 属性名をセットするファイル名を教えてもらう!!!!!!!!!!!!!!!!!!!!!!!!!
User registerUser = (User) request.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
<link rel="stylesheet" href="./css/registerDone.css">
</head>
<body>
	<p>
	<h1>自己紹介の登録が完了しました！</h1>
	</p>
	<div>
		<p>下記内容の自己紹介の登録が完了しました！</p>
		<p>
			管理番号:<%=registerUser.adminNum()%><br> 名前:<%=registerUser.getName()%><br>
			フリガナ:<%=registerUser.getRubyName()%><br> 性別:<%=registerUser.getGender()%><br>
			趣味:<%=registerUser.getHobby()%><br> 一言:<%=registerUser.getComment()%><br>
		</p>
	</div>
	<a href="RoginController?action=in">TOPへ戻る</a>
</body>
</html>