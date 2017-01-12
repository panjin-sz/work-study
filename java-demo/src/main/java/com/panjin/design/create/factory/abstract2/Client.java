package com.panjin.design.create.factory.abstract2;

import com.panjin.design.create.factory.abstract2.bean.Product;
import com.panjin.design.create.factory.abstract2.bean.User;
import com.panjin.design.create.factory.abstract2.dao.product.IProductDao;
import com.panjin.design.create.factory.abstract2.dao.role.IRoleDao;
import com.panjin.design.create.factory.abstract2.dao.user.IUserDao;
import com.panjin.design.create.factory.abstract2.factory.IDaoFactory;
import com.panjin.design.create.factory.abstract2.factory.MySQLDaoFactory;

public class Client {

	public static void main(String[] args) {
		IDaoFactory factory = new MySQLDaoFactory();
		
		IUserDao userDao = factory.createUserDao();
		User user = new User();
		user.setUsername("demo");
		user.setPassword("demo".toCharArray());
		userDao.addUser(user);
		
		IRoleDao roleDao = factory.createRoleDao();
		roleDao.getRole("admin");
		
		IProductDao productDao = factory.createProductDao();
		Product product = new Product();
		productDao.removeProduct(product);

	}

}
