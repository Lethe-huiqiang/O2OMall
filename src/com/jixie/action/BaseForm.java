package com.jixie.action;

import java.util.Date;
import com.jixie.utils.Utils;

//所有form表单需要继承的类
public class BaseForm {
	//当前第几页，默认第一页
	private int currentPage = 1 ;
	//每页显示的个数
	private int pageSize = 25 ;
	
	protected Date getDefaultDate(int part, int offset) {
        Date d = new Date();
        if (offset != 0)
            d = Utils.add(d, part, offset);

        return Utils.get(d, "GMT+8");
    }
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}	
	
}
