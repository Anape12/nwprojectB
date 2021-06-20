<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.nw.model.User,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<User> userList = (List<User>) request.getAttribute("userList");
String errorMsg = (String) request.getAttribute("errorMsg");
String userInfo = loginUser.getName();
userInfo = userInfo + ":" +loginUser.getPass();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>ユーザー一覧(管理者モード)</title>
<%= loginUser.getName() %>さん、ログイン中
</head>
<body>
	<div style="width:200px"></div>
	<h1>ユーザーID：パスワード一覧</h1>
	<div style="width:200px"></div>
	<% if(errorMsg != null) { %>
	<p><%= errorMsg %></p>
	<% } %>
	<form method="post" action="/nwproject_B/UserView">
	<table border="1">
	  <tr>
	      <th>選択</th>
	      <th>No</th>
	      <th>ユーザーID</th>
	      <th>パスワード</th>
	      <th>権限レベル（1:管理者/2:通常/）</th>
	  </tr>
	<c:forEach var="userList" items="${userList}">
	<tr>
	<th><input type="radio" name="radiobutton" value="${userList.getName()}"></th>
	<th>${userList.getNum()}</th>
    <th>${userList.getName()}</th>
    <th>${userList.getPass()}</th>
    <th>${userList.getPermission()}</th>
 	</tr>
	</c:forEach>
	</table>
	<input type="submit" name="change" value="変更画面へ">
	</form>
</body>
<button class="search-btn2" name="userInfo" onclick="window.close();">ウィンドウを閉じる</button>
</html>