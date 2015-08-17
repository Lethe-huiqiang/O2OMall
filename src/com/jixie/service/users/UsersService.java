package com.jixie.service.users;

/*import com.jixie.action.test.TestA;
import com.jixie.action.test.TestB;*/
import com.jixie.bean.Activation;
import com.jixie.bean.FileSource;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;

/**
 * 注册事务
 * @author iis
 *
 */
public interface UsersService {

	/**
	 * 注册事务
	 */
	public void saveUsersorUsersInfo(Users u,UsersInfo ui,Activation activation);
	
	//验证失败时，删除已注册账号信息
	public void deleteUsers(Users u, UsersInfo ui);

	/**
	 * 上传图片
	 * @param ui
	 * @param fs
	 */
	public void saveOrUpdateUfFile(UsersInfo ui, FileSource fs);
	
	/**
	 * test for saveing two reference class
	 */
/*	public void saveTestATestB(TestA testa,TestB testb);*/
}
