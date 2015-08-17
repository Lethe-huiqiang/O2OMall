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
    
    <title>My JSP 'repairmanagement.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/repair-do.css" >
<link rel="stylesheet" href="frontStage/repairclaim/style/jquery-ui.css" type="text/css" />

<link href="frontStage/repairclaim/style/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>

<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repair-do.js"></script>
</head>
<body>

<div id="content">
    

	<div id="right">
		<div id="tabel">维修记录表
	  	
			  	<table border="1" cellpadding="2" cellspacing="1">
			  			<tr>

					    <td>维修单ID</td>
					    <td>派单时间</td>
					    <td>更新时间</td>

					    </tr>
					<s:iterator value="#request.repairdo" id="repairdo">
					   
					    <tr>
					    
					    <td nowrap><input type="text" readonly="readonly" name="id" id="id" value=<s:property value="#repairdo.id"/>></td>
					    <td nowrap><s:property value="#repairdo.dispatchTime"/></td>
					    <td nowrap><s:property value="#repairdo.updateTime"/></td>
					    <td><input type="button" value="确定接单" onclick="repairdo()" class="button1"></td>
						<td><input type="button" value="拒绝接单" onclick="repairnotdo()" class="button2"></td>
					   </tr>
					   
					</s:iterator> 
			  	</table>
		   
		</div>
	</div>
</div>


</body>
</html>