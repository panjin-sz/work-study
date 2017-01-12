package com.panjin.design.create.factory.abstract2.dao.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.create.factory.abstract2.bean.User;

public class PostgreSQLUserDao implements IUserDao {

	private static final Logger LOG = LoggerFactory.getLogger(PostgreSQLUserDao.class);

	@Override
	public void addUser(User user) {
		LOG.info("PostgreSQL added User {}", user);
	}

	@Override
	public void removeUser(User user) {
		LOG.info("PostgreSQL removed User {}", user);
	}

	@Override
	public User getUser(String username) {
		User user = new User();
		user.setUsername(username);
		return user;
	}

}
