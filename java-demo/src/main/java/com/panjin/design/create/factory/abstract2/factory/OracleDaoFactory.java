package com.panjin.design.create.factory.abstract2.factory;

import com.panjin.design.create.factory.abstract2.dao.product.IProductDao;
import com.panjin.design.create.factory.abstract2.dao.product.OracleProductDao;
import com.panjin.design.create.factory.abstract2.dao.role.IRoleDao;
import com.panjin.design.create.factory.abstract2.dao.role.OracleRoleDao;
import com.panjin.design.create.factory.abstract2.dao.user.IUserDao;
import com.panjin.design.create.factory.abstract2.dao.user.OracleUserDao;

public class OracleDaoFactory implements IDaoFactory {

	@Override
	public IUserDao createUserDao() {
		return new OracleUserDao();
	}

	@Override
	public IRoleDao createRoleDao() {
		return new OracleRoleDao();
	}

	@Override
	public IProductDao createProductDao() {
		return new OracleProductDao();
	}

}
