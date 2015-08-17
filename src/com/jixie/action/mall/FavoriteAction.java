package com.jixie.action.mall;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.bean.Commodity;
import com.jixie.bean.Favorite;
import com.jixie.bean.FileSource;
import com.jixie.bean.ShoppingCart;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.service.favorite.FavoriteService;
import com.jixie.system.thread.Utils;
import com.jixie.utils.MallManageUtil;

public class FavoriteAction extends BaseAction {
     
	 private Commodity commodity; //商品实体
	 private Favorite favorite;   // 收藏夹实体
     private FavoriteService favoriteService;
	 /**
	  *添加到收藏夹 
	 * @throws IOException 
	  * 
	  */
	 public void addToFavorite() throws IOException{		 
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 Timestamp creTime = Utils.date2Stamp(new Date());	
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 //商品ID
		 String id=request.getParameter("id");	
		 Map<Commodity,Integer> favoritemap=(Map<Commodity, Integer>) request.getSession().getAttribute("favoritemap");
		//根据userid查询收藏夹表有无该用户对应的commodityID
		 String hql="from Favorite f where f.usersId = ? ";
		 List<Favorite> list = commonService.findListByHQL(hql, userId);
		 boolean flag=false;  // 记录查询时是否有对应的commodityId对应上
		 for (int i = 0; i < list.size(); i++) {
			  Favorite favorite=list.get(i);
			 if(id.equals(favorite.getCommodityId().toString())){
				 this.sendMsgAjax("error", "utf-8");
				// out.print("<script>window.alert('收藏夹已存在该商品!!!');</script>");
				 request.setAttribute("message", "收藏夹已存在该商品!!!");
				 flag=true;
			     }
		 }
		 if(flag==false){
				 //保存收藏夹信息
			     favorite=new Favorite();
				 favorite.setId(Utils.getUUID());
				 favorite.setCommodityId(id);
				 favorite.setCreateTime(creTime);
				 favorite.setUpdateTime(creTime);
				 favorite.setUsersId(userId);	
				 commonService.save(favorite);
				 this.sendMsgAjax("success", "utf-8");
				 //request.setAttribute("message", "收藏商品成功！详情请查看收藏夹!");
		    	 
					     }
		
		 
	 }
	/**
	 *查看收藏夹 
	 * 
	 */
	 public void showFavorite(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response=ServletActionContext.getResponse();
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 //用户头像
		 UsersInfo userinfo=commonService.findById(userId, new UsersInfo());
		 FileSource userPhoto=commonService.findById(userinfo.getPictureId(), new FileSource());
		 //收藏商品列表List
		List favoriteList=new ArrayList();
		//用户头像
		//根据userid查询收藏夹表表有无该用户对应的commodityID
		 String hql="from Favorite f where f.usersId = ? ";
		 List<Favorite> list = commonService.findListByHQL(hql, userId);
		 if(list.size()>0){
			 for (int i = 0; i < list.size(); i++) {
				 favorite=list.get(i);
				 commodity=commonService.findById(favorite.getCommodityId(), new Commodity());
				 FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
				 commodity.setFileSource(fileSource);
				 favoriteList.add(commodity);
			 }
			}
		 JSONArray jsonArray = null;
		 JSONObject userPhotoJson = JSONObject.fromObject(userPhoto);//将java对象转换为json对象 
			try {
				JSONObject result=new JSONObject();
				//转换成json数组
				jsonArray = MallManageUtil.formatListToJsonArray(favoriteList);
				result.put("rows", jsonArray);
				result.put("userPhoto", userPhotoJson);
				MallManageUtil.write(response, result);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		 //request.setAttribute("favoriteList", favoriteList);
		// return "showFavorite";
	 }
     /**
      *从收藏夹中删除 
      * 
      */
	 public void deleteFavorite(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String id=request.getParameter("id");
		 
		 commodity=commonService.findById(id, new Commodity());
		//根据ID找到对应的Favorite实体并删除表中的记录
     	boolean result=favoriteService.deleteFavorite(id);
		 if(commodity!=null && result==true){
//			//收藏夹map
//			 Map<Commodity,Integer> favoritemap=(Map<Commodity, Integer>) request.getSession().getAttribute("favoritemap");
//			 favoritemap.remove(commodity);
//		     request.setAttribute("favoritemap", favoritemap);
	       try {
			this.sendMsgAjax("{\"check\":true}", "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 }

	 }
	  /**
      *清空收藏夹 
      * 
      */
	 public String deleteAllFavorite(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 //获取用户ID
		 Users user = (Users) request.getSession().getAttribute("users");
		 String userId=user.getId();
		 boolean result=favoriteService.deleteAllFavorite(userId);
		//购物车map
		 Map<Commodity,Integer> favoritemap=(Map<Commodity, Integer>) request.getSession().getAttribute("favoritemap");
		 if(result==true){
		 favoritemap.clear();
		 }
	     request.setAttribute("favoritemap", favoritemap);
		 return "deleteAllFavorite";
	 }
	public Commodity getCommodity() {
		return commodity;
	}


	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public FavoriteService getFavoriteService() {
		return favoriteService;
	}
	public void setFavoriteService(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	public Favorite getFavorite() {
		return favorite;
	}
	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}


//	public Favorite getFavorite() {
//		return favorite;
//	}
//
//
//	public void setFavorite(Favorite favorite) {
//		this.favorite = favorite;
//	}
	 
}
