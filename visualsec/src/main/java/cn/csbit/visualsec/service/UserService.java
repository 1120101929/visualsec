package cn.csbit.visualsec.service;

import cn.csbit.visualsec.model.User;

public interface UserService {

	/**
	 * 登录验证
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User getUser(String username, String password, Integer role);

}