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
    
    <title>repsummary</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/repsummary.css">
	

  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repsummary.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repair-sum.js"></script>
  
  <script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repair-do.js"></script>

  </head>
  
  <body>
  

	<div id="content">
    
	
  <div id="right">
  <div id="right_form">
    <form  id="repsummaryForm" method="post" action="repsummary_repsummary.action" >
    
    <div>
	  	<%-- <s:action name="repairmanagement_getID"/>  --%>
		维修单：<br><select name="repsummary.id"  id="id">
		    	 
		    	<s:iterator value="#request.repairmanagement" status="st">		    	
		   		<option value="<s:property value="#request.repairmanagement[#st.index]"/>"><s:property value="#request.repairmanagement[#st.index]" /></option>	   		
		   		</s:iterator>		   			    	
		   		</select>  
	</div><br>
	
	<%-- <div>
		<s:hidden name="repsummary.repairmemid" value="???">
		</s:hidden>
	</div> --%>
 
 	<label class="control-label" > 电脑型号：</label><span style="color:red;margin-right:5px;">*</span>
                        
        <div class="controls">
            <input type="text" name="repsummary.machine" id="machine" label="电脑型号"/><br>
            <input type="hidden" id="machineHidden" value="false">
            <span class="" style="color:red;margin-right:5px;" id="validMachine"></span><b></b><em></em>
	 	</div><br>
	
            
     <label class="control-label" >故障描述：</label><span style="color:red;margin-right:5px;">*</span>          
                         
      	<div class="controls">
      		<textarea name="repsummary.description"  id="solution" placeholder="200字以下"></textarea><br>
      		<input type="hidden" id="descriptionTelHidden" value="false">
      		<span class="" style="color:red;margin-right:5px;" id="validDescription"></span><b></b><em></em>
	 	</div><br>
	
	          
            
     <div>
	  
		故障类型标签：<br><select name="repsummary.label"  id="label">
		    	 
		    	<s:iterator value="#request.fault_label">		    	
		   		<option value="<s:property value="id"/>"><s:property value="label" /></option>	   		
		   		</s:iterator>		   			    	
		   		</select>  
	</div><br>      
       
             
     <label class="control-label" > 解决方案：</label><span style="color:red;margin-right:5px;">*</span> 
                      
       <div class="controls">   
            <textarea name="repsummary.solution"  id="solution" placeholder="200字以下"></textarea><br>
  			<input type="hidden" id="solutionHidden" value="false">
            <span class="" style="color:red;margin-right:5px;" id="validSolution"></span><b></b><em></em>
	 	</div><br>
	           
	
	
	<label class="control-label" >是否分享：</label><span style="color:red;margin-right:5px;">*</span> 

       <div class="controls">   
            <label><input type="radio" value=1 name="repsummary.isShare" id="isShare" checked="checked"/>是</label>
            <label><input type="radio" value=0 name="repsummary.isShare" id="isShare"/>否</label><br>
			<input type="hidden" id="isShareHidden" value="false">
           <span class="" style="color:red;margin-right:5px;"  id="validIsShare"></span><b></b><em></em>
	 	</div><br>
	         
             	
              	
   	
		<div class="controls">
<!-- 		<label class="checkbox"> <input type="checkbox" id="agreeNode" name="agreeNode" />已阅读和同意计协网站的
				<a href="#">服务条款及用户须知</a>
				并同意条款及须知 </label><br> -->
			<input  type="submit" value="提交" id="tijiao">
		</div>
	
   	</form>
   	
   	
   	
   	
   	
   	</div>
   	
   	</div>
   	
   	</div>
   	
   	
  </body>
</html>