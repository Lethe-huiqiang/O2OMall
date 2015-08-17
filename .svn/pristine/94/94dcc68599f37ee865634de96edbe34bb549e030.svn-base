package com.jixie.service.impl.articleManage;

import java.util.ArrayList;
import java.util.List;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Commodity;
import com.jixie.bean.EasyUIPageModel;
import com.jixie.bean.MallArticle;
import com.jixie.service.articleManage.ArticleManageService;
import com.jixie.utils.MallManageUtil;

public class ArticleManageServiceImpl	extends BaseService implements ArticleManageService{
	
	/**
	 * 文章总数
	 * 
	 */
	public int articleCount(MallArticle article) {
		StringBuffer sql=new StringBuffer("select count(*) as total from mall_article");
		if(MallManageUtil.isNotEmpty(article.getName())){
			 sql.append(" and name like '%"+article.getName()+"%'");
		}
		Object result= commonDao.entityNativeSQL(sql.toString().replaceFirst("and", "where"));
		int total=Integer.parseInt(result.toString());
		return total;
	}
	
	/**
	 * 删除文章，可批量
	 * 
	 */
	public void deleteArticle(String[] Ids) {
		List list =new ArrayList();
		for(int i=0;i<Ids.length;i++){		
			MallArticle article=commonDao.findById(Ids[i], new MallArticle());
			list.add(article);
		}
		commonDao.deleteBacth(list);
	}
	
	/**
	 * 查询文章，存于list中
	 */
	public List displayArticleList(EasyUIPageModel pageModel,
			MallArticle article) {
		StringBuffer sql=new StringBuffer("from MallArticle m");
		if(MallManageUtil.isNotEmpty(article.getName())){
			 sql.append(" and m.name like '%"+article.getName()+"%'");
		}
		//return commonDao.findLimiteListByNativeSQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows());
		return commonDao.findLimiteListByHQL(sql.toString().replaceFirst("and", "where"),pageModel.getStart()+1, pageModel.getRows());
	}
	/**
	 * 保存或更新文章
	 */
	public void saveOrUpdateArticle(MallArticle article) {
		commonDao.saveOrUpdate(article);
	}

}
