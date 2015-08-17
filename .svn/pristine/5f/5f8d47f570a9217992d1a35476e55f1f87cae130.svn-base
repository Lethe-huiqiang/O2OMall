package com.jixie.action.mall;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


import com.jixie.action.BaseAction;
import com.jixie.action.UploadHelper;
import com.jixie.bean.FileSource;
import com.jixie.bean.Suppliers;
import com.jixie.service.suppliers.SuppliersService;
import com.jixie.system.thread.Utils;

public class SuppliersAction extends BaseAction {

	 private Suppliers sup;  //商家实体
	 private File[] suppliersPicture;  //上传的图片
	 private String[] suppliersPictureFileName;  //上传的图片名
	 
	 private SuppliersService suppliersService;



	/**
	 * 添加合作商家信息
	 * 
	 */
	
	public String addSuppliers(){
		
		FileSource fileSource = new FileSource();
		
		String suppliersId=Utils.getUUID();
		String logoId=Utils.getUUID();
		Timestamp creTime=Utils.date2Stamp(new Date());
		
		sup.setId(suppliersId);
		sup.setCreateTime(creTime);
		sup.setUpdateTime(creTime);
		sup.setState(1);
		sup.setLogoId(logoId);
		
		
		//储存商家logo图片
		try{
			List<FileSource> list=UploadHelper.getInstance().uploadMultipleFile(suppliersPicture, suppliersPictureFileName, "mall/suppliersPicture/");
			 
			if(list.size()>0){
				fileSource.setId(Utils.getUUID());
				fileSource.setFileName(((FileSource)(list.get(0))).getFileName());
				fileSource.setExtendName(((FileSource)(list.get(0))).getExtendName());				
				fileSource.setPath(((FileSource)(list.get(0))).getPath());
				fileSource.setSize(((FileSource)(list.get(0))).getSize());
				fileSource.setUpdateTime(creTime);
				
				suppliersService.saveOrUpdateSupInfo(sup, fileSource);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "addSupSUCCESS";
		
	}
	

	public Suppliers getSup() {
		return sup;
	}

	public void setSup(Suppliers sup) {
		this.sup = sup;
	}

	public File[] getSuppliersPicture() {
		return suppliersPicture;
	}

	public void setSuppliersPicture(File[] suppliersPicture) {
		this.suppliersPicture = suppliersPicture;
	}

	public String[] getSuppliersPictureFileName() {
		return suppliersPictureFileName;
	}

	public void setSuppliersPictureFileName(String[] suppliersPictureFileName) {
		this.suppliersPictureFileName = suppliersPictureFileName;
	}

	public SuppliersService getSuppliersService() {
		return suppliersService;
	}


	public void setSuppliersService(SuppliersService suppliersService) {
		this.suppliersService = suppliersService;
	}
}
