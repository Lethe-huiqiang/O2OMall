package com.jixie.service.commodity;

import java.util.List;

import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.bean.Suppliers;

/**
 * 注册事务
 * 
 */

public interface CommodityService {
     
	
	
	/**
	 * 保存商品信息，上传商品图片
	 * @param cod
	 * @param FileSource
	 */
	public void  saveOrUpdateComdFile(Commodity comd, FileSource fs);
	
	
	/**
	 * 
	 * 根据ID查找商品
	 * 
	 */
	public List<Commodity>  findCommodityByID(Commodity comodity,String sql);
	  
    /**
     * 根据关键字
     * compass搜索引擎搜索
     *
     */
	public List searchCommoditys(String queryString); 
}
