<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.nw.model.User,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
List<User> userList = (List<User>) request.getAttribute("userList");
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<title>ユーザ－情報編集(管理者モード)</title>
<%= loginUser.getName() %>さん、ログイン中
</head>
<body>
	<div style="width:200px"></div>
	<h1>ユーザー情報変更</h1>
	<div style="width:200px"></div>
	<% if(errorMsg != null) { %>
	<p><%= errorMsg %></p>
	<% } %>
	<form method="post" action="/nwproject_B/EditUserView">
	<table border="1">
	  <tr>
	      <th>変更前ユーザーID</th>
	      <th>変更後ユーザーID</th>
	      <th>変更後パスワード</th>
	      <th>変更後権限レベル（1:管理者/2:通常/）</th>	      
	  </tr>
	<c:forEach var="userList" items="${userList}">
	<tr>
	    <th><input type="text" name="nowID" value="${userList.getName()}" readonly></th>
	    <th><input type="text" name="editID" value="${userList.getName()}"></th>
	    <th><input type="text" name="editPass" value="${userList.getPass()}"></th>
	    <th><input type="text" name="editPermission" value="${userList.getPermission()}"></th>
 	</tr>
 	</c:forEach>
	</table>
		<input type="submit" name="change" value="変更確定">
	</form>
		<input type="submit" name="change" value="削除確定">
</body>
</html>