package com.jixie.action.mall;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.FileSource;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.service.users.UsersService;
import com.jixie.utils.MallManageUtil;
import com.jixie.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class UserCenterAction extends BaseAction{
	
	private File[] usersPicture;// 上传的图片
	private String[] usersPictureFileName;// 上传的图片的文件名
	private UsersInfo usersInfo;
	private UsersService usersService;
	public void showUserInfo(){
		 HttpServletResponse response=ServletActionContext.getResponse();
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String path = request.getContextPath();
		 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		try {
			Users users = UsersHelper.getUsersFromSession();
			if (users != null) {	
				UsersInfo usersInfo = commonService.findById(users.getId(), new UsersInfo());
				String pictureId=usersInfo.getPictureId();
				JSONObject result=new JSONObject();
			if(pictureId!=null){
				FileSource fs = commonService.findById(pictureId, new FileSource());
				usersInfo.setFileSource(fs);
				}
				JSONObject usersInfoJson = JSONObject.fromObject(usersInfo);//将java对象转换为json对象 
				
					
					//转换成json数组
					result.put("usersInfo", usersInfoJson);
					MallManageUtil.write(response, result);
				
			} else if(users==null){//跳到登录页
				response.sendRedirect("/webjixie/frontStage/users/jsp/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//				String pictureId=usersInfo.getPictureId();
//				JSONObject result=new JSONObject();
//				String picId = "d09b5ec6872b400e0ba0d7431cc06c1b";
//				if(pictureId.equals(picId)){
//					FileSource defaultPc=new FileSource();
//					defaultPc.setId(picId);
//					defaultPc.setSize(204537);
//					defaultPc.setExtendName(".png");
//					defaultPc.setFileName("userDefaultImage");
//					defaultPc.setPath("fileSource/userDefaultImage.png");
//					defaultPc.setUpdateTime(Utils.date2Stamp(new Date()));
//					commonService.save(defaultPc);
//					usersInfo.setPictureId(defaultPc.getId());
//					commonService.update(usersInfo);
//					usersInfo.setFileSource(defaultPc);
//					JSONObject usersInfoJson = JSONObject.fromObject(usersInfo);//将java对象转换为json对象 
//					result.put("usersInfo", usersInfoJson);
//					MallManageUtil.write(response, result);
//				}else {}
				
		
		
	}
	
	public void updateUsersInfo() throws IOException{
		HttpServletRequest request=ServletActionContext.getRequest();
		 HttpServletResponse response=ServletActionContext.getResponse();
		
		Users users = UsersHelper.getUsersFromSession();
		try {
			ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}	
		
		if (usersInfo != null) {
			// 记录更新时间
			usersInfo.setUpdateTime(Utils.getCurrentTimestamp());
		try {
			FileSource fs = new FileSource();
			String fsPath = "";
			if(usersPicture!=null){
				List<FileSource> list = UploadHelper.getInstance().uploadMultipleFile(usersPicture, usersPictureFileName, "/usersPicture/");
				if(list.size()>0){
					fs = list.get(0);
					usersInfo.setPictureId(fs.getId());
					fsPath = fs.getPath();
					usersInfo.setFileSource(fs);
					usersInfo.setGrade(0);
					usersInfo.setEmail(users.getEmail());
					usersInfo.setStatus(users.getStatus());
				}
				commonService.update(usersInfo);
				commonService.save(fs);
			}else{
				commonService.saveOrUpdate(usersInfo);
				}
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		response.sendRedirect("/webjixie/frontStage/JixieMall/person_page/person_page.jsp?request=userCenter");
		
		}

	}
	public File[] getUsersPicture() {
		return usersPicture;
	}

	public void setUsersPicture(File[] usersPicture) {
		this.usersPicture = usersPicture;
	}

	public String[] getUsersPictureFileName() {
		return usersPictureFileName;
	}

	public void setUsersPictureFileName(String[] usersPictureFileName) {
		this.usersPictureFileName = usersPictureFileName;
	}

	public UsersInfo getUsersInfo() {
		return usersInfo;
	}

	public void setUsersInfo(UsersInfo usersInfo) {
		this.usersInfo = usersInfo;
	}

	
	}