package cn.csbit.visualsec.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.csbit.visualsec.dao.UserDao;
import cn.csbit.visualsec.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(String username, String password, Integer role) {
		this.sessionFactory.getCurrentSession();
		return null;
	}
}
