/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.db.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.panjin.db.mybatis.domain.Student;
import com.panjin.db.mybatis.service.StudentService;

public class App {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"beans/beans-mybatis.xml", "beans/SpringBeans.xml"});
        StudentService obj = (StudentService) context.getBean("studentService");
        Student student = obj.queryById(1);
        System.out.println(student);
    }

}
