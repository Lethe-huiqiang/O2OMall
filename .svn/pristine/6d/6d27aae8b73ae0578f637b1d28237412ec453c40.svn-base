package com.jixie.service.impl.shoppingcart;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Users;
import com.jixie.service.shoppingcart.ShoppingCartService;

public class ShoppingCartServiceImpl extends BaseService  implements ShoppingCartService{
	/**
	 *根据商品ID删除购物车表中相应记录 
	 * 
	 */
	
	public boolean deleteShoppingCart(String id) {
		 String hql="delete from ShoppingCart s where s.commodityId=?";
		 boolean result=commonDao.executeHQL(hql, id);
		 return result;
	}

	/**
	 *根据商品ID查找并修改购物车表记录 
	 * @return 
	 * 
	 */
	
	public boolean updateShoppingCart(String id ,int buynum) {
		 String hql="update ShoppingCart s set s.count=? where s.commodityId=?";
		 boolean result =commonDao.executeHQL(hql,buynum,id);
		 return result;
	}

	/**清空购物车信息
	 * 根据用户ID查找并删除其所有购物车表相应记录
	 */
	
	public boolean deleteAllShoppingCart(String userId) {
		String hql="delete from ShoppingCart s where s.usersId=? ";
		 boolean result =commonDao.executeHQL(hql,userId);
		return result;
	}
	
	
	

}
