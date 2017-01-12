package com.panjin.design.create.factory.abstract2.dao.user;

import com.panjin.design.create.factory.abstract2.bean.User;

public interface IUserDao {
	
	void addUser(User user);
	void removeUser(User user);
	User getUser(String username);

}
