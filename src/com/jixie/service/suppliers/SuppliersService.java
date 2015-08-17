package com.jixie.service.suppliers;

import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.bean.Suppliers;

public interface SuppliersService {
   /**
    *保存合作商家信息或其经营商品 
    *
    */
	 public void saveSupplierInfoOrCommodity(Suppliers sup,Commodity comd);
	 
	 
	 /**
	  *保存或更新商家信息 
	  * 
	  */
	 
	 public  void saveOrUpdateSupInfo(Suppliers sup, FileSource fs);
	 
	 /**
	  *  更改合作状态并删除相关商品 
	  * 
	  * 
	  */
	  public  void updateStateAndDelectCommodity(Suppliers sup ,Commodity comd);
}
