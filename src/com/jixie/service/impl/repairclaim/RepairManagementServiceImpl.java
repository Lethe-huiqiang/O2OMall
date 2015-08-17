package com.jixie.service.impl.repairclaim;

import com.gzbugu.common.commonService.BaseService;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.RepairManagement;
import com.jixie.service.repairclaim.RepairClaimService;
import com.jixie.service.repairclaim.RepairManagementService;

public class RepairManagementServiceImpl extends BaseService implements RepairManagementService{
	
	public void saveRepairManagement(RepairManagement r) {
		commonDao.save(r);

	}
	
	public void saveOrUpdateRepairManagement(RepairManagement r) {
		commonDao.save(r);

	}

	public void deleteRepairManagement(RepairManagement r) {
		commonDao.delete(r);

	}

}
