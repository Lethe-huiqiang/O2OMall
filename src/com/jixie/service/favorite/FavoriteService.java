package com.jixie.service.favorite;

public interface FavoriteService  {
	/**
	 *根据商品ID删除favorite表中相应记录 
	 * 
	 */
	public boolean deleteFavorite(String id);
	
	/**清空购物车信息
	 * 根据用户ID查找并删除其所有购物车表相应记录
	 */	
	public boolean deleteAllFavorite(String userId);

}
