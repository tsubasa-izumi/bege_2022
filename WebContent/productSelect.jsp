<%@ page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.ManagementDTO"%>
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
<title>productSelect</title>
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
			<form action="logOut.jsp">
				<div class="container">
					<input class="w-30 btn btn-lg btn-success" type="submit"
						value="ログアウト">
				</div>
			</form>
			<form method="post" action="productBuy.jsp">


		</div>
		<br> <img class="mb-0 pb-0"
			src="pic/img1.gif"
			alt="野菜イメージ" width="100%" height="100%">
	</header>
	<main class="form-signin">
		<br>

			<h1 class="h0 mb-3 fw-normal">商品をお選び下さい</h1>

			<table border="1" style="border-collapse: collapse" >
		<tr>
			<td><img src="pic/misakik.gif" alt="岬キャベツ" width="310"
				height="200">岬キャベツ</td>

			<td><img src="pic/hakusai.gif" alt="白菜" width="310" height="200">白菜</td>
			<td><img src="pic/kourai.gif" alt="高麗人参" width="310"
				height="200">高麗人参</td>
			<td><img src="pic/tomato2.gif" alt="新鮮トマト" width="310"
				height="200">新鮮トマト</td>
		</tr>
		</table>
<br>
<br>
<div class="navbar navbar-dark bg-default shadow-sm">

				<div class="container">

<form method="post" action="productBuy.jsp">


		<%
		ArrayList<ManagementDTO> list = (ArrayList<ManagementDTO>) session.getAttribute("maneList");
		%>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<select name="idItem<%=i%>">
			<option value="1">岬キャベツ</option>

			<option value="2">白菜</option>

			<option value="3">高麗人参</option>

			<option value="4">新鮮トマト</option>
		</select> <select name="ItemCount<%=i%>">
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		<%
		}
		%>
			<div class="navbar navbar-dark bg-default shadow-sm">

				<div class="container">
					<input class="w-30 btn btn-lg btn-success" type="submit"
						value="購入">
				</div>
			</div>

	</form>
</div>
</main>

	<hr>
<div>
<a href="memberEdit.jsp">会員情報の編集はこちら</a>
</div>
<div>
<br>
<a href="memberDelete.jsp">退会をご希望の方はこちら</a>


</div>




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





































