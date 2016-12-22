/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.db.mybatis.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 *
 * @author panjin
 * @version $Id: Student.java 2016年12月22日 下午6:38:54 $
 */
public class Student implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private int age;
    private String phone;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
