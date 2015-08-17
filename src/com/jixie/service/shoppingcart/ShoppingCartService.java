package com.jixie.service.shoppingcart;

import com.jixie.bean.Users;

public interface ShoppingCartService {
    
	
	/**
	 *根据商品ID删除购物车表中相应记录 
	 * 
	 */
	public boolean deleteShoppingCart(String id);
	
	
	/**
	 *根据商品ID查找并修改购物车表记录 
	 * 
	 */
	public boolean  updateShoppingCart(String id ,int buynum);
	
	/**清空购物车信息
	 * 根据用户ID查找并删除其所有购物车表相应记录
	 */
	public boolean  deleteAllShoppingCart(String userId);
}
