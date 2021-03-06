<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(session.getAttribute("users")==null){
	response.sendRedirect("login.html");
}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
    <script type="text/javascript" src="<%=basePath%>backStage/mall/js/jquery.cookie.js"></script>
   <link id="easyuiTheme" rel="stylesheet" 
   href="<%=basePath%>backStage/mall/js/jquery-easyui-1.3.6/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>backStage/mall/css/index.css" />
	<script type="text/javascript">
	
	    $(function(){
	       //树目录
	       var treeData=[{
	         text:"管理菜单",
	         children:[{
	             text:"商品管理",
	             attributes:{
	                url:"<%=basePath%>backStage/mall/commodityManage.jsp"
	             }
	         },{
	             text:"用户管理",
	              attributes:{
	                url:"<%=basePath%>backStage/mall/userManage.jsp"
	             }	            
	         },{
	             text:"订单管理",
	              attributes:{
	                url:"<%=basePath%>backStage/mall/orderManage.jsp"
	             }	            
	         },{
	             text:"文章管理",
	              attributes:{
	                url:"<%=basePath%>backStage/mall/articleManage.jsp"
	             }	            
	         },{
	             text:"查看商城",
	              attributes:{
	                url:"commodity_showCommodityList.action"
	             }	            
	         }]	       
	       }];
	     //实例化树菜单
	     $("#tree").tree({
	        data:treeData,
	        lines:true,
	        onClick:function(node){
	          if(node.attributes){
	             optenTab(node.text,node.attributes.url);
	          }
	        }
	     });
	     
	     //新增tabs
	     function optenTab(text,url){
	     if($("#tabs").tabs('exists',text)){
	         $("#tabs").tabs('select',text);
	     }else{
	          var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%' src="+url+"></iframe>"
		      $("#tabs").tabs('add',{
		              title:text, 
		              closable:true,
		              content:content,
		         })
	     }
	        
	     }
	     $("#changeThemes").splitbutton({menu:'#themesMenu'});
	    });
	    /**
	     * @requires jQuery,EasyUI,jQuery cookie plugin
	     * 
	     * 更换EasyUI主题的方法
	     * 
	     * @param themeName
	     *            主题名称
	     */
	    changeTheme = function(themeName) {
	    	var $easyuiTheme = $('#easyuiTheme');
	    	var url = $easyuiTheme.attr('href');
	    	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	    	$easyuiTheme.attr('href', href);

	    	var $iframe = $('iframe');
	    	if ($iframe.length > 0) {
	    		for ( var i = 0; i < $iframe.length; i++) {
	    			var ifr = $iframe[i];
	    			$(ifr).contents().find('#easyuiTheme').attr('href', href);
	    		}
	    	}

	    	$.cookie('easyuiThemeName', themeName, {
	    		expires : 7
	    	});
	    };
	    	    
	</script>
  </head>
  
  <body class="easyui-layout">
     <div data-options="region:'north',title:'头部',split:'true'" style="height:100px ">
          <div id="changeThemes" icon="icon-edit" style="width:120px;">更换主题</div>
          <div id="themesMenu" style="width:120px;">  
            <div onclick="changeTheme('default')">default</div>
            <div onclick="changeTheme('black')">black</div>    
            <div onclick="changeTheme('gray')">gray</div>  
            <div onclick="changeTheme('bootstrap')">bootstrap</div>  
            <div onclick="changeTheme('metro')">metro</div>              
            <div onclick="changeTheme('sunny')">sunny</div>  
            <div onclick="changeTheme('pepper-grinder')">pepper-grinder</div>
            <div onclick="changeTheme('dark-hive')">dark-hive</div>  
            <div onclick="changeTheme('cupertino')">cupertino</div>    
        </div>  
     </div>
     <div data-options="region:'south',title:'底部',split:true" style="height:50px;"></div>    
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">
        <ui id="tree">
            
        </ui>
     </div>
    <div data-options="region:'center'" >
        <div class="easyui-tabs"  id="tabs" fit="true">
            <div title="首页">
               <div class="centercontent">
                                                  商城后台管理
               </div>
          </div>
        </div>
    </div>  
     
  </body>
</html>
