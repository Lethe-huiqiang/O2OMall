package com.jixie.service.impl.commodity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.compass.core.Compass;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTemplate;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.action.UploadHelper;
import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.bean.Suppliers;
import com.jixie.service.commodity.CommodityService;

public class CommodityServiceImpl extends BaseService implements CommodityService {
	@Resource CompassTemplate compassTemplate;
	//private CompassTemplate compassTemplate;
	
	
	/**	 
	 * 
	 * 上传或更新商品图片方法	
	 */
	public void saveOrUpdateComdFile(Commodity comd, FileSource fs) {
		commonDao.saveOrUpdate(comd);
		if(fs.getId()!=null){
		commonDao.saveOrUpdate(fs);
		}
	}
	/**
	 * 
	 * 
	 */
	
	public List<Commodity> findCommodityByID(Commodity comd,String sql) {
		return commonDao.findLimiteListByNativeSQL(sql, 1, 10, comd.getId());
		
	}
	/**
	 * @Override
     * 根据关键字
     * compass搜索引擎搜索
     */
	
	public List<Commodity> searchCommoditys(String queryString) {
		 Compass compass = compassTemplate.getCompass();  
	        CompassSession session=compass.openSession();  
	        List<Commodity> list = new ArrayList<Commodity>();  
	        //这里不需要开启事务了，因为在调用这个方法之前就已经开启了事务  
	        CompassHits hits= session.queryBuilder().queryString(queryString).toQuery().hits();  
	        System.out.println("queryString:"+queryString);  
	        System.out.println("hits:"+hits.getLength());  
	        for(int i=0;i<hits.length();i++){  
	            Commodity hit=(Commodity)hits.data(i);  
	            FileSource fileSource = commonDao.findById(hit.getPicId(), new FileSource());
	            hit.setFileSource(fileSource);
	            list.add(hit);  
	        }  
	          
	        return list;  
	}
	
	
	
	public CompassTemplate getCompassTemplate() {
		return compassTemplate;
	}
	public void setCompassTemplate(CompassTemplate compassTemplate) {
		this.compassTemplate = compassTemplate;
	}

}
