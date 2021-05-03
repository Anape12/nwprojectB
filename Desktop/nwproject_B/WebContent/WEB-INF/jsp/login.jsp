<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>SampleMenu</title>
</head>
<body>
	<h1>この画面はサンプルです</h1>
	<form action="/nwproject_B/Login" method="post">
	ユーザーID：<input type="text" name="userId"><br>
	パスワード：<input type="password" name="password"><br>
	<input type="submit" value="ログイン">
	</form>
</body>
</html>