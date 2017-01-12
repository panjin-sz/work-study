package com.panjin.design.create.factory.abstract2.dao.role;

import com.panjin.design.create.factory.abstract2.bean.Role;

public interface IRoleDao {
	
	void addRole(Role role);
	void removeRole(Role role);
	Role getRole(String rolename);

}
