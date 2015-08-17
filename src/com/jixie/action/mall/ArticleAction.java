package com.jixie.action.mall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.bean.MallArticle;

public class ArticleAction extends BaseAction {
	
	private MallArticle article;
	
	/**
	 * 查询文章列表
	 */
	public String showArticleList(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String articleType=request.getParameter("articleType");
		int type=Integer.parseInt(articleType);
		String sql = "from MallArticle m where m.type = ? order by m.createTime DESC";
		List<MallArticle> articleList = commonService.findListByHQL(sql, type);
		
		 request.setAttribute("articleList", articleList);
		 return "articleList";
	}
	/**
	 * 查看文章详细内容
	 * 
	 */
	public String showArticleContent(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String articleId=request.getParameter("articleId");
		MallArticle article=commonService.findById(articleId, new MallArticle());
		request.setAttribute("article", article);
		return "articleContent";
	}
	public MallArticle getArticle() {
		return article;
	}

	public void setArticle(MallArticle article) {
		this.article = article;
	}
	
}
