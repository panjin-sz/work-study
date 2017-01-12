package com.panjin.design.create.factory.abstract2.factory;

import com.panjin.design.create.factory.abstract2.dao.product.IProductDao;
import com.panjin.design.create.factory.abstract2.dao.product.MySQLProductDao;
import com.panjin.design.create.factory.abstract2.dao.role.IRoleDao;
import com.panjin.design.create.factory.abstract2.dao.role.MySQLRoleDao;
import com.panjin.design.create.factory.abstract2.dao.user.IUserDao;
import com.panjin.design.create.factory.abstract2.dao.user.MySQLUserDao;

public class MySQLDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new MySQLUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new MySQLRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new MySQLProductDao();
	}

}
