<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'memcomment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<table border="1">
  		<tr>
  			<td>维修单</td>
  			<td>机主</td>
  			<td>评论</td>
  			<td>评价等级</td>
  		</tr>
  		<s:iterator value="#request.memcomment" id="memcomment">
  		<tr>
  			<td><s:property value="#memcomment[0]"/></td>
  			<td><s:property value="#memcomment[11]"/></td>
  			<td><s:property value="#memcomment[6]"/></td>
  			<td><s:property value="#memcomment[7]"/></td>
  		</tr>
  		</s:iterator>
  	</table>
  	
  </body>
</html>
