/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.test;

import java.io.Serializable;

/**
 *
 *
 * @author panjin
 * @version $Id: Animal.java 2016年7月18日 下午1:50:47 $
 */
public class Animal implements Serializable {

    /**  */
    private static final long serialVersionUID = -756033221372621697L;

    private String name;
    
    private int age;

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
    
    
}
