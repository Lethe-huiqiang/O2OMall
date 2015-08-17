package com.jixie.service.impl.favorite;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.service.favorite.FavoriteService;

public class FavoriteServiceImpl extends BaseService implements FavoriteService {
	/**
	 *根据商品ID删除favorite表中相应记录 
	 * 
	 */
	
	public boolean deleteFavorite(String id) {
		 String hql="delete from Favorite f where f.commodityId=?";
		 boolean result=commonDao.executeHQL(hql, id);
		 return result;		
	}
	/**清空收藏夹信息
	 * 根据用户ID查找并删除其所有收藏夹表相应记录
	 */	
	
	public boolean deleteAllFavorite(String userId) {		
		String hql="delete from Favorite s where usersId=? ";
		 boolean result =commonDao.executeHQL(hql,userId);
		return result;
	}
}
