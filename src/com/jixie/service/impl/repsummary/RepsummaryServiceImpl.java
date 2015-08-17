package com.jixie.service.impl.repsummary;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.Repsummary;
import com.jixie.service.repsummary.RepsummaryService;

public class RepsummaryServiceImpl extends BaseService implements RepsummaryService{
	

	
	public void deleteRepsummary(Repsummary r) {
		commonDao.delete(r);
		
	}

	
	public void saveOrUpdateRepsummary(Repsummary r) {
		commonDao.save(r);
		
	}

	
	public void saveRepsummary(Repsummary r) {
		commonDao.save(r);
		
	}


}
