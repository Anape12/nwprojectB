<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String result = (String)session.getAttribute("resultApp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー（<%= result %>）</title>
</head>
<body>
<body style="background:#63515f;">
	<div style="width:200px margin-top:30px;"></div>
	<div style="text-align:center; width:400px;">
		<p>選択アプリ【<%= result %>】</p>
	<p><button class="search-btn2" onclick="history.back()">ログアウト</button></p>
		 <jsp:include page="../footer.jsp" flush="true"/>
	</div>
</body>
</html>