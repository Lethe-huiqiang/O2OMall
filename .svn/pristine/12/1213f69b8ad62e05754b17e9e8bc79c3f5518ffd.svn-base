package com.jixie.service.articleManage;

import java.util.List;

import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.FileSource;
import com.jixie.bean.MallArticle;


public interface ArticleManageService {
	
	/**
	 * 保存或更新文章
	 * 
	 */
	public void  saveOrUpdateArticle(MallArticle article);
	
	 public List displayArticleList(EasyUIPageModel pageModel,MallArticle article);
		/**
		 * 获取商品表总记录数
		 */
		public int articleCount(MallArticle article);
		
		/**
		 * 删除商品，可批量删除
		 */
		public void deleteArticle(String[] Ids);
}
