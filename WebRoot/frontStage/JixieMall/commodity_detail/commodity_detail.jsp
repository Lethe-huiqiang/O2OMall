<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.jixie.bean.Commodity" %>
<%@ page import="com.jixie.bean.ShoppingCart" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <base href="<%=basePath%>">

 
<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>广东工业大学_计协商城-最专业的计算机网上超市</title>
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/head.css">
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/css/store.css">
    <link rel="stylesheet" href="<%=basePath%>frontStage/JixieMall/shoppingcart/css/shoppingcart.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>frontStage/JixieMall/commodity_detail/css/commodityDeatil.css">
    
<script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/commodity_detail/js/index.js"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/commodity_detail/js/public.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/commodity_detail/js/store.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js" charset="utf-8"></script>
<%-- 操作加入购物车表单--%>
<script type="text/javascript">
    function tijiao(){
        document.getElementById("shoppingCartForm").submit();
    }
    </script>
  <script>
   //function addToFavorite(){
      //  document.getElementById("favoriteForm").submit();
        
   // }
  
    function addToFavorite(id){		
    	$.ajax({
			type:"post",
			url:"favorite_addToFavorite.action",
			data:{"id":id},
			datatype:"json",
			cache:false,
			success:function(data){			
				if(data=="success"){
				     alert("收藏商品成功！详情请查看收藏夹");					
				}
				else if(data=="error"){
					 alert("收藏商品失败！收藏夹已存在该商品");	
					}
					return ;
			}
		});
        };
       
</script>

<!--<editmode></editmode>-->
<script type="text/javascript" src="js/t.js"></script>
</head>
<body>
<!-- 头部 -->
    <jsp:include  page="../commonhead.jsp"/>
    
    
<div id="commoditydetail" style="margin:0 auto;width: 950px;">

  <div title="商品图片" class="goods_img" ">
    <div class="goods_img_box">
       <img height="460px" width="460px;" src="<%=basePath%><s:property value='#request.fileSource.path' />" />
    </div>
  </div>  
  <div title="商品信息"  class="commodity_info_R" >
          <h2><s:property value='#request.commodity.name' /></h2>
        	 <ul>
        	 	<li>
        	 		<span class="g_tab">价格</span>
        	 		<strong ectype="goods_price">￥<s:property value='#request.commodity.price'/></strong>
        	 		<span>元</span>
        	 	</li>
        	 	<li>
        	 		<span class="g_tab">销量</span>    	 		
        	 		<span><s:property value='#request.commodity.salesvolume'/></span>
        	 		<span>件</span>
        	 	</li>
        	 	<li>
        	 		<span class="g_tab">预计送达</span>
        	 		<span >本校区一天送达</span>     	 		
        	 	</li>
        	 	<li>
        	 		<span class="g_tab">地区</span>
        	 		<span >广东工业大学龙洞校区</span>   
        	 	</li>
    	 	
        	 	<li>
        	 		<span class="g_tab">库存</span>
        	 		<span><s:property value='#request.commodity.inventory'/></span>
        	 		<span>件</span>
        	 	</li>
        	 </ul>

        	 <dl class="g_serPromise clearfix">
		      <dt>服务承诺</dt>
		      <dd class="clearfix">
		        <ul>  				
		          <li>
		              <h3>商品保证</h3>
		              <a target="_blank" href="" class="g_sn_1">
		                  <span class="g_serPromise_name">正品保障</span>
		              </a>
		          </li>
		          <li>
		              <h3>退款权益</h3>
		              <a target="_blank" href="" class="g_sn_2">
		                  <span class="g_serPromise_name">极速退款</span>
		                  <span class="g_serPromise_serLv">T3</span>
		              </a>
		          </li>
		          <li>
		              <h3>退货服务</h3>
		              <a target="_blank" href="" class="g_sn_3">
		                  <span class="g_serPromise_name">赠运费险</span>
		              </a>
		          </li>		
		        </ul>
		      </dd>
        </dl>
  </div>
  			  <a  class="buy_btn" href="javascript:tijiao()"></a>              
              <a  class="addToCart_btn" href="javascript:tijiao()"></a>
              <a class="favorite_btn" href="javascript:addToFavorite('${commodity.id}')"><i class="icon_favorite_btn"></i>收藏该商品</a>
 </div>          
             
            
          <form  id="favoriteForm" action="favorite_addToFavorite.action" method="post" > 
                <input type="hidden" name="favorite.commodityId" value="${commodity.id}" />   
           </form>
          <form id="shoppingCartForm" action="shoppingcart_addToShoppingCart.action" method="post">
               <input type="hidden" name="commodity.id" value="${commodity.id}" />   
               <input type="hidden" name="shoppingCart.commodityId" value="${commodity.id}" />                                 
          </form>
   <div class="commodityInfo_description" >
      <div class="commodityInfo_head">
         <span>商品详情</span>
      </div>
   <s:property value="#request.commodity.description" escape="false" />
   </div>
 
       <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>

</body>
</html>