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
    
    <title>My JSP 'orderManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js" ></script>	
    <script type="text/javascript" src="<%=basePath%>backStage/mall/js/datagrid-detailview.js" ></script>	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/themes/icon.css" />
    <link id="easyuiTheme" rel="stylesheet" 
   href="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
	<script type="text/javascript">
	$(function(){
		$('#orderDatagrid').datagrid({
		   view:detailview,		
		   detailFormatter:function(index,row){
				return '<div class="ddv" style="padding:5px 0"></div>';
			},
			onExpandRow: function(index,row){
				orderDetailView(row.id,index);
				var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
				ddv.panel({
					height:auto,
					border:false,
					cache:false,
					onLoad:function(){
						$('#orderDatagrid').datagrid('fixDetailRowHeight',index);
					},
					onResize:function(){
					     $('#dataGridContr').datagrid('fixDetailRowHeight',index);
					},
					onOpen:function(){
					     $('#dataGridContr').datagrid('fixDetailRowHeight',index);
					}
				});
				$('#orderDatagrid').datagrid('fixDetailRowHeight',index);
			}
		});
	});
		function orderDetailView(orderId,index) {
			  var detailHtml="";
			  $.ajax({
			   type : "post",
			   url : "orderManage_orderItemList.action",
			   data : {orderId : orderId},
			   dataType: "json",
			   success : function(data) {
			   console.log(data);
			    var detailHtml="<table style='width:100%;color:blue' border='1'><thead><tr>"
			    	+"<td><span>商品图片</span></td> <td><span>商品名称</span></td>"
			        +"<td><span>单价</span></td><td><span>数量</span></td>";
			    $.each(data.rows,function(i,commodity){
			     detailHtml+="<tr><td><img style='width:80px;height:80px;' src='<%=basePath%>"+data.rows[i].fileSource.path+"'/></td>";//data.rows[i].fileSource.path
			     detailHtml+="<td>"+data.rows[i].name+"</td>";
			     detailHtml+="<td>"+data.rows[i].price+"</td>";
			     detailHtml+="<td>"+data.rows[i].buynum+"</td></tr>";  
			    });  
			    detailHtml+="</table>";
			    $('div.ddv').html(detailHtml);
			    
			   },
			   error : function(err) {
			    
			   }
			  });
			 }
     //订单管理列操作
       function rowformater(value, row, index) {
            if(row.state==0){
            	 return "<a class='orderState' href='javascript:void(0);' onclick='changeOrderState(\""+row.id+"\",\""+row.state+"\")'>确认订单</a>";
                }else if(row.state==1){
                	return "<a class='orderState' href='javascript:void(0);' onclick='changeOrderState(\""+row.id+"\",\""+row.state+"\")'>发货</a>";
                    }else if(row.state==2){
                    	return "<span>交易完成</span>";
                        }
        }
      //修改订单状态ajax
      function changeOrderState(id,state){
    	  $.ajax({
      	    type:"post",
				url:"orderManage_changeOrderState.action",
				data:{"id":id,"state":state},
				dataType:"json",
				cache:false,
				 success:function(data){	
					 if(data.check){
						 $.messager.alert("提示","订单状态更新成功");
						 $("#orderDatagrid").datagrid("reload");
					 }
			    }
           })
          }
	</script>
  </head>
  
  <body>
   <table id="orderDatagrid" title="订单管理 " class="easyui-datagrid" fitColumns="true" pagination="true" 
            rownumbers="true" fit="true"  toolbar="#toolbar"
            url="orderManage_displayOrderList.action">
        <thead>
          <tr>
   
              <th field="id" width="20" >订单号</th>
              <th field="usersId" width="20">用户ID</th>
              <th field="comment" width="20">评论</th> 
              <th field="price" width="20" sortable="true">订单金额</th>  
               <th field="receiver" width="20">收货人</th>  
              <th field="usersPhone" width="20">联系方式</th>
              <th field="receiverInfo" width="20">收货地址</th>       
              <th field="state" width="20">订单状态</th>
              <th data-options="field:'operation',width:20,align:'center',formatter: rowformater">操作</th>
          </tr>
        </thead>
     
     </table>
     
   <div id="toolbar">
       <div>
          <a href="javascript:void(0);" onclick="" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
          <a href="javascript:void(0);" onclick="" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
       </div>
       <div>搜索关键字： <input type="text" name="searchname" id="searchname"/>
          <a href="javascript:void(0);" onclick="" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
       </div>
   </div>
  </body>
</html>
