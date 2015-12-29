package cn.csbit.visualsec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import cn.csbit.visualsec.dao.UserDao;
import cn.csbit.visualsec.model.User;
import cn.csbit.visualsec.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User getUser(String username, String password, Integer role) {
		return this.userDao.getUser(username, DigestUtils.md5DigestAsHex(password.getBytes()), role);
	}
}
