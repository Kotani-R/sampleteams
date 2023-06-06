<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
<link rel="stylesheet" href="./css/top.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	<!--  -->
	<div class="position">
		<div class="back">
			<div class="text">
				<div class="registerIntroduction">
					<!--入力画面のコントローラーのURLパターンとアクション属性をセット -->
					<div>
						<h2>自己紹介登録</h2>
					</div>
					<div class="btn-area">
						<a href="RoginController?action = rgs">登録に進む</a>
					</div>
				</div>

				<p>
					新しく自己紹介を作ります。<br> あなたをより知ってもらうために<br> 趣味や一言を工夫しましょう<br>
					最高の自己紹介を完成させて、よりあなたを<br> 知ってもらえるチャンスにしましょう。
				</p>
				<div class="registerIntroduction">
					<div>
						<!--一覧画面のコントローラーのURLパターンとアクション属性をセット -->
						<h2>自己紹介登録者一覧</h2>
					</div>
					<div class="btn-area">
						<a href="RoginController?action = list">一覧画面に進む</a>
					</div>
				</div>
				<p>
					登録している人を確認します。<br> 登録している人の自己紹介記事を見てみましょう。
				</p>
			</div>
		</div>
	</div>
</body>
</html>