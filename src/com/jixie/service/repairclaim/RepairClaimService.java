package com.jixie.service.repairclaim;


import com.jixie.bean.RepairClaim;



public interface RepairClaimService {
	
	/**
	 * 登记事务
	 */
	public void saveRepairClaim(RepairClaim r);
	
	//验证失败时，删除已注册账号信息
	public void deleteRepairClaim(RepairClaim r);
	
	
	public void saveOrUpdateRepairClaim(RepairClaim r);
	

}
