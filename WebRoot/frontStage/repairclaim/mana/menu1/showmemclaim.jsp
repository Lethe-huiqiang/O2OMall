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
    
    <title>My JSP 'showmemclaim.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/showmemclaim.css">
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
  	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/showmemclaim.js"></script>
	

  </head>
  
  <body>
  
  
  
  <table border="1">
  	<tr>
  		<th>维修单ID</th>
  		<th>机主姓名</th>
  		<th>长号</th>
  		<th>短号</th>
  		<th>地址</th>
  		<th>电脑型号</th>
  		<th>系统</th>
  		<th>内存</th>
  		<th>故障描述</th>
  	</tr>
  	<s:iterator value="#request.showmemclaim" id="showmemclaim" status="st">
  	<tr>
  		<td><s:property value="#showmemclaim.id"/></td>
  		<td><s:property value="#showmemclaim.macOwner"/></td>
  		<td><s:property value="#showmemclaim.longTel"/></td>
  		<td><s:property value="#showmemclaim.shortTel"/></td>
  		<td><s:property value="#showmemclaim.address"/></td>
  		<td><s:property value="#showmemclaim.machine"/></td>
  		<td><s:property value="#showmemclaim.system"/></td>
  		<td><s:property value="#showmemclaim.storage"/></td>
  		<td><s:property value="#showmemclaim.description"/></td>
  	</tr>
  	</s:iterator>
  </table>
  
  </body>
</html>
