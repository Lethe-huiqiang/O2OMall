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
    
    <title>My JSP 'showusersclaim.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/showusersclaim.css">
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
  	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/showusersclaim.js"></script>
	

  </head>
  
  <body>
  
  <div id="header">
	<jsp:include flush="true" page="header.jsp"/><!--引入header.jsp-->
	</div>
	
	
<div id="navg">

<a href="<%=basePath%>frontStage/repairclaim/jsp/repair.jsp" id="baoxiu">
<img src="frontStage/repairclaim/images/repairdengji.jpg" width=40px height=40px>
</a>

</div>

<div id="right">

</div><br>
  
  	<form method="post"  id="showclaim" action="repairclaim_showclaim.action">
    	<!-- <input type="submit" value="查看我的维修登记">  -->
    	
	   <table border="1">
	   				<tr>
		   				<th>序号</th>
		   				<th>报修时间</th>
		   				<th>机主姓名</th>
		   				<th>报修电脑型号</th>
		   				<th>报修状态</th>
		   				<th>是否评价</th>
		   			</tr>
		   <s:iterator value="#request.show" id="show" status="st">	  
					<tr>
						<td><s:property value="#st.count"/></td>
						<td><s:date name="#show.creTime" format="dd/MM/yyyy"/></td>
						<td><s:property value="#show.macOwner"/></td>
						<td><s:property value="#show.machine"/></td>
						<td id="state">
							<s:if test="#show.state==0">已报修</s:if>
							<s:elseif test="#show.state==1">已派单</s:elseif>
         					<s:elseif test="#show.state==2">已接单</s:elseif>
         					<s:elseif test="#show.state==3">已结单</s:elseif>
						</td>
						<td>
						<s:if test="#show.state==3">
						<s:if test="#show.isComment==false">
						<input type="button" value="评价" name=<s:property value="#st.index"/> onclick="comment(this.name);">
						</s:if>
						<s:elseif test="#show.isComment!=false">已评价</s:elseif>
						</s:if>
						<s:elseif test="#show.state!=3">请等待处理</s:elseif>
						</td>
					</tr>
			</s:iterator>
		</table>				
  	</form>
  	
  	 
  	<form id="question" action="repairclaim_leavewords.action" method="post">
  		<h3>如果有疑问可以向我们留言</h3>
  		<textarea name="leaveWords.words" id="words"></textarea><br>
  		<input type="submit" value="提交">
  	</form>
  	
  	
<!--   	<form method="post" action="repairclaim_deleteclaim.action">
  	
  		<input type="submit" id="delete" value="取消登记">
  	
  	</form> -->
  	
  	
  	<div id="footer">
	<jsp:include flush="true" page="footer.jsp"/><!--引入footer.jsp-->
</div>
  	
  </body>
</html>
