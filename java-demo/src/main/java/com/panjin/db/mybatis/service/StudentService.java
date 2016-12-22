/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.db.mybatis.service;

import javax.annotation.Resource;

import com.panjin.db.mybatis.dao.IStudentDao;
import com.panjin.db.mybatis.domain.Student;

/**
 *
 *
 * @author panjin
 * @version $Id: StudentService.java 2016年12月22日 下午6:59:08 $
 */
public class StudentService {
    
    @Resource
    private IStudentDao studentDao;
    
    public Student queryById(int id){
        return studentDao.queryById(id);
    }
}
