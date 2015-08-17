package com.jixie.service.impl.users;

import com.gzbugu.common.commonService.BaseService;
/*import com.jixie.action.test.TestA;
import com.jixie.action.test.TestB;*/
import com.jixie.bean.Activation;
import com.jixie.bean.FileSource;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.service.users.UsersService;

public class UsersServiceImpl extends BaseService implements UsersService{

	public void saveUsersorUsersInfo(Users u, UsersInfo ui,Activation activation) {
		commonDao.save(u);
		commonDao.save(ui);
		commonDao.save(activation);
		
	}

	public void saveOrUpdateUfFile(UsersInfo ui, FileSource fs) {
		commonDao.save(fs);
		commonDao.saveOrUpdate(ui);
	}

	public void deleteUsers(Users u, UsersInfo ui) {
		commonDao.delete(u);
		commonDao.delete(ui);
	}


/*	public void saveTestATestB(TestA testa, TestB testb) {
		commonDao.save(testa);
		commonDao.save(testb);
	}*/
}
