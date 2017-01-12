package com.panjin.design.create.factory.abstract2.factory;

import com.panjin.design.create.factory.abstract2.dao.product.IProductDao;
import com.panjin.design.create.factory.abstract2.dao.product.PostgreSQLProductDao;
import com.panjin.design.create.factory.abstract2.dao.role.IRoleDao;
import com.panjin.design.create.factory.abstract2.dao.role.PostgreSQLRoleDao;
import com.panjin.design.create.factory.abstract2.dao.user.IUserDao;
import com.panjin.design.create.factory.abstract2.dao.user.PostgreSQLUserDao;


public class PostgreSQLDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new PostgreSQLUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new PostgreSQLRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new PostgreSQLProductDao();
	}

}
