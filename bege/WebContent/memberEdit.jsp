<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>会員編集画面</h1>
<form action="MemberEditAction" method="post">
		<table>
		
			<tr>
				<td>名前</td>
				<td><input type="password" name="user_name"></td>

			</tr>
			<tr>
				<td>フリガナ</td>
				<td><input type="text" name="user_kana"></td>
			</tr>
			<tr>
				<td>電話番号</td>
				<td><input type="text" name="tel_number"></td>
			</tr>
			<tr>
				<td>メールアドレス</td>
				<td><input type="text" name="user_mail"></td>
			</tr>
			<tr>
				<td>パスワード/td>
				<td><input type="text" name="user_password"></td>
			</tr>
			<tr>
				<td>秘密の質問</td>
				<td><input type="text" name="qustion"></td>
			</tr>
			<tr>
				<td>住所</td>
				<td><input type="text" name="adress"></td>
			</tr>
			<tr>
				<td>都道府県</td>
				<td><input type="text" name="prefecture"></td>
			</tr>
			<tr>
				<td>市区町村</td>
				<td><input type="text" name="city"></td>
			</tr>
			<tr>
				<td>郵便番号</td>
				<td><input type="text" name="housenumber"></td>
			</tr>
			<tr>
				<td>カード番号</td>
				<td><input type="text" name="card_limit"></td>
			</tr>
			<tr>
				<td>カード確認コード</td>
				<td><input type="text" name="user_code"></td>
			</tr>

			<tr>
				<td>名義</td>
				<td><input type="text" name="user_meigi"></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="編集確認"></td>
			</tr>
		</table>
	</form>
	
		<a href="productSelect.jsp">商品選択へ戻る</a> |

</body>
</html>