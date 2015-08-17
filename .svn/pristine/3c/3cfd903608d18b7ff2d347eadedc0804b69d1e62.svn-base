package com.jixie.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jixie.bean.FileSource;
import com.jixie.system.thread.Utils;


public class UploadHelper {
	
	private static UploadHelper instance ;
	private static final Object obj = new  Object();
	
	/**
	 * 单例模式
	 * @return
	 */
	public static UploadHelper getInstance(){
		if(instance==null){
			synchronized (obj) {
				if(instance==null){
					instance = new UploadHelper();
				}
			}
		}
		return instance;
	}
	
	/**
	 * 实现文件上传功能（包括单文件多文件）
	 * 
	 * @param filepath
	 *            -所有文件的路径
	 * 
	 * @return List<FileFields> -返回文件所有信息集
	 */
	public List<FileSource> uploadMultipleFile(List<File> file) {

		if (file == null || file.size() == 0) {
			return null;
		}
		List<FileSource> list = new ArrayList<FileSource>();
		FileSource ff = new FileSource();
		File fileNew;
		String extName;
		String uploadFilename;
		int pos;
		String root;
		int size = file.size();
		try {
			for (int i = 0; i < size; i++) {
				fileNew = file.get(i);
				String uuid = UUID.randomUUID().toString().replace("-", "");
				InputStream is = new FileInputStream(fileNew);
				pos = fileNew.getAbsolutePath().lastIndexOf(".");
				extName = fileNew.getAbsolutePath().substring(pos).toLowerCase();
				uploadFilename = uuid + extName;
				root = ServletActionContext.getServletContext().getRealPath(
						"fileSources\\upload\\"
								+ fileNew.getAbsolutePath().substring(pos + 1)
										.toLowerCase());
				File app = new File(root);
				if (!app.exists()) {
					boolean b = app.mkdirs();
				}

				File dest = new File(root, uploadFilename);

				OutputStream os;
				os = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int len = 0;
				int total = 0;
				while ((len = is.read(buffer)) > 0) {
					total += len;
					os.write(buffer, 0, len);
				}
				is.close();
				os.close();
				String id = UUID.randomUUID().toString().replace("-", "");
				ff.setId(id);
				ff.setExtendName(extName);
				ff.setFileName(uploadFilename);
				ff.setPath(root);
				ff.setSize(total);//String.valueOf(
				list.add(ff);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 文件上传功能，可以上传多个或者单个文件
	 * 
	 * @param files 
	 * 				- 要上传文件的文件对象数组
	 * @param fileNames	
	 * 			    - 要上传文件的文件名
	 * @param uploadFolderName
	 * 				- 要上传文件的最终目录
	 * 
	 * @return List<FileFields> -返回文件所有信息集
	 */
	public List<FileSource> uploadMultipleFile(File[] files, String[] fileNames, String uploadFolderName) {
		
		if (files == null || files.length == 0 
				|| fileNames == null || fileNames.length == 0 ) {
			return null;
		}
		
		List<FileSource> fsList = new ArrayList<FileSource>();
		File newFile = null;
		
		int len = files.length;
		
		try {
			
			for(int i = 0; i < len; i++){
				String extendName = fileNames[i].substring(fileNames[i].lastIndexOf(".")).toLowerCase(); // 得到拓展名
				String uuid = UUID.randomUUID().toString().replace("-", "");
				newFile = files[i];
				InputStream is = new FileInputStream(newFile);
				// 定义上传的文件的保存目录
				String relativePath = "fileSource/" + uploadFolderName;
				String realPath = ServletActionContext.getServletContext().getRealPath(relativePath);
				
				// 如果上传文件的目录不存在，则创建一个
				File f = new File(realPath);
				if(!f.exists()){
					f.mkdirs();
				}
				System.out.println(realPath);
				// 定义最终文件, 最后保存文件到服务器中时，文件的名字：FileSources.getId()+FileSources.getFileName();
				// 
//				File dest = new File(f, uuid + fileNames[i]);
				File dest = new File(f, uuid+extendName);
				
				// 写出文件
				OutputStream os = new FileOutputStream(dest);
				byte[] buffer = new byte[1024];
				int l = 0;
				int total = 0;
				while ((l = is.read(buffer)) > 0) {
					total += l;
					os.write(buffer, 0, l);
				}

				is.close();
				os.close();
				
				// 封装FileSources对象
				FileSource fs = new FileSource();
				
				fs.setId(uuid);
//				String extendName = fileNames[i].substring(fileNames[i].lastIndexOf(".")).toLowerCase(); // 得到拓展名
				fs.setExtendName(extendName);
				fs.setFileName(fileNames[i]);
				fs.setPath(relativePath + "/" + uuid + extendName);
				fs.setSize((total));//String.valueOf
				fs.setUpdateTime(Utils.getCurrentTimestamp());
				fsList.add(fs);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fsList;
	}

}
