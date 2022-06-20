<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.ManagementDTO"%>
<%@ page import="dto.MemberDTO"%>
<!DOCTYPE html>
<html>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>productCheck</title>
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
			<form action="productSelect.jsp">
				<div class="text-right">
					<input class="w-30 btn btn-lg btn-primary" type="submit" value="戻る">
				</div>
			</form>
		</div>
		<br> <img class="mb-0 pb-0"
			src="pic/vege.png"
			alt="" width="500" height="350">
	</header>
	<%
	String totalsum = (String) request.getAttribute("totalsum");
	%>
	<%
	MemberDTO member = (MemberDTO) session.getAttribute("loginData");
	%>
	<%
	String quantity0 = (String) request.getAttribute("quantity0");
	%>
	<%
	String quantity1 = (String) request.getAttribute("quantity1");
	%>
	<%
	String quantity2 = (String) request.getAttribute("quantity2");
	%>
	<%
	String quantity3 = (String) request.getAttribute("quantity3");
	%>
	<%
	ManagementDTO dto0 = (ManagementDTO) request.getAttribute("dto0");
	%>
	<%
	ManagementDTO dto1 = (ManagementDTO) request.getAttribute("dto1");
	%>
	<%
	ManagementDTO dto2 = (ManagementDTO) request.getAttribute("dto2");
	%>
	<%
	ManagementDTO dto3 = (ManagementDTO) request.getAttribute("dto3");
	%>
	<%
	List<ManagementDTO> list = (List<ManagementDTO>) request.getAttribute("buyDataList");
	%>
	<h1>以下の商品が選択されました</h1>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">商品名</th>
				<th scope="col">農場名</th>
				<th scope="col">金額</th>
			</tr>
		</thead>
		<%
		for (ManagementDTO data : list) {
		%>
		<tbody>
			<tr>
				<th scope="row"><%=data.getItem_name()%></th>
				<td><%=data.getFarmer_name()%></td>
				<td><%=data.getItem_price()%></td>
			</tr>
		</tbody>
		<%
		}
		%>
	</table>
	<div class="row col-sm-2 offset-10 text-right">
		合計額<%=totalsum%>円
	</div>
	<form action="ProductConfirmAction" method="post">
		<input type="hidden" name=itemId0 value="<%=dto0.getItem_id()%>">
		<input type="hidden" name=total_price0
			value="<%=dto0.getItem_price()%>"> <input type="hidden"
			name=quantity0 value="<%=quantity0%>"> <input type="hidden"
			name=itemId1 value="<%=dto1.getItem_id()%>"> <input
			type="hidden" name=total_price1 value="<%=dto1.getItem_price()%>">
		<input type="hidden" name=quantity1 value="<%=quantity1%>"> <input
			type="hidden" name=itemId2 value="<%=dto2.getItem_id()%>"> <input
			type="hidden" name=total_price2 value="<%=dto2.getItem_price()%>">
		<input type="hidden" name=quantity2 value="<%=quantity2%>"> <input
			type="hidden" name=itemId3 value="<%=dto3.getItem_id()%>"> <input
			type="hidden" name=total_price3 value="<%=dto3.getItem_price()%>">
		<input type="hidden" name=quantity3 value="<%=quantity3%>"> <input
			type="hidden" name=user_id value="<%=member.getUser_id()%>">
		<br>
		<form action="productConfirm.jsp">
			<div class="row col-sm-3 offset-9 text-right">
				<input class="w-30 btn btn-lg btn-primary btn-right" type="submit"
					value="購入">
			</div>
		</form>
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