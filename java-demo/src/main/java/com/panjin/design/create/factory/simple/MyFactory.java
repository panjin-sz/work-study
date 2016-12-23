/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.factory.simple;

public class MyFactory {
    
    public MyInterface create(ClassType type) {
        if (ClassType.ONE == type) {
            return new MyClassOne();
        } else if (ClassType.TWO == type) {
            return new MyClassTwo();
        } else {
            throw new RuntimeException("can not find exist type");
        }
    }
    
    /**
     * 静态工厂方法实例
     * 
     * @param type
     * @return
     */
    public static MyInterface createByStatic(ClassType type) {
        if (ClassType.ONE == type) {
            return new MyClassOne();
        } else if (ClassType.TWO == type) {
            return new MyClassTwo();
        } else {
            throw new RuntimeException("can not find exist type");
        }
    }
}
