/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.spring;

/**
 *
 *
 * @author panjin
 * @version $Id: HelloWorld.java 2016年12月9日 上午11:24:10 $
 */
public class HelloWorld {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Spring 4 : hello ! " + name);
    }
}
