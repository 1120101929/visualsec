package cn.csbit.visualsec.dao;

import cn.csbit.visualsec.model.User;

public interface UserDao {

	/**
	 * 根据用户名和密码，获取User对象
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User getUser(String username, String password, Integer role);

}