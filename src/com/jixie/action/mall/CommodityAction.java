package com.jixie.action.mall;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.Commodity;
import com.jixie.bean.FileSource;
import com.jixie.service.commodity.CommodityService;
import com.jixie.utils.MallManageUtil;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class CommodityAction extends BaseAction {

	private Commodity commodity; // 商品实体
	private File[] commodityPicture;// 上传的图片
	private String[] commodityPictureFileName;// 上传的图片的文件名
	private CommodityService commodityService;
	HttpServletRequest request;
	ServletResponse response;

	/**
	 * 添加商品 跳转到商城首页
	 * 
	 * @author huiq
	 * 
	 */
	
	public void addCommodity() {
		FileSource fileSource = new FileSource();
		//String fspath = "";

		Timestamp creTime = Utils.date2Stamp(new Date());
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String id=request.getParameter("id");
		JSONObject result=new JSONObject();	// 返回前台的json数据信息
		// 储存上传的图片
		try {
			List<FileSource> list = UploadHelper.getInstance()
					.uploadMultipleFile(commodityPicture,
							commodityPictureFileName, "upload/mall/commodityPicture/");
				
				commodity.setCreateTime(creTime);
				commodity.setState(1);
				commodity.setSalesvolume(0);
				commodity.setUpdateTime(creTime);
			//	如果没有参数ID传过来，即id为空，则为新增商品，否则为更新商品，不需重新set ID值
			if(MallManageUtil.isEmpty(id)){
				String commondityId = Utils.getUUID();
				String fileId = Utils.getUUID();
				commodity.setId(commondityId);	
				commodity.setPicId(fileId);
				fileSource.setId(fileId);	
				fileSource.setFileName(((FileSource) (list.get(0)))
						.getFileName());
				fileSource.setExtendName(((FileSource) (list.get(0)))
						.getExtendName());
				fileSource.setPath(((FileSource) (list.get(0))).getPath());
				fileSource.setSize(((FileSource) (list.get(0))).getSize());
				fileSource.setUpdateTime(creTime);
				//fspath = fileSource.getPath();
				//commodity.setFileSource(fileSource);
				commodityService.saveOrUpdateComdFile(commodity, fileSource);
				result.put("success", "true");
			} 
			if(list!=null && MallManageUtil.isNotEmpty(id)){
				commodity.setId(id);	
				String fileId = Utils.getUUID();
				//commodity.setPicId(fileId);
				fileSource.setId(fileId);		
				fileSource.setFileName(((FileSource) (list.get(0)))
						.getFileName());
				fileSource.setExtendName(((FileSource) (list.get(0)))
						.getExtendName());
				fileSource.setPath(((FileSource) (list.get(0))).getPath());
				fileSource.setSize(((FileSource) (list.get(0))).getSize());
				fileSource.setUpdateTime(creTime);
				commodityService.saveOrUpdateComdFile(commodity, fileSource);
				result.put("success", "true");
				//fspath = fileSource.getPath();
				//commodity.setFileSource(fileSource);
			}else if(list==null){
				commodity.setId(id);
				commodityService.saveOrUpdateComdFile(commodity, fileSource);
				result.put("success", "true");
			}
			MallManageUtil.write(response, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 在首页生成商品列表
	 * 
	 */
	// ===============将商品回显到商城首页===================
	public String showCommodityList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		String[] categoryName = { "phone", "Udisk", "keyboard", "notebook","mouse", "mo" };
		List categoryList = new ArrayList();
		//List phoneList = new ArrayList();
		int k;
		int len = categoryName.length;

		try {
			for (k = 0; k < len; k++) {
				
				String sql = "from Commodity c where c.category = ? order by c.salesvolume";
				List<Commodity> list = commonService.findLimiteListByHQL(sql,1, 8, categoryName[k]);

				if (list.size() > 0) {
					

					for (int i = 0; i < list.size(); i++) {
						Commodity commodity = list.get(i);
						FileSource fileSource = commonService.findById(commodity.getPicId(), new FileSource());
						commodity.setFileSource(fileSource);

					}

				}
				categoryList.add(k, list);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		// 将查询到的所有商品信息存入request域带到页面显示
		request.setAttribute("commodity", commodity);
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> map = (Map<String, Object>) ctx.get("request");
		map.put("categoryList", categoryList);
		return "showTenCommodity";
	}



	public String addSuccess() {

		return SUCCESS;
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

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ServletResponse getResponse() {
		return response;
	}

	public void setResponse(ServletResponse response) {
		this.response = response;
	}
}
