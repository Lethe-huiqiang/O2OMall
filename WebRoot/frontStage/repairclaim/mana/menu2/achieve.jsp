<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'achieve.jsp' starting page</title>
    
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
    		<th>组员名</th>
    		<th>接单次数</th>
    		<th>结单次数</th>
    		<th>拒单次数</th>
    		<th>长号</th>
    		<th>短号</th>
    		<th>最后更新时间</th>
    	</tr>
    	<s:iterator value="#request.achievement" id="achievement">
    		<tr>
    			<td><s:property value="#achievement[6]"/></td>
    			<td><s:property value="#achievement[1]"/></td>
    			<td><s:property value="#achievement[2]"/></td>
    			<td><s:property value="#achievement[3]"/></td>
    			<td><s:property value="#achievement[7]"/></td>
    			<td><s:property value="#achievement[8]"/></td>
    			<td><s:property value="#achievement[4]"/></td>
    		</tr>
    	</s:iterator>
    </table>
  </body>
</html>
