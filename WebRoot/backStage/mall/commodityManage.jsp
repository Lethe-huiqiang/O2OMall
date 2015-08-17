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
	<!-- KindEditor 编辑功能 -->
	<link rel="stylesheet" href="<%=basePath %>/HTMLEditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=basePath %>/HTMLEditor/js/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=basePath %>/HTMLEditor/js/lang/zh_CN.js" type="text/javascript"></script>
	<script charset="utf-8" src="<%=basePath %>/HTMLEditor/js/kindeditor.js" type="text/javascript"></script>
	<script charset="utf-8" src="<%=basePath %>/HTMLEditor/js/plugins/code/prettify.js" type="text/javascript"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="commodity.description"]', {
				cssPath : 'js/plugins/code/prettify.css',
				uploadJson : 'sharePost_pictureUpload.action',//这个是上传处理的action
				imageFileDir : 'image/im',//这个是上传图片的储存位置，相对于fileSource文件夹
				mediaFileDir : 'media/im',//这个是上传视频的存储位置，相对于fileSource文件夹
				dir : 'image',
				fileManagerJson : 'file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['updateCommodityForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['updateCommodityForm'].submit();
					});
				},afterBlur: function(){this.sync();}
			});
			prettyPrint();
		});
	</script>
<script type="text/javascript">
	function commoditySearch(){
		$('#commodityDatagrid').datagrid('load',{
			searchname:$('#searchname').val()
		});
	}

	function commodityDelect(){
            var selectedRows=$('#commodityDatagrid').datagrid('getSelections');
            var delnums=selectedRows.length;
            if(delnums==0){
                  $.messager.alert("提示","请选择要删除的数据！");
                  return;
                }
            var ids=[];
            for(var i=0;i<selectedRows.length;i++){
            	ids.push(selectedRows[i].id);
                }
            var ids=ids.join(",");

            $.messager.confirm("提示","您确定要删除这<font color=red size=16>"+selectedRows.length+"</font>个商品吗？",function(r){
                    if(r){
                           $.post("commodityManage_delectCommodity.action",{ids:ids,delnums:delnums},
                                   function(result){
                                     if(result.success){
                                         $.messager.alert("提示","成功删除<font color=red size=16>"+result.deltotal+"</font>个商品");
                                           $("#commodityDatagrid").datagrid("reload");
                                           }else{
                                        	   $.messager.alert("提示",result.errorMsg);
                                               }
                               },"json")
                        }

                })
		}

	function commodityAddDialog(){
            $("#updateCommodity").dialog("open").dialog("setTitle","添加商品");
            url="commodity_addCommodity.action";          
		}
	function commodityModifyDialog(){
		var selectedRows=$("#commodityDatagrid").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#updateCommodity").dialog("open").dialog("setTitle","编辑商品信息");
		$("#name").val(row.name);
		$("#price").val(row.price);
		$("#category").val(row.category);
		$("#brand").val(row.brand);
		$("#salesvolume").val(row.salesvolume);
		$("#company").val(row.company);
		$("#inventory").val(row.inventory);
		$("#picId").val(row.picId);
		//alert(row.description);
		//$("#editor_id").text(row.description);
		$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).html(row.description);
		//$("#updateCommodityForm").form("load",row);
		url="commodity_addCommodity.action?id="+row.id;
	}
	function closeDialog(){
		$("#updateCommodity").dialog("close");
		resetCommodityInfo();
	}
	
	function resetCommodityInfo(){
		$("#name").val("");
		$("#price").val("");
		$("#inventory").val("");
		$("#category").val("");
		$("#brand").val("");
	}

	function saveCommodity(){
		
		$("#updateCommodityForm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetCommodityInfo();
					$("#updateCommodity").dialog("close");
					$("#commodityDatagrid").datagrid("reload");
				}
			}
		});
	}
</script>
  </head>
  
  <body>
     <table id="commodityDatagrid" title="商品管理 " class="easyui-datagrid" fitColumns="true" pagination="true" 
            rownumbers="true" fit="true" nowrap="true" toolbar="#toolbar"
            url="commodityManage_displayCommodityList.action">
        <thead>
          <tr>
              <th field="checkbox" checkbox="true" ></th>
              <th field="id" width="20" >商品ID</th>
              <th field="name" width="20">名称</th>
              <th field="category" width="20">类型</th> 
              <th field="brand" width="20">品牌</th>    
              <th field="price" width="20">单价</th>
              <th field="salesvolume" width="20">销量</th>    
              <th field="inventory" width="20">库存</th>    
              <th field="description" hidden="true">商品描述</th>      
              <th field="company" width="20">所属商家</th>
              <th field="picId"  hidden="true"></th>
          </tr>
        </thead>
     
     </table>
     
     <div id="toolbar">
         <div>
            <a href="javascript:void(0);"  onclick="commodityAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
            <a href="javascript:void(0);" onclick="commodityModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
            <a href="javascript:void(0);" onclick="commodityDelect()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
         </div>
         <div>搜索关键字： <input type="text" name="searchname" id="searchname"/>
            <a href="javascript:void(0);" onclick="commoditySearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
         </div>
     </div>
    <!-- 添加商品或修改商品对话框 -->
    <div id="updateCommodity" class="easyui-dialog" style="width:800px;height:400px;padding: 10px 20px" closed="true" buttons="#dialog-buttons">
     <form  id="updateCommodityForm" method="post" enctype="multipart/form-data">   
         <div style="margin-bottom: 20px;">商品名称：<input type="text" name="commodity.name" id="name">        </div>
            
         <div style="margin-bottom: 20px;"> 商品单价：<input type="text" name="commodity.price" id="price">      </div>
          
          <div style="margin-bottom: 20px;"> 商品类目：<input type="text" name="commodity.category" id="category"></div>
          
         <div style="margin-bottom: 20px;"> 商品库存量：<input type="text" name="commodity.inventory" id="inventory"></div>
         
         <div style="margin-bottom: 20px;">  商品描述：<textarea id="editor_id" style="width:700px;height:300px;" name="commodity.description" ></textarea></div>
         <div style="margin-bottom: 20px;">所属商家：
                  <select  name="commodity.company" id="company">
						<option value="商家1">商家1</option>
						<option value="商家2">商家2</option>
						<option value="商家3">商家3</option>
						<option value="商家4">商家4</option>
						<option value="商家5">商家5</option>
						<option value="商家6">商家6</option>
					</select>     
		</div>
           
         <div style="margin-bottom: 20px;">所属品牌：<input type="text" name="commodity.brand" id="brand">         </div>
           <input type="hidden" id="picId" name="commodity.picId" /> 
         <div>商品图片：<input type="file" name="commodityPicture" id="commodityPicture">   </div>
   </form>
    </div>
    
    <div id="dialog-buttons">
		<a href="javascript:void(0);" onclick="saveCommodity()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:void(0);" onclick="closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
  </body>
</html>
