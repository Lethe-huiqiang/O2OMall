<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'repair.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
  <link rel="stylesheet" type="text/css" href="<%=basePath %>frontStage/repairclaim/style/repair.css">
  
  <link rel="stylesheet" type="text/css" href="<%=basePath %>frontStage/users/css/bootstrap.min.css">

  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repairclaim.js"></script>

  </head>
  
  <body>
  
  <div id="header">
	<jsp:include flush="true" page="header.jsp"/><!--引入header.jsp-->
</div>

<div id="navg">

<s:a href="repairclaim_showclaim.action" id="chakan">
<img src="frontStage/repairclaim/images/repairfind.jpg" width=40px height=40px id="find">
</s:a>

</div>

<div id="right">

</div><br>
  	
  	
    <form id="repairForm" method="post" style="width:40%;">
 
                        
        <div class="controls" style="margin-top:20px;">
        
        	机主姓名：
            <input type="text" name="repairClaim.macOwner" id="macOwner" label="机主姓名" placeholder="16位以下字母或8位以下中文"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/><br>
            <span class="" style="color:red;margin-right:5px;" id="validMacOwner"></span><b></b><em></em>
            <input type="hidden" id="macOwnerHidden" value="false">
            
	 	</div>
            
       <div class="controls">   
       
       		机主宿舍：
            <input type="text" name="repairClaim.address" label="机主宿舍" id="address"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/><br>
    		<span class="" style="color:red;margin-right:5px;" id="validAddress"></span><b></b><em></em>
  			<input type="hidden" id="addressHidden" value="false">
  			
	</div>
	
	
		<div class="controls">
      	
      		机主长号：
      		<input type="text" name="repairClaim.longTel" id="longTel" label="长号"  placeholder="11位的数字"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/><br>
      		<span class="" style="color:red;margin-right:5px;" id="validLongTel"></span><b></b><em></em>
      		<input type="hidden" id="longTelHidden" value="false">
      		
	</div>
	          
            
       <div class="controls">
       		机主短号：  
            <input type="text"  name="repairClaim.shortTel" id="shortTel" label="短号"  placeholder="4-6位的数字"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/>
			<input type="hidden" id="shortTelHidden" value="false">
	</div>
		
	
       <div class="controls">   
       		电脑型号：
            <input type="text" name="repairClaim.machine" label="电脑型号" id="machine"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/>

	</div><br>           
	
	
       <div class="controls">   
       		电脑系统：
            <input type="text" name="repairClaim.system" label="电脑系统" id="system"  onmouseover="this.style.borderColor='black';this.style.backgroundColor='#e5f1f4'" onmouseout="this.style.borderColor='black';this.style.backgroundColor='#ffffff'"/>
	</div><br>         
	
	
       <div class="controls">   
       		内存大小：
            <select name="repairClaim.storage">
			  <option value ="1">1GB</option>
			  <option value ="2">2GB</option>
			  <option value="3">3GB</option>
			  <option value="4">4GB</option>
			  <option value ="6">6GB</option>
			  <option value="8">8GB</option>
			  <option value="12">12GB</option>
			  <option value="16">16GB</option>
			</select>
            <input type="hidden" id="storageHidden" value="false"> 
            <div class=""><span class="" style="color:red;margin-right:5px;" ></span><b></b><em></em></div>
	</div><br>          
	
	
  			
       <div class="controls">   
    	   	<p>故障描述</p>  	
            <textarea name="repairClaim.description" label="故障描述" id="description" placeholder="请输入少于200字的描述" style="resize:none;width:500px;height:100px;"/></textarea>
            <input type="hidden" id="descriptionHidden" value="false"> 
            <div class=""><span class="" style="color:red;margin-right:5px;" id="validDescription"></span><b></b><em></em></div>
	</div><br>       
	
	    
              	
              	
		<div class="controls">
			<input id="submitA" type="button" value="提交" onclick="repairclaim();">
		</div>
			
		
   	</form>
   	
   	
   	
   	
   	<div id="des" style="width:40%;float:right;">
   	
   	<h2 style="color:#37A2D8">欢迎进入广东工业大学计算机协会报修系统</h2><br>
   	<h3 style="color:#37A2D8">详细说明：</h3><p>如果您的电脑出现了一些您无法解决的问题，可以在这里进行报修登记，我们将有人专门为您上门免费诊断和维修</p><br>
   	<h3 style="color:#37A2D8">报修流程：</h3><p>报修→等待派发单→维修员接单→诊断与维修→结束维修→评论反馈</p><br>
   	<h3 style="color:#37A2D8">用户反馈：</h3><p>当维修结束后，您可以在查看报修单状态页面对我们的维修进行评价</p><br>
   	<h3 style="color:#37A2D8">疑问解答：</h3><p>如果您有任何关于报修或者关于电脑故障的疑问，可以在查看报修状态页进行留言</p><br>
   	
   	</div>
   	
   	<div id="footer" style="clear:both">
	<jsp:include flush="true" page="footer.jsp"/><!--引入footer.jsp-->
</div>
  </body>
</html>
