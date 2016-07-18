/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.test;

/**
 *
 *
 * @author panjin
 * @version $Id: Dog.java 2016年7月18日 下午1:51:54 $
 */
public class Dog extends Animal {

    /**  */
    private static final long serialVersionUID = 8670027253842785580L;

    private String name;
    
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
