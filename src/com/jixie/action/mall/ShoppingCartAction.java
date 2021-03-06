package com.jixie.action.mall;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.bean.ShoppingCart;
import com.jixie.bean.Users;
import com.jixie.service.order.OrderService;
import com.jixie.service.shoppingcart.ShoppingCartService;
import com.jixie.system.thread.Utils;

public class ShoppingCartAction extends BaseAction {
    
	private Commodity commodity; // 商品实体
	private File[] commodityPicture;// 上传的图片
	private String[] commodityPictureFileName;// 上传的图片的文件名
	private ShoppingCart shoppingCart;
	private ShoppingCartService shoppingCartService;


	/**
	  * 加入购物车
	  * 
	  * 
	  **/
	 public String addToShoppingCart(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 Timestamp creTime = Utils.date2Stamp(new Date());	
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 
	     //获取页面传的商品ID	
		 String id=request.getParameter("commodity.id");
		 System.out.println(id);
		

		 Map<Commodity,Integer> cartmap=(Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
		//根据userid查询购物车表有无该用户对应的commodityID
		 String hql="from ShoppingCart s where s.usersId = ? ";
		 List<ShoppingCart> list = commonService.findListByHQL(hql, userId);
		 //购物车商品总价
		 int money=0;
		 //购物车商品总数
		 int count=0;
		 boolean flag=false;  // 记录查询时是否有对应的commodityId对应上
 		
			 for (int i = 0; i < list.size(); i++) {
				 ShoppingCart shoppingCart=list.get(i);
				     if(id.equals(shoppingCart.getCommodityId().toString())){
				    	//更新shoppingcart表的count值
				    	 shoppingCart.setCount(shoppingCart.getCount()+1);
						 commonService.saveOrUpdate(shoppingCart);	
						 flag=true;
						 
				     }
				 commodity=commonService.findById(shoppingCart.getCommodityId(), new Commodity());
				 FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
				 commodity.setFileSource(fileSource);
				 cartmap.put(commodity, shoppingCart.getCount());
				//更新购物车商品总数
				 count=count+shoppingCart.getCount();
				 //更新购物车商品总价
				 money=(int) (money+shoppingCart.getCount()*commodity.getPrice());
			 }
			 //设置属性并保存新的shoppingcart实体
			 if(flag==false){
			 shoppingCart.setCommodityId(id);
			 shoppingCart.setCreateTime(creTime);
			 shoppingCart.setUpdateTime(creTime);
			 shoppingCart.setId(Utils.getUUID());
			 shoppingCart.setUsersId(userId);
			 shoppingCart.setCount(1);
			 commonService.save(shoppingCart);
			 //取得新增的商品信息并放入cartmap
			 commodity=commonService.findById(shoppingCart.getCommodityId(), new Commodity());
			 FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
			 commodity.setFileSource(fileSource);
			 cartmap.put(commodity, shoppingCart.getCount());
			//更新购物车商品总数
			 count=count+shoppingCart.getCount();
			 //更新购物车商品总价
			 money=(int) (money+shoppingCart.getCount()*commodity.getPrice());
			 }
		 
 		
 		 request.setAttribute("cartmap", cartmap);
 		request.setAttribute("money", money);
 		request.setAttribute("count", count);
 		 
		 return "addToShoppingCart";
	 }
	 
	 /**
	  *根据ID
	  *删除购物车中商品 
	  * 
	  */
	 public String deleteCartCommodity(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String id=request.getParameter("id");
		 
		 commodity=commonService.findById(id, new Commodity());
		//根据ID找到对应的shoppingcart实体并删除表中的记录
     	boolean result=shoppingCartService.deleteShoppingCart(id);
		 if(commodity!=null && result==true){
			//购物车map
			 Map<Commodity,Integer> cartmap=(Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
		      cartmap.remove(commodity);
		      request.setAttribute("cartmap", cartmap);
	     
		 }
			 return "addToShoppingCart";
		 
	 }
	 /**
	  * 清空购物车
	  * 
	  * 
	  */
	 public String clearCartmap(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 boolean result=shoppingCartService.deleteAllShoppingCart(userId);
		//购物车map
		 Map<Commodity,Integer> cartmap=(Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
		 if(result==true){
	     cartmap.clear();
		 }
	     request.setAttribute("cartmap", cartmap);
		return "addToShoppingCart";
	 } 
	 /**
	  *修改购物车 
	  * 
	  */
	 public void changeCart(){
		//根据id查找出要购买的商品
		 HttpServletRequest request = ServletActionContext.getRequest();
		 //HttpServletResponse response = ServletActionContext.getResponse();
		 try{
			 //PrintWriter out = response.getWriter();
			 String id=request.getParameter("id");		 
			 commodity=commonService.findById(id, new Commodity());		
			 //购物车map
			 Map<Commodity,Integer> cartmap=(Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
			 //修改cartmap对应商品的购买数量
			 int buynum = Integer.parseInt(request.getParameter("buynum"));
			 boolean result=shoppingCartService.updateShoppingCart(id, buynum);
		 if(result==true){
			 cartmap.put(commodity, buynum);
			                }
			 //return "addToShoppingCart";
			 //out.print(buynum);
			 this.sendMsgAjax("success", "utf-8");
		 }catch(Exception e){
			 e.printStackTrace();
		 }	 
	 }
	 
	 /**
	  *查看购物车 
	  * 
	  */
	 public  String  myShoppingCart(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 //购物车商品列表map
		 Map<Commodity,Integer> cartmap=(Map<Commodity, Integer>) request.getSession().getAttribute("cartmap");
		//根据userid查询购物车表的commodity
		 String hql="from ShoppingCart s where s.usersId = ? ";
		 List<ShoppingCart> list = commonService.findListByHQL(hql, userId);
		 //购物车中的商品数量
		 int count=0;
		 //购物车商品总价
		 float money=0;
		 if(list.size()>0){
			 for (int i = 0; i < list.size(); i++) {
				 ShoppingCart shoppingCart=list.get(i);
				 commodity=commonService.findById(shoppingCart.getCommodityId(), new Commodity());
				 FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
				 commodity.setFileSource(fileSource);
				 cartmap.put(commodity, shoppingCart.getCount());
				 money+=commodity.getPrice()*shoppingCart.getCount();
				 count+=shoppingCart.getCount();
			 }
			}
		 request.setAttribute("count", count);
		 request.setAttribute("money", money);
		 request.setAttribute("cartmap", cartmap);
		 return "myShoppingCart";
	 }

	 
	 
	 
	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public File[] getCommodityPicture() {
		return commodityPicture;
	}

	public void setCommodityPicture(File[] commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String[] getCommodityPictureFileName() {
		return commodityPictureFileName;
	}

	public void setCommodityPictureFileName(String[] commodityPictureFileName) {
		this.commodityPictureFileName = commodityPictureFileName;
	}



	 public ShoppingCart getShoppingCart() {
			return shoppingCart;
		}

		public void setShoppingCart(ShoppingCart shoppingCart) {
			this.shoppingCart = shoppingCart;
		}

		public ShoppingCartService getShoppingCartService() {
			return shoppingCartService;
		}

		public void setShoppingCartService(ShoppingCartService shoppingCartService) {
			this.shoppingCartService = shoppingCartService;
		}
	 
	 
}




