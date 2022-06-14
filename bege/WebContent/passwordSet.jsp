<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>パスワード再設定画面</h1>
<form action="password" method="post">
		<table>

			<tr>
				<td>メールアドレス</td>
				<td><input type="password" name="mail＿address"></td>

			</tr>
		</table>


			<p>メールアドレスを入力後、質問が来ます</p>
			<table>
			<tr>
				<td>秘密の質問</td>
				<td><input type="text" name="answer"></td>

			</table>

	</form>
	
		<a href="login.jsp">ログイン画面に戻る</a> |
</body>
</html>