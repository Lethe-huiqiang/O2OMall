package com.jixie.action.mall;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gzbugu.common.query.PageModel;
import com.jixie.action.BaseAction;
import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.service.commodity.CommodityService;

public class CommoditySearchAction extends BaseAction {

	
	private Commodity commodity; // 商品实体
	private File[] commodityPicture;// 上传的图片
	private String[] commodityPictureFileName;// 上传的图片的文件名
	private CommodityService commodityService;
	//private String queryString;
	/**
	 * 显示单个商品详情
	 * 
	 * 
	 **/
	public String commodityDetail(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		if(id!=null){
		commodity=commonService.findById(id, new Commodity());		
		FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
		commodity.setFileSource(fileSource);
		
		request.setAttribute("commodity", commodity);
		request.setAttribute("fileSource", fileSource);
		
		}
		
		return "commoditydetail";
	}
   /**
    * 根据类目或品牌搜索商品
    * 
    * 
    */
	public String searchByBrandOrCategory(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String[] searchCategory = { "phone", "Udisk", "keyboard", "notebook","mouse", "mo" };//搜索类目名
		List<String> categoryList = Arrays.asList(searchCategory);//将类目数组转换成List
		int currentPage=Integer.parseInt(request.getParameter("currentPage")); //搜索结果页码	
		String searchCondition=request.getParameter("searchCondition");  //搜索关键字
		//解决get方式提交的品牌参数中文乱码
		try {
			searchCondition = new String(searchCondition.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PageModel pm = new PageModel();
		pm.setPageSize(8);
		pm.setCurrentPage(currentPage);
		PageModel pageModel=new PageModel();
		
	if(searchCondition.equals("all")){
		 String categoryHql = "from Commodity c  order by c.salesvolume";
			
	       pageModel = commonService.findPageByHQL(categoryHql, pm);	
	}else if(categoryList.contains(searchCondition)){//如果查询条件是类目名
		
		 String categoryHql = "from Commodity c where c.category= ? order by c.salesvolume";
			
	       pageModel = commonService.findPageByHQL(categoryHql, pm, searchCondition);	
		
		
	         }else{//查询条件不在类目名数组内，则都按品牌查询
	        	
	        	String brandHql = "from Commodity c where c.brand= ? order by c.salesvolume";
	     		
	     		pageModel = commonService.findPageByHQL(brandHql, pm, searchCondition);	
		
		}
		if(pageModel.getList().size()>0){
			for (int i = 0; i < pageModel.getList().size(); i++) {
			Commodity commodity = (Commodity) pageModel.getList().get(i);
				FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
				commodity.setFileSource(fileSource);

			}
		}
		
		request.setAttribute("searchCondition", searchCondition);		
		request.setAttribute("pm", pm);
		request.setAttribute("pageModel", pageModel);
		return "searchResult";
	  }
   /**
    * 站内搜索引擎搜索
    * 
    */
	
	public String search(){  
		HttpServletRequest request = ServletActionContext.getRequest();
		String queryString=request.getParameter("queryString");
		//查询商品表所以商品
        List<Commodity> results=commodityService.searchCommoditys(queryString);  
        System.out.println(results.size());  
        request.setAttribute("searchresults", results);
        
        return "search";  
    }  
	/**
	 * 
	 * 根据类目搜索商品
	 * 
	 */
/*	public String searchByCategory(){
		HttpServletRequest request= ServletActionContext.getRequest();
		int currentPage=Integer.parseInt(request.getParameter("currentPage")); //搜索结果页码
		String category=request.getParameter("category");  //商品类型
		PageModel pm = new PageModel();
		pm.setPageSize(5);
		pm.setCurrentPage(currentPage);
		
		String hql = "from Commodity c where c.category= ? order by c.salesvolume";
		
		PageModel pageModel = commonService.findPageByHQL(hql, pm, category);	

		if(pageModel.getList().size()>0){
			for (int i = 0; i < pageModel.getList().size(); i++) {
			Commodity commodity = (Commodity) pageModel.getList().get(i);
				FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
				commodity.setFileSource(fileSource);

			}
		}
		request.setAttribute("category", category);	
		request.setAttribute("pm", pm);
		request.setAttribute("pageModel", pageModel);
		return "searchResult";
	}*/
//public String getQueryString() {
//	return queryString;
//}
//public void setQueryString(String queryString) {
//	this.queryString = queryString;
//}
public CommodityService getCommodityService() {
	return commodityService;
}
public void setCommodityService(CommodityService commodityService) {
	this.commodityService = commodityService;
}
public Commodity getCommodity() {
	return commodity;
}
public void setCommodity(Commodity commodity) {
	this.commodity = commodity;
}
public File[] getCommodityPicture() {
	return commodityPicture;
}
public void setCommodityPicture(File[] commodityPicture) {
	this.commodityPicture = commodityPicture;
}
public String[] getCommodityPictureFileName() {
	return commodityPictureFileName;
}
public void setCommodityPictureFileName(String[] commodityPictureFileName) {
	this.commodityPictureFileName = commodityPictureFileName;
}
}
