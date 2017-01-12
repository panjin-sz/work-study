package com.panjin.design.create.factory.abstract2.factory;

import com.panjin.design.create.factory.abstract2.dao.product.IProductDao;
import com.panjin.design.create.factory.abstract2.dao.role.IRoleDao;
import com.panjin.design.create.factory.abstract2.dao.user.IUserDao;

public interface IDaoFactory {

	IUserDao createUserDao();
	IRoleDao createRoleDao();
	IProductDao createProductDao();

}
