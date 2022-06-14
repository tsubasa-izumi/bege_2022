<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>memberRegister</title>
<link rel="canonical"
	href="https://getbootstrap.jp/docs/5.0/examples/sign-in/">
<!-- Bootstrap core CSS -->
<link
	href=https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<!-- Favicons -->
<link rel="apple-touch-icon"
	href="/docs/5.0/assets/img/favicons/apple-touch-icon.png"
	sizes="180x180">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-32x32.png"
	sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon-16x16.png"
	sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.0/assets/img/favicons/manifest.json">
<link rel="mask-icon"
	href="/docs/5.0/assets/img/favicons/safari-pinned-tab.svg"
	color="#7952B3">
<link rel="icon" href="/docs/5.0/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952B3">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}
@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<header>
		<div class="navbar navbar-dark bg-default shadow-sm">
			<form action="login.jsp">
				<div class="container">
					<input class="w-30 btn btn-lg btn-success" type="submit" value="戻る">
				</div>
			</form>
		</div>
	</header>
	<main class="form-signin">
		<form action="register" method="post">
			<img class="mb-0 pb-0"
				src="file:///C:/Users/user/Documents/GroupDevelopment5-2/bege/WebContent/pic/vege.png"
				alt="" width="500" height="350">
			<h1 class="h0 mb-3 fw-normal">会員登録</h1>
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-6">
						<label for="inputEmail" class="visually-hidden"> 名前</label> <input
							type="text" name="name" id="inputEmail"
							class="form-control" placeholder="名前" required> <br>
						<label for="inputPassword" class="visually-hidden">フリガナ</label> <input
							type="text" name="kana" id="inputPassword"
							class="form-control" placeholder="フリガナ" required><br>
						<label for="inputEmail" class="visually-hidden"> 電話番号</label> <input
							type="text" name="telnumber" id="inputEmail"
							class="form-control" placeholder="電話番号" required><br>
						<label for="inputEmail" class="visually-hidden"> メールアドレス</label> <input
							type="text" name="mail" id="inputEmail"
							class="form-control" placeholder="メールアドレス" required> <br>
						<label for="inputPassword" class="visually-hidden">パスワード</label> <input
							type="text" name="password" id="inputPassword"
							class="form-control" placeholder="パスワード" required><br>
						<label for="inputEmail" class="visually-hidden"> 秘密の質問</label> <input
							type="text" name="ques" id="inputEmail"
							class="form-control" placeholder="秘密の質問" required> <br>
						<label for="inputEmail" class="visually-hidden"> 秘密の質問の答え</label> <input
							type="text" name="ans" id="inputEmail"
							class="form-control" placeholder="秘密の質問の答え" required> <br>
						<label for="inputPassword" class="visually-hidden">住所</label> <input
							type="text" name="address" id="inputPassword"
							class="form-control" placeholder="住所" required> <br>
						<label for="inputEmail" class="visually-hidden"> 都道府県</label> <input
							type="text" name="prefecture" id="inputEmail"
							class="form-control" placeholder="都道府県" required> <br>
						<label for="inputPassword" class="visually-hidden">市区町村</label> <input
							type="text" name="city" id="inputPassword"
							class="form-control" placeholder="市区町村" required><br>
						<label for="inputPassword" class="visually-hidden">郵便番号</label> <input
							type="text" name="housenumber" id="inputPassword"
							class="form-control" placeholder="郵便番号" required><br>
						<label for="inputEmail" class="visually-hidden"> カード番号</label> <input
							type="text" name="cardnumber" id="inputEmail"
							class="form-control" placeholder="カード番号" required>
							<td>*数字で入力してください</td><br>
							<br>
						<label for="inputPassword" class="visually-hidden">セキュリティーコード</label>
						<input type="text" name="code" id="inputPassword"
							class="form-control" placeholder="セキュリティーコード" required>
							<td>*数字で入力してください</td><br>
							<br>
						<label for="inputPassword" class="visually-hidden">有効期限</label>
						<input type="text" name="cardlimit" id="inputPassword"
							class="form-control" placeholder="有効期限" required>
							<td>*数字で入力してください</td><br>
							<br>
						<label for="inputEmail" class="visually-hidden"> 名義</label> <input
							type="text" name="meigi" id="inputEmail"
							class="form-control" placeholder="名義" required> <br>
						<div class="checkbox mb-3">
						</div>
						<button class="w-100 btn btn-lg btn-success" type="submit">登録</button>
						<br> <br> <br> <br> <br> <br> <br>
						<br>
						</div>
					</div>
				</div>
			</div>
		</form>
	</main>
	<!-- Optional JavaScript; choose one of the two! -->
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
		crossorigin="anonymous"></script>
	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    -->
</body>
</html>