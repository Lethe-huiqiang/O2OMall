<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'commodityManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js" ></script>	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/themes/icon.css" />
	 <link id="easyuiTheme" rel="stylesheet" 
   href="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
		
<script type="text/javascript">
	function usersSearch(){
		$('#usersDatagrid').datagrid('load',{
			searchname:$('#searchname').val()
		});
	}

	function usersDelect(){
            var selectedRows=$('#usersDatagrid').datagrid('getSelections');
            var delnums=selectedRows.length;
            if(delnums==0){
                  $.messager.alert("提示","请选择要拉黑的用户！");
                  return;
                }
            var ids=[];
            for(var i=0;i<selectedRows.length;i++){
            	ids.push(selectedRows[i].id);
                }
            var ids=ids.join(",");

            $.messager.confirm("提示","您确定要拉黑这<font color=red size=16>"+selectedRows.length+"</font>个用户吗？",function(r){
                    if(r){
                           $.post("usersManage_limitingUsers.action",{ids:ids,delnums:delnums},
                                   function(result){
                                     if(result.success){
                                         $.messager.alert("提示","成功拉黑<font color=red size=16>"+result.deltotal+"</font>个用户");
                                           $("#usersDatagrid").datagrid("reload");
                                           }else{
                                        	   $.messager.alert("提示",result.errorMsg);
                                               }
                               },"json")
                        }

                })
		}

	function closeDialog(){
		$("#updateUsers").dialog("close");
		resetCommodityInfo();
	}
	

	function parseToDate(value,row,index){
		var year=row.creTime.year+1900;
		var month=row.creTime.month+1;
		var day=row.creTime.date;
		var hours=row.creTime.hours;
		var minutes=row.creTime.minutes;
		var time=year+'-'+month+'-'+day+' '+hours+':'+minutes;
		console.log(time);
	    return time; 
}
 	function setState(value,row,index){
 	 	var status=row.status;
		if (status==1){
			return "<p style='color:red;'>黑名单用户</p>";
		} else {
			return "正常用户";
		}
 	}
 	
</script>
  </head>
  
  <body>
     <table id="usersDatagrid" title="用户管理 " class="easyui-datagrid" fitColumns="true" pagination="true" 
            rownumbers="true" fit="true" nowrap="true" toolbar="#toolbar"
            url="usersManage_manageUsersList.action">
        <thead>
          <tr>
              <th field="checkbox" checkbox="true" ></th>
              <th field="id" width="20" >用户ID</th>
              <th field="nickname" width="20">用户名</th>
              <th field="email" width="20">用户邮箱</th> 
              <th field="auth" width="20">验证状态</th>    
              <th field="status" formatter="setState" width="20">用户状态</th>
              <th field="creTime" width="20" formatter="parseToDate">注册时间</th>    
              <th field="picId"  hidden="true"></th>
          </tr>
        </thead>
     
     </table>
     
     <div id="toolbar">
         <div>
            <a href="javascript:void(0);" onclick="usersDelect()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">拉黑</a>
         </div>
         <div>搜索关键字： <input type="text" name="searchname" id="searchname"/>
            <a href="javascript:void(0);" onclick="usersSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
         </div>
     </div>
   <div id="usersDefaultPc" class="easyui-dialog" style="width:800px;height:400px;padding: 10px 20px" closed="true" buttons="#dialog-buttons">
     <form  id="usersDefaultPcForm" method="post" enctype="multipart/form-data">   
          <div>商品图片：<input type="file" name="usersDefaultPicture" id="usersDefaultPicture">   </div>
                
   </form>
    </div>
    <div id="dialog-buttons">
		<a href="javascript:void(0);" onclick="saveCommodity()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:void(0);" onclick="closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
  </body>
</html>
