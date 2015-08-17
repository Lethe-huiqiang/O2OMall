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
	
	
	<link rel="stylesheet" type="text/css" href="frontStage/repairclaim/style/repairmanagement.css">
	
	
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery-1.8.2.min.js"></script>
  
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/jquery.form.js"></script>
	  
	<script type="text/javascript" src="<%=basePath %>frontStage/repairclaim/js/repairmanagement.js"></script>
	
	
  </head>
  
  <body>
  

		
	<div id="content">
	
	<div id="right" style="width:auto;">
      <div id="right_table">
	  
	  <!-- <form id="gettablelist" method="post" action="repairmanagement_gettable.action">
	  
	  <div style="float:left;">
	  	<input type = "submit" value="显示">
	  </div> -->
	  		<div  style="float:left">
			  	<table border="1">
			  		<tbody id="base">
			  			<tr>
					    <!-- <td>id</td> -->
					    <td>机主</td>
					    <td>派单</td>

					    </tr>
					<s:iterator value="#request.list" id="list" status="st">
					   
					    <tr>
					    <%-- <td><s:property value="#list.id"/></td> --%>
					    <td><s:property value="#list.macOwner"/></td>
					    <td><input type="button" id=<s:property value="#list.id"/> value="详情" onclick="dispatch(this.id,this.name)" name=<s:property value="#st.index"/>></td>
					    <!-- <s:property value="#list.id"/> -->
					    </tr>
					    
					    <tr style="display:none">
					    <td><s:property value="#list.longTel"/></td>
					    <td><s:property value="#list.shortTel"/></td>
					    <td><s:property value="#list.address"/></td>
					    <td><s:property value="#list.machine"/></td>
					    <td><s:property value="#list.system"/></td>
					    <td><s:property value="#list.storage"/></td>
					    <td><s:property value="#list.description"/></td>
					    <td><s:date name="#list.creTime" format="yyyy-MM-dd HH:mm:ss"/></td>
					    </tr>
					    
					</s:iterator> 
			  	</table>
	  		</div>
	  
	  
	  </div>
	 
	  
	  <div>
	  	  <table id="gettable" border="1">
	  	  	<tbody id="more">
						<tr>
					    <td>长号</td>
					    <td>短号</td>
					    <td>宿舍地址</td>
					    <td>电脑型号</td>
					    <td>系统</td>
					    <td>内存</td>
					    <td>报修时间</td>
					    </tr>
					  
					    <tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td></td>
					   </tr>
					</tbody>
			  	</table>
			</div>  	
			<br>
			
		<div>
			<textarea></textarea>
		</div>	
		<br>
		
		<div style="float:right;">
	  	派单机主：<input type="text" name="repairmanagement.id" id="id"/>
		<br>
		修机组员：<select name="repairmanagement.repairMemId"  id="repairMemId">
		    	 
		    	<s:iterator value="#request.mems" var="mems">		    	
		   		<option value="<s:property value="#mems[0]"/>"><s:property value="#mems[1]" /></option>	   		
		   		</s:iterator>		   			    	
		   		</select>  
		<br>
		
		 <input type="button" name="submit" id="submit" onclick="repairman();" value="派单">			  	
		</div>
	  
	  	<div style="clear:both;float:left">
		
			<s:a href="repairmanagement_getpreviouspage.action?pageModel.currentPage=%{#request.pageModel.currentPage-1}">上一页</s:a>
		
	  		<s:property value="#request.pageModel.currentPage"/>/<s:property value="#request.pageModel.totalPage"/>
		
			<s:a href="repairmanagement_getnextpage.action?pageModel.currentPage=%{#request.pageModel.currentPage+1}">下一页</s:a>
		
		</div>
		
	</div>
	
	</div>
	
	
  </body>
  <script type="text/javascript">
  	function repairman(){
  		$.ajax({
  			url:"repairmanagement_repairmanagement.action",
  			type:"post",
  			cache:false,
  			data:{'repairmanagement.id':$('#id').val(),'repairmanagement.repairMemId':$('#repairMemId').val()},
  			success:function(data){
  				if(data=="yes"){
  					alert('okookokok');
  				}
  			}
  		});
  	}
  </script>
  
</html>
