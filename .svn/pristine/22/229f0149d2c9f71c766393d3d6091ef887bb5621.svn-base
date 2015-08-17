package com.jixie.action.mall;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.FileSource;
import com.jixie.bean.MallArticle;
import com.jixie.service.articleManage.ArticleManageService;
import com.jixie.utils.MallManageUtil;
import com.jixie.utils.Utils;

public class ArticleManageAction extends BaseAction{
		
	private ArticleManageService articleManageService;
	private MallArticle article;
	
	/**
	 * 新增或修改文章
	 * 
	 * @author huiq
	 * @throws Exception 
	 * 
	 */
	
	public void addArticle() throws Exception {
		
		Timestamp creTime = Utils.date2Stamp(new Date());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String id=request.getParameter("id");
		JSONObject result=new JSONObject();	// 返回前台的json数据信息
		
		article.setCreateTime(creTime);
		article.setUpdateTime(creTime);
			//	如果没有参数ID传过来，即id为空，则为新增商品，否则为更新商品，不需重新set ID值
			if(MallManageUtil.isEmpty(id)){
				String articleId = Utils.getUUID();
				article.setId(articleId);				
				articleManageService.saveOrUpdateArticle(article);
				result.put("success", "true");
			} else if(MallManageUtil.isNotEmpty(id)){
				article.setId(id);					
				articleManageService.saveOrUpdateArticle(article);
				result.put("success", "true");			
			}
			MallManageUtil.write(response, result);
		
	}
	/**
	 * 
	 * 显示文章列表
	 */
	public void displayArticleList(){
		MallArticle mallArticle=new MallArticle();
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String page=request.getParameter("page");//页码
		String rows=request.getParameter("rows");//每页记录数
		String searchName=request.getParameter("searchname");//搜索key
		if(searchName==null){
			searchName="";
		}
		mallArticle.setName(searchName);
		EasyUIPageModel pageModel=new EasyUIPageModel(Integer.parseInt(page),Integer.parseInt(rows));
		JSONArray jsonArray = null;
		try {
			JSONObject result=new JSONObject();
			int total=articleManageService.articleCount(mallArticle);//总记录数
			//转换成json数组
			jsonArray = MallManageUtil.formatListToJsonArray(articleManageService.displayArticleList(pageModel,mallArticle));
			result.put("rows", jsonArray);
			result.put("total", total);
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ArticleManageService getArticleManageService() {
		return articleManageService;
	}

	public void setArticleManageService(ArticleManageService articleManageService) {
		this.articleManageService = articleManageService;
	}
	public MallArticle getArticle() {
		return article;
	}
	public void setArticle(MallArticle article) {
		this.article = article;
	}
	
}
