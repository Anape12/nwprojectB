<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style11.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Login.js"></script>
<title>SampleMenu</title>
</head>
<body>
	<h1  style="text-align:center;">開発機テスト画面</h1>
	<form action="/nwproject_B/Login?Params=a0005" method="post" style="text-align:center;">
	ユーザーID：<input type="text" name="userId"><br>
	パスワード：<input type="password" name="password" id="pass" maxlength='5' onblur="textCheck(this)"><br>
	<input type="submit" value="ログイン" onclick="buttonClick();">
	</form>
</body>
<div  style="text-align:center;">
 <jsp:include page="footer.jsp" flush="true"/>
 </div>
</html>