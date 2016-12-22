/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.db.mybatis.dao;

import com.panjin.db.mybatis.domain.Student;

/**
 *
 *
 * @author panjin
 * @version $Id: IStudentDao.java 2016年12月22日 下午6:44:28 $
 */
public interface IStudentDao {

    Student queryById(int id);
}
