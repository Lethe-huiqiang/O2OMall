package com.jixie.service.impl.commodityManage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gzbugu.common.commonDao.impl.CommonDaoImpl;
import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.Suppliers;
import com.jixie.service.commodityManage.CommodityManageService;
import com.jixie.utils.MallManageUtil;

public class CommodityManageServiceImpl extends BaseService implements CommodityManageService{


	
	public List displayCommodityList(EasyUIPageModel pageModel,Commodity commodity) {
//			StringBuffer sb=new StringBuffer("select * from commodity");
//			if(pageModel!=null){
//				sb.append(" limit "+pageModel.getStart()+","+pageModel.getRows());					
//			}	
			
		//String sql="from Commodity c where c.state = ? order by c.salesvolume";
		//String hql="from commodity limit ?,?";
//		
		StringBuffer sql=new StringBuffer("from Commodity c");
		if(MallManageUtil.isNotEmpty(commodity.getName())){
			 sql.append(" and c.name like '%"+commodity.getName()+"%'");
		}
		//return commonDao.findLimiteListByNativeSQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows());
		return commonDao.findLimiteListByHQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows());
	
	}
	/**
	 * 获取商品表总记录数
	 */
	public  int commodityCount(Commodity commodity){
		StringBuffer sql=new StringBuffer("select count(*) as total from commodity");
		if(MallManageUtil.isNotEmpty(commodity.getName())){
			 sql.append(" and name like '%"+commodity.getName()+"%'");
		}
		Object result= commonDao.entityNativeSQL(sql.toString().replaceFirst("and", "where"));
		int total=Integer.parseInt(result.toString());
		return total;
	}
	
	
	/**	 
	 * 
	 * 删除商品方法，可批量删除
	 * 
	 */
	public void deleteCommodity(String[] Ids,Suppliers sup) {
		//String sql="delete from commodity where ID in("+delCommodityNames+")";
		//Object result=commonDao.entityNativeSQL(sql);
//		String hql="delete Commodity c where c.name in("+ids+")";
//		Object result=commonDao.entityHQL(hql);
//		System.out.println(result);
//		int deltotal=Integer.parseInt(result.toString());
//		return deltotal;
		List list =new ArrayList();
		for(int i=0;i<Ids.length;i++){		
			Commodity commodity=commonDao.findById(Ids[i], new Commodity());
			list.add(commodity);
		}
		commonDao.deleteBacth(list);
	}

	
	
}
