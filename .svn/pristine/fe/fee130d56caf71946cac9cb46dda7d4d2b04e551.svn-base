package com.jixie.service.commodityManage;

import java.sql.ResultSet;
import java.util.List;

import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.Suppliers;

public interface CommodityManageService {

	
    public List displayCommodityList(EasyUIPageModel pageModel,Commodity commodity);
	/**
	 * 获取商品表总记录数
	 */
	public int commodityCount(Commodity commodity);
	
	/**
	 * 删除商品，可批量删除
	 */
	public void deleteCommodity(String[] Ids,Suppliers sup);
}
