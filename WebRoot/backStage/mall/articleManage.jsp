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
	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/parseToDate.js"></script>
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
			var editor1 = K.create('textarea[name="article.content"]', {
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
						document.forms['updateArticleForm'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['updateArticleForm'].submit();
					});
				},afterBlur: function(){this.sync();}
			});
			prettyPrint();
		});
	</script>
<script type="text/javascript">
	function articleSearch(){
		$('#articleDatagrid').datagrid('load',{
			searchname:$('#searchname').val()
		});
	}

	function commodityDelect(){
            var selectedRows=$('#articleDatagrid').datagrid('getSelections');
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

            $.messager.confirm("提示","您确定要删除这<font color=red size=16>"+selectedRows.length+"</font>篇文章吗？",function(r){
                    if(r){
                           $.post("commodityManage_delectCommodity.action",{ids:ids,delnums:delnums},
                                   function(result){
                                     if(result.success){
                                         $.messager.alert("提示","成功删除<font color=red size=16>"+result.deltotal+"</font>篇文章");
                                           $("#articleDatagrid").datagrid("reload");
                                           }else{
                                        	   $.messager.alert("提示",result.errorMsg);
                                               }
                               },"json")
                        }

                })
		}

	function articleAddDialog(){
            $("#updateArticle").dialog("open").dialog("setTitle","新增文章");
            url="articleManage_addArticle.action";          
		}
	function parseToDate(value,row,index){
				var year=row.createTime.year+1900;
				var month=row.createTime.month+1;
				var day=row.createTime.date;
				var hours=row.createTime.hours;
				var minutes=row.createTime.minutes;
				var time=year+'-'+month+'-'+day+' '+hours+':'+minutes;
				console.log(time);
			    return time; 
		}
	function articleModifyDialog(){
		var selectedRows=$("#articleDatagrid").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#updateArticle").dialog("open").dialog("setTitle","编辑文章信息");
		$("#name").val(row.name);
		$("#title").val(row.title);
		$("#type").val(row.type);
		//$("#editor_id").text(row.description);
		$(document.getElementsByTagName('iframe')[0].contentWindow.document.body).html(row.content);
		//$("#updateCommodityForm").form("load",row);
		url="articleManage_addArticle.action?id="+row.id;
	}
	function closeDialog(){
		$("#updateArticle").dialog("close");
		resetCommodityInfo();
	}
	
	function resetCommodityInfo(){
		$("#name").val("");
		$("#title").val("");
		$("#type").val("");
		$("#content").val("");	
	}

	function saveArticle(){
		
		$("#updateArticleForm").form("submit",{
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
					$("#updateArticle").dialog("close");
					$("#articleDatagrid").datagrid("reload");
				}
			}
		});
	}
</script>
  </head>
  
  <body>
     <table id="articleDatagrid" title="商品管理 " class="easyui-datagrid" fitColumns="true" pagination="true" 
            rownumbers="true" fit="true" nowrap="true" toolbar="#toolbar"
            url="articleManage_displayArticleList.action">
        <thead>
          <tr>
              <th field="checkbox" checkbox="true" ></th>
              <th field="id" width="20" >文章ID</th>
              <th field="name" width="20">名称</th>
              <th field="title" width="20">主题</th> 
              <th field="type" width="20">类型</th>    
              <th field="content" hidden="true" width="20">内容</th>
              <th field="createTime" width="20" formatter="parseToDate">发布时间</th>    
          </tr>
        </thead>
     
     </table>
     
     <div id="toolbar">
         <div>
            <a href="javascript:void(0);"  onclick="articleAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
            <a href="javascript:void(0);" onclick="articleModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
            <a href="javascript:void(0);" onclick="articleDelect()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
         </div>
         <div>搜索关键字： <input type="text" name="searchname" id="searchname"/>
            <a href="javascript:void(0);" onclick="articleSearch()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
         </div>
     </div>
    <!-- 新增文章或修改文章对话框 -->
    <div id="updateArticle" class="easyui-dialog" style="width:800px;height:400px;padding: 10px 20px" closed="true" buttons="#dialog-buttons">
     <form  id="updateArticleForm" method="post" enctype="multipart/form-data">   
         <div style="margin-bottom: 20px;">文章名称：<input type="text" name="article.name" id="name">        </div>
            
         <div style="margin-bottom: 20px;"> 文章主题：<input type="text" name="article.title" id="title">      </div>
          
          <div style="margin-bottom: 20px;"> 文章类型：<input type="text" name="article.type" id="type"></div>
                   
         <div style="margin-bottom: 20px;">  文章内容：<textarea id="editor_id" style="width:700px;height:300px;" name="article.content" ></textarea></div>
                
   </form>
    </div>
    
    <div id="dialog-buttons">
		<a href="javascript:void(0);" onclick="saveArticle()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:void(0);" onclick="closeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
  </body>
</html>
