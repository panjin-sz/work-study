package com.panjin.design.create.factory.abstract2.dao.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.create.factory.abstract2.bean.User;

public class MySQLUserDao implements IUserDao {

	private static final Logger LOG = LoggerFactory.getLogger(MySQLUserDao.class);

	@Override
	public void addUser(User user) {
		LOG.info("MySQL added User {}", user);
	}

	@Override
	public void removeUser(User user) {
		LOG.info("MySQL removed User {}", user);
	}

	@Override
	public User getUser(String username) {
		User user = new User();
		user.setUsername(username);
		return user;
	}

}
