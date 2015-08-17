<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>usersList</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
table{cellspacing:10;padding:10px}
/*  hr{border: 1px dashed ; height: 1px;}  */
td{ text-align: center;padding:10px; border:0;}/* border-bottom:1px solid black */
th{border:0;border-bottom:1px solid black;padding:10px;border-top:1px solid black}

</style>
<script type="text/javascript" src="<%=getServletContext().getContextPath() %>/frontStage/js/jquery-1.8.2.min.js"></script>

<script type="text/javascript" language="javascript">
$(function(){

	$("[id='limiting']").bind("click",function(event){
		var usersId = $(this).parent().parent().find("[id='usersId']").val();
		alert(usersId);
		$.ajax({
			url:'usersManage_limitingUsers.action',
			type:'post',
			data:{"usersId":usersId},
			cache:false,
			success:function(data){
				if(data=="success"){
					alert("该会员已被拉黑！");
					window.location.reload();
				}else{
					alert("操作失败!");
				}
			}
		});
	});
});
</script>
  </head>
  	
  <body>
  <table border=1px>
  	<tr>
  		<th>ID</th>
  		<th>用户类型</th>
  		<th>审核标示</th>
  		<th>昵称</th>
  		<th>邮箱账号</th>
  		<th>用户状态</th>
  		<th>注册时间</th>
  		<th>操作</th>
  	</tr>
  	<hr>
    	<s:iterator value="#request.usersList">
	    	<tr>
	    	<div>
	  			<td><s:property value="id" /></td>
	  			<td><s:if test="UType==0">普通会员</s:if><s:elseif test="UType==1">计协成员</s:elseif><s:elseif test="UType==2">管理员</s:elseif></td>
	  			<td><s:if test="auth==0">未审核</s:if><s:elseif test="auth==1">审核通过</s:elseif><s:elseif test="auth==2">审核不通过</s:elseif></td><%-- <s:property value="auth" /> --%>
	  			<td><s:property value="nickname" /></td>
	  			<td><s:property value="email" /></td>
	  			<td><s:if test="status==0">白名单</s:if><s:elseif test="status==1">黑名单</s:elseif></td><%-- <s:property value="status" /> --%>
	  			<td><s:date format="yyyy-MM-dd hh:mm" name="creTime" ></s:date></td>
	  			<td><input type="button" value="拉进黑名单" id="limiting" ><td>
	  			<input type="hidden" id="usersId"  value="<s:property value='id' />" >
	  			</div>
	  		</tr>
  		</s:iterator>
  	
  </table>
  </body>
  </html>

  		
  		
  	
  	
  	
  	
  
  
  
  
  
	</body>
</html>
