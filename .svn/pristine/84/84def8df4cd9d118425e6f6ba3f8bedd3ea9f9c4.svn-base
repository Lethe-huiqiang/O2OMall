<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
if(session.getAttribute("users")==null){
	response.sendRedirect("/webjixie/frontStage/users/jsp/login.jsp");
}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My person page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/person_page/css/head.css">
        <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/person_page/css/store.css">
        <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/person_page/css/person_page.css">
        <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery-1.8.2.min.js"></script>
        <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>
        
  <script type="text/javascript">
	//判断前一个页面要请求的数据
	$(function(){
         var requestKey=$("#requestKey").val();          
         if(requestKey=="favorite"){
                	myFavoriteView();
             }else if(requestKey=="userCenter"){
             	personInfo();
                 }
		});
	//用户信息ajax
	function personInfo(){
		  var personInfoHtml="";
          $.ajax({
				type:"post",
				url:"userCenter_showUserInfo.action",
				dataType:"json",
				cache:false,
			    success:function(data){
        	     console.log(data);	
        	     var path=data.usersInfo.fileSource;
        	     if(path!=null){			 
				    var personInfoHtml='<form action="userCenter_updateUsersInfo.action" method="post" enctype="multipart/form-data"><table class="table"><tr><td><span>我的头像</span></td>'
		                +'<td><img src="<%=basePath %>'+data.usersInfo.fileSource.path+'" width=100px height=100px></td></tr>'
		                +'<tr><td></td><td><input type="file" value="更换头像" name="usersPicture" id="picture" ></td></tr>'	                
				    	+'<tr><td>昵称</td><td><input name="usersInfo.nickname" type="text" value="'+data.usersInfo.nickname+'" /></td></tr>'
				    	+'<tr><td>邮箱</td><td>'+data.usersInfo.email+'</td></tr><input name="usersInfo.id" type="hidden" value="'+data.usersInfo.id+'" />'
				    	+'<tr><td>专业</td><td><input name="usersInfo.major" type="text" value="'+data.usersInfo.major+'" /></td></tr>'
				    	+'<tr><td>注册码（邀请码）</td><td>'+data.usersInfo.registCode+'</td></tr><input name="usersInfo.registCode" type="hidden" value="'+data.usersInfo.registCode+'" />'
				    	+'<tr><td><input type="submit" value="保存" id="save" ></td><td></td></tr>'
				 	   +'</table></form>';
					    $('div.content-right').html(personInfoHtml);
					    src=$('#basePath').val()+data.usersInfo.fileSource.path;
				        $('.userPicture').attr("src",src);
        	      }else{
        	    	  var personInfoHtml='<form action="userCenter_updateUsersInfo.action" method="post" enctype="multipart/form-data"><table class="table"><tr><td><span>我的头像</span></td>'
  		                +'<td><img src="<%=basePath %>fileSource/userDefaultImage.png" width=100px height=100px></td></tr>'
  		                +'<tr><td></td><td><input type="file" value="更换头像" name="usersPicture" id="picture" ></td></tr>'	                
  				    	+'<tr><td>昵称</td><td><input name="usersInfo.nickname" type="text" value="'+data.usersInfo.nickname+'" /></td></tr>'
  				    	+'<tr><td>邮箱</td><td>'+data.usersInfo.email+'</td></tr><input name="usersInfo.id" type="hidden" value="'+data.usersInfo.id+'" />'
  				    	+'<tr><td>专业</td><td><input name="usersInfo.major" type="text" value="'+data.usersInfo.major+'" /></td></tr>'
  				    	+'<tr><td>注册码（邀请码）</td><td>'+data.usersInfo.registCode+'</td></tr><input name="usersInfo.registCode" type="hidden" value="'+data.usersInfo.registCode+'" />'
  				    	+'<tr><td><input type="submit" value="保存" id="save" ></td><td></td></tr>'
  				 	   +'</table></form>';
        	    	    $('div.content-right').html(personInfoHtml);
					    src=$('#basePath').val()+"fileSource/userDefaultImage.png";
				        $('.userPicture').attr("src",src);
            	      }
					    $('div.myorder').hide();					   
				   },
				   error : function(err) {
				    
				   }	

              });
		}
	//用户收藏夹ajax
       function myFavoriteView(){
             var favoriteHtml="";
              $.ajax({
					type:"post",
					url:"favorite_showFavorite.action",
					dataType:"json",
					cache:false,
				    success:function(data){				 
					    var favoriteHtml='<table class="table"><thead><tr><td><span>商品图片</span></td>'
			                +'<td><span>商品名称</span></td><td><span>单价</span></td><td><span style="margin-left:50px;">操作</span></td></tr></thead>';
			               console.log(data); 
					    $.each(data.rows,function(i,commodity){
						    favoriteHtml+='<tbody><tr><td><img  style="width:80px;height:80px;" src="<%=basePath%>'+data.rows[i].fileSource.path+'"';
						    favoriteHtml+='</td><td><p class="name">'+data.rows[i].name+'</p></td>'
						    favoriteHtml+='<td><p class="price"><strong>¥</strong>'+data.rows[i].price+'</p></td>'
						    favoriteHtml+="<td><a href='javascript:void(0)' onclick='cancelFavorite(\""+data.rows[i].id+"\")'>取消收藏</a>&nbsp&nbsp&nbsp<a href='commoditySearch_commodityDetail.action?id="+data.rows[i].id+"'>再次购买</a></td></tr></tbody>";
					    });  
						    favoriteHtml+="</table>";
						    $('div.myorder').hide();
						    $('div.content-right').html(favoriteHtml);
						    src=$('#basePath').val()+data.userPhoto.path;
					        $('.userPicture').attr("src",src);
					   },
					   error : function(err) {
					    
					   }	

                  });
           }
       //取消商品收藏ajax
       function cancelFavorite(id){
             $.ajax({
            	    type:"post",
					url:"favorite_deleteFavorite.action",
					data:{"id":id},
					dataType:"json",
					cache:false,
					 success:function(data){	
						 if(data.check){
							alert("已取消收藏");
						    myFavoriteView();
						 }
				    }
                 })

           }
      //修改订单状态
      $(function(){
     
		var orderStateArray=$(".orderState");			
			for(var i=0;i<orderStateArray.length;i++){
		           if( $(orderStateArray[i]).text()==0){
		           	$(orderStateArray[i]).text("等待商家确认");
		           	 $(orderStateArray[i]).css('color','red');
		               }else if( $(orderStateArray[i]).text()==1){
		               	$(orderStateArray[i]).text("订单已确认");	
		                   }else if( $(orderStateArray[i]).text()==2){
		                   	$(orderStateArray[i]).text("交易完成");
		                   	$(orderStateArray[i]).css('color','green');
		                       }
		                     
		                    }
          });
   $(function(){
        $('.guide-img').hide();
	   });
  </script>
  </head>
  
  <body>
  <input type="hidden" id="requestKey" value="<%=request.getParameter("request")%>"/>
  <input id="basePath" type="hidden"  value="<%=basePath %>"/>
 <!-- 头部 -->
    	<jsp:include  page="../commonhead.jsp"/>
	<!-- 内容页面 -->
		<div class="content">

  <div class="content-left">
	  <div class="userPicture-border">
			<span><img class="userPicture" src="<%=basePath%><s:property value='#request.userPhoto.path' />"></span>
	  </div>
			  <ul class="menu">
			        <li  class="level1">
			      <a href="javascript:void(0);" onclick="personInfo()">
			        <i class="icon-user"></i>
			        个人中心
			      </a>
			    </li>
			    <li class="divider"></li>
			    
			    <li class="nav-header">订单中心</li>
			    <li class="level1">
			      <a href="order_showMyOrder.action?searchKey=inmonth">
			        <i class="icon-calendar"></i>
			        最近一个月
			      </a>
			    </li >
			        <li class="level1">
			      <a href="order_showMyOrder.action?searchKey=monthago">
			        <i class="icon-list-alt"></i>
			        一个月之前
			      </a>
			    </li>
			    <%-- 
			        <li class="level1">
			      <a href="order_showMyOrder.action?searchKey=state">
			        <i class="icon-comment"></i>
			        未评价订单
			      </a>
			    </li>
			        <li class="level1">
			      <a href="order_showMyOrder.action?searchKey=nocomment">
			        <i class="icon-nopay"></i>
			        未支付订单
			      </a>
			    </li>
			     --%>
			    <li class="divider"></li>

			    <li class="nav-header">我的收藏</li>
			    
			    <li class="level1">
			      <a href="javascript:void(0);" onclick="myFavoriteView()">
			        <i class="icon-favorite"></i>
			        我收藏的商品
			      </a>
			    </li>
			  <%--   <li class="divider"></li>      

			    <li class="nav-header">安全中心</li>
			    <li class="level1">
			      <a href="#">
			        <i class="icon-setting"></i>
			        修改密码
			      </a>
			    </li>
			    <li class="level1">
			      <a href="#">
			        <i class="icon-safe"></i>
			        安全设置
			      </a>
			    </li>
			    <li class="divider"></li>
			
			    <li class="nav-header">在线支付</li>
			    <li class="level1">
			      <a href="">
			        <i class="icon-nopay"></i>
			         收支明细
			      </a>
			    </li>
			   --%>
			      </ul>
        </div>

			<div  class="content-right">
				<div class="myorder">
				  <div class="title">
				  	 <h2><s:property value='#request.orderTitle' /></h2>

				  </div>
			 <s:iterator value="#request.orderlist">
					<div class="order-header">
				      <div class="order-state">
				      	 <span class="orderState"><s:property value='paystate' /></span>
				      </div>
				      <table  class="table"> 
				       <tbody>
				         <tr>
							<td><span>订单号:</span><s:property value='id' /></td>
							<td><span>支付时间 :</span><s:property value='ordertime' /></td>
							<td><span>订单金额 :<strong>¥</strong></span><s:property value='money' /></td>
					     </tr>
					     <tr>
							<td><span>收货地址 :</span><s:property value='receiverinfo' /></td>
							<td><span>联系方式 :</span><s:property value='phone' /></td>
							<td><span>备注 :</span></td>
								
					     </tr>
					     </tbody>
					   </table>
	                </div>
	      <div class="order-content" id="order_table_commodityMap">
	       <table class="table">
	         <thead>
	              <tr>
	                 <td><span>商品图片</span></td>
	                 <td><span>商品名称</span></td>
	                 <td><span>单价</span></td>
	                 <td><span>数量</span></td>
	                 <td><span>小计</span></td>
	              </tr>
	           </thead>	    
	        <s:iterator value="orderCommodityMap">	         
	           <tbody>
	            <tr>
			            <td> 
					    <img  style="width:80px;height:80px;" src="<%=basePath%><s:property value='key.fileSource.path' />" />
					    </td>
					    <td>  
					          <p class="name">
		                       <s:property value='key.name' />
		                      </p>     
		                </td>
					    <td>
					         <p class="price">					           
					           <strong>¥</strong>
		                       <s:property value='key.price' />
		                      </p>   
					    </td>
					     <td>
					         <p class="buynym">
		                       <s:property value='value' />
		                      </p>   
					    </td>	
					     <td>
					         
					         <p class="sumprice">
					         <strong>¥</strong>
		                       <s:property value='key.price* value' />
		                      </p>   
					    </td>			
			    </tr>
	           </tbody>	  
	         </s:iterator>      
	       </table>
	 
	 </div>
	</s:iterator>  
				</div>
			</div>
		</div>

  <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
      </body>
</html>
