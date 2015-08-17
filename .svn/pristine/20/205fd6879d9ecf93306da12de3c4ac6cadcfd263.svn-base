package com.jixie.action.users;

import java.io.File;
import java.util.List;

import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.bean.FileSource;
import com.jixie.bean.UsersInfo;
import com.jixie.bean.Users;
import com.jixie.service.users.UsersService;
import com.opensymphony.xwork2.ActionContext;

public class PicUploadAction extends BaseAction {
	
	private String[] filesFileName;
	private File[] files;
	FileSource fs=null;
	UsersService usersService;
	/**
	 * 上传图片
	 */
	public String picUpload() throws Exception{
		
		Users users=UsersHelper.getInstance().getUsersFromSession();
		UsersInfo ui=UsersHelper.getInstance().getUsersInfoByU(commonService);
		List<FileSource> li=null;
		try{
			li=new UploadHelper().uploadMultipleFile(files, filesFileName, "usersPicture");
			fs=li.get(0);
			ui.setPictureId(users.getId());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			usersService.saveOrUpdateUfFile(ui, fs);
			ActionContext.getContext().getValueStack().push(fs);
			System.out.println("fs的id："+fs.getFileName());
			//ActionContext.getContext().getValueStack().push(fs);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "userinfomain";
	}




	public File[] getFiles() {
		return files;
	}



	public FileSource getFs() {
		return fs;
	}




	public void setFiles(File[] files) {
		this.files = files;
	}




	public void setFs(FileSource fs) {
		this.fs = fs;
	}



	public UsersService getUserService() {
		return usersService;
	}



	public void setUserService(UsersService usersService) {
		this.usersService = usersService;
	}




	public String[] getFilesFileName() {
		return filesFileName;
	}




	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}

}
