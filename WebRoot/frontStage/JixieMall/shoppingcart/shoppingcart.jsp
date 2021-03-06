<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>shoppingcart</title>
    
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
    
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/t.js"></script>
    <script type="text/javascript" src="<%=basePath%>frontStage/JixieMall/js/h.js"></script>
    
<script type="text/javascript" language="javascript">
    function changeNum(id,obj,oldnum){       
 			if(!/^[1-9]\d*$/.test(obj.value)){
 				alert("购买数量必须为正整数!");
 				obj.value=oldnum;
 				return;
 				
 			}
 			var value=obj.value;
 			var price = $(obj).parent().parent().prev().children().html();
 			
//window.location.href="shoppingcart_changeCart.action?id="+id+"&buynum="+obj.value ;
 			$.ajax({
 				type:"post",
 				url:"shoppingcart_changeCart.action",
 				data:{"id":id,"buynum":value},
 				datatype:"json",
 				cache:false,
 				success:function(data){			
 					if(data=="success"){
 						var total = value * price;
 						$(obj).parent().parent().next().children().html(total);	
 						console.log($('.buynum'));		
 						var sumNumber=0;
 						var sumMoney=0;		
 						$.each($('.buynum'),function(i,val){
							console.log($(val).val());	
							var count=parseInt($(val).val());	
							sumNumber+=count;
 	 						});	
 						$.each($('.sumprice'),function(i,val){
							console.log($(val).text());	
							var money=parseInt($(val).text());	
								sumMoney+=money;
 	 						});		
 						$("#money").text(sumMoney);		
 						$("#count").text(sumNumber);	 						
 					}	
 					else
 						return ;
 				}
 			});
 		};
//隐藏导航图片
 		  $(function(){
 		        $('.guide-img').hide();
 			   });
    </script>
  </head>
  
  <body>
		 <!-- 头部 -->
    	<jsp:include  page="../commonhead.jsp"/>
     <!-- 购物车content -->
     <div class="cartcontent">
        <div class="carthead">
        	<img src="<%=basePath%>frontStage/JixieMall/shoppingcart/images/cart.png">
        	<span>我的购物车</span>
        </div>
     	  <table class="table" > 
     	  <thead>
            <tr>
				<th>商品</th>
				<th>商品名称</th>
				<th>商品种类</th>
				<th>商品单价</th>
				<th>购买数量</th>				
				<th>总价</th>
				<th>删除</th>
	        </tr>  	   
	      </thead>
	    <s:iterator value="#request.cartmap">
			<tr>
			    <td> 
			    <img  style="width:70px;height:70px;" src="<%=basePath%><s:property value='key.fileSource.path' />" />
			    </td>
			    <td>  
			          <p class="name">
                       <s:property value='key.name' />
                      </p>     
                </td>
			    <td>
			          <p class="category">
                         <s:property value='key.category' />
                      </p> 
			    </td>
			    <td>
			         <p class="price">			           
                       <s:property value='key.price' />
                      </p>   
			    </td>
			    <td>
			        <p class="number">                     
                       <input style="height:30px;width:80px;text-align:center" type="number" class="buynum" onchange="changeNum('<s:property value='key.id' />',this,value)" value=<s:property value='value' /> />                        
                      </p> 
			    </td>			    
			    <td>
			         <p class="sumprice"><s:property value='key.price*value' /></p>
			    </td>
			    <td>
			          <a href="shoppingcart_deleteCartCommodity.action?id=<s:property value='key.id' />">删除</a>
			    </td>
			</tr>
		</s:iterator>
 </table>
          <div class="cartcount">
          		<input id="bcCount" type="hidden" value="${request.count}">
          	   <span >商品金额总计：<b id="money"><s:property value='#request.money' /></b>元</span>
          	   <span >商品数量总计：<b id="count"><s:property value='#request.count' /> </b>件</span>
          </div>
          <div class="cartfooter">
           <div class="gotoshop"><a href="commodity_showCommodityList.action">继续购物</a></div>
           <div class="clearcart"><a href="shoppingcart_clearCartmap.action">清空购物车</a></div>
           <div class="gotopay"><a href="<%=basePath %>/frontStage/JixieMall/create_order/order.jsp">￥结算</a></div>
          </div>
     </div>
	  <!-- 尾部 -->
<jsp:include  page="../commonfooter.jsp"/>
</body>
</html>
