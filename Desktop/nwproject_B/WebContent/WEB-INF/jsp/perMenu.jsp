<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.nw.model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインメニュー（<%= loginUser.getName() %>）</title>
</head>
<body>
<body style="background:#63515f;">
	<div style="width:200px margin-top:30px;"></div>
	<div style="text-align:center; background:#d3adf0; width:400px; margin-left:450px">
		<div style="text-align:center; width:400px;">
		<p>ようこそ<%= loginUser.getName() %>さん</p>
		</div>
		<div style="margin-top:50px; padding-top:10px;"></div>
		<form action="/nwproject_B/OpenCalender" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">スケジュール表改</button></p>
		</form>
		<form action="/nwproject_B/OpenShedule" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">スケジュール表</button></p>
		</form>		
		<form action="/nwproject_B/UserInsert" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">ユーザー情報新規登録</button></p>
		</form>
		<form action="/nwproject_B/DairyWrite" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">日記投稿</button></p>
		</form>
		<form action="/nwproject_B/DairyWrite" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">日記閲覧</button></p>
		</form>
		<form action="/nwproject_B/UserView" target="_blank"  method="get">
			<p><button class="search-btn3" type="submit">ユーザー一覧参照</button></p>
		</form>		
		<form action="/nwproject_B/SelectApp?AppName=NC30001" target="_blank"  method="post">
			<p><button class="search-btn3" type="submit">NC3アプリ</button></p>
		</form>		
		<form action="/nwproject_B/SelectApp?AppName=NC40001" target="_blank"  method="post">
			<p><button class="search-btn3" type="submit">NC4アプリ</button></p>
		</form>		
	<p><button class="search-btn2" onclick="history.back()">ログアウト</button></p>
		 <jsp:include page="footer.jsp" flush="true"/>
	</div>
</body>
</html>