package com.jixie.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jixie.bean.FileSource;



/**
 * 此类主要用于下载文件，主要使用的是downloadFile以及downloadFile1方法实现
 * @author 
 * @see 需要继承BaseAction类，调用其中相应的的commonService对象
 * */
public class DownloadAction extends BaseAction {
	
	/**文件后缀名*/
	private String fileFileName;
	/**文件的id，用于查找文章对应的文件*/
	private String fileId;
	/**所有的文件的文件名*/
	private String filePath;
	
	public String downloadFile(){
		FileSource s ;
		try{
			s = (FileSource)commonService.findById(fileId, new FileSource());
			filePath = s.getPath();
			fileFileName = s.getFileName();
//			InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/"+filePath);
//			if(null == is){
//				Exception e = new Exception();
//				throw e;
//			}
//			/**文件下载*/
//			else{
//				HttpServletResponse response = ServletActionContext.getResponse();
//				response.setContentType("application/x-msdownload"); 
//		        response.setHeader("Content-Disposition", "attachment;fileName="
//		                           + java.net.URLEncoder.encode(fileFileName,"UTF-8"));
				return SUCCESS;
//			}
		}catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public InputStream getFileStream()
	{
		return ServletActionContext.getServletContext().getResourceAsStream("/"+filePath);
	}
//
//	public String getFileFileName() {
//		return fileFileName;
//	}
//
	public void setFileFileName(String fileFileName) {
		try {
			this.fileFileName = new String(fileFileName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getFileFileName() {
		return fileFileName;
	}
//	public void setFileFileName(String fileFileName) {
//		this.fileFileName = fileFileName;
//	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	

}
