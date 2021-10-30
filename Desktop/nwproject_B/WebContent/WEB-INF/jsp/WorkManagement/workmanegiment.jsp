<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="jp.nw.model.MyCalendar, java.util.Date, java.util.Calendar, java.util.List, java.util.Map, java.util.HashMap,java.util.ArrayList"%>
<%
	String userid =(String)request.getAttribute("USER_ID");
    int month = (int)request.getAttribute("MONTH");
    String userId = (String)request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" Content="text/html;charset=Shift_JIS">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta http-equiv="Content-Script-Type" content="text/javascript">

<title><%=month %>月勤怠表</title>
<style>
table.sche{border:1px solid #a9a9a9;padding:0px;margin:0px;border-collapse:collapse;}
td{vertical-align:top;margin:0px;padding:2px;font-size:0.75em;height:20px;}
td.top{border-bottom:1px solid #a9a9a9;text-align:center;}
td.time{background-color:#f0f8ff;text-align:right;border-right:1px double #a9a9a9;padding-right:5px;}
td.timeb{background-color:#f0f8ff;border-bottom:1px solid #a9a9a9;border-right:1px double #a9a9a9;}
td.contents{background-color:#ffffff;border-bottom:1px dotted #a9a9a9;}
td.contentsb{background-color:#ffffff;border-bottom:1px solid #a9a9a9;}
td.ex{background-color:#ffebcd;border:1px solid #8b0000;}
img{border:0px;}
p{font-size:0.75em;}
#contents{margin:0;padding:0;width:710px;}
#left{margin:0;padding:0;float:left;width:400px;}
#right{margin:0;padding:0;float:right;width:300px;background-color:#ffffff;}
#contents:after{content:".";display:block;height:0;clear:both;visibility:hidden;}
</style>
</head>
<body>
<div style="text-align:center;">
		<table border="1" align="left">
		  <tr>
		      <th>日</th>
		      <th>曜日</th>
		      <th>始業時間</th>
		      <th>就業時間</th>
		      <th>備考</th>		      
	  	</tr>
	  	<tr>
	  		<th width="80">例</th>
	  		<th width="80">月</th>
	  		<th><input class="title-txt" type="text" name="starthour" placeholder="09" size=5> :
	  			  	<input class="title-txt" type="text" name="startminuts" placeholder="00" size=5>
	  		</th>
	  		<th><input class="title-txt" type="text" name="endhour" placeholder="18" size=5> :
	  			  	<input class="title-txt" type="text" name="endminuts" placeholder="00" size=5>
	  		</th>
	  		<th><input class="title-txt" type="text" name="info" size=120>
	  	</tr>
	  </table>
</div>
</body>
</html>
