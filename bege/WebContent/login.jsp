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
<title>Signin Template for Bootstrap · Bootstrap v5.0</title>
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
<%
	String error = (String) request.getAttribute("error");
	%><%
			if (error != null) {
			%>
			<h3><%=error%></h3>
			<%
			}
			%>
	<header>
		<div class="navbar navbar-dark bg-default shadow-sm">
			<form action="hp.html">
				<div class="container">
					<input class="w-30 btn btn-lg btn-success" type="submit" value="戻る">
				</div>
			</form>
		</div>
	</header>
	<main class="form-signin">
		<form action="productSelect" method="post">
			<img class="mb-0 pb-0" src="pic/vege.png"
				alt="" width="500" height="350">
			<h1 class="h0 mb-3 fw-normal">ログインする</h1>
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-6">
						<label for="inputEmail" class="visually-hidden"> メールアドレス</label> <input
							type="text" name="mail_address" id="inputEmail"
							class="form-control" placeholder="メールアドレス" required>
						<br> <label for="inputPassword" class="visually-hidden">パスワード</label>
						<input type="password" name="pass" id="inputPassword"
							class="form-control" placeholder="パスワード" required>
						<div class="checkbox mb-3">
							<br>
							<tr>
								<td><a href="memberRegister.jsp">会員登録がお済でない方はこちら</a></td>
							</tr>
							<br>
							<tr>
								<td><a href="passwordSet.jsp">パスワードをお忘れの方はこちら</a></td>
							</tr>
							<br>
						</div>
						<button class="w-100 btn btn-lg btn-success" type="submit">ログイン</button>
						<br> <br> <br> <br> <br> <br> <br>
						<br>
						<h1 class="h0 mb-3 fw-normal">管理者ログインはこちら</h1>
						<label for="inputEmail" class="visually-hidden"> ID</label> <input
							type="email" id="inputEmail" class="form-control"
							placeholder="ID" autofocus> <br> <label
							for="inputPassword" class="visually-hidden">パスワード</label> <input
							type="password"id="inputPassword" class="form-control"
							placeholder="パスワード">
						<div class="checkbox mb-3">
							<br>
							<button class="w-100 btn btn-lg btn-primary" type="submit">ログイン</button>
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