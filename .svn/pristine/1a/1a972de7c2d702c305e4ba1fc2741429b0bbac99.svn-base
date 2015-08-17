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
    
    <title>My JSP 'comment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/comment.css">
	
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>

  </head>
  
  <body>
  
  <div id="header">
	<jsp:include flush="true" page="header.jsp"/><!--引入header.jsp-->
</div>


<div id="navg">
<a href="<%=basePath%>frontStage/repairclaim/jsp/repair.jsp">报修</a>
<s:a href="repairclaim_showclaim.action">查看报修状态</s:a>
</div>

<div id="right">

</div><br>

  
    <form id="comment" method="post" action="comment_comment.action">
    	
    	<div>
    		评价等级：
    			<select name="repairmanagement.commentValue"  id="commentValue">		    	 	    	
		   		<option value="0">很赞</option>	   		
		   		<option value="1">还行</option>	
		   		<option value="2">不是很满意</option>	  			    	
		   	</select>  
    	</div><br>
    	
    	<div>
    		评价：<textarea name="repairmanagement.comment" id="comment"></textarea>
    			
    	</div><br>
    	
    	<div>
    		<input type="submit" id="submit" value="提交">
    	</div>
	
	</form>
	
	<div id="footer">
	<jsp:include flush="true" page="footer.jsp"/><!--引入footer.jsp-->
</div>
	
  </body>
</html>
