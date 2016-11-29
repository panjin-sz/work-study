/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.singleton;

/**
 * 使用枚举方式实现
 *
 * @author panjin
 * @version $Id: SingletonSix.java 2016年6月25日 下午4:07:48 $
 */
public enum SingletonSix {

    INSTANCE;

    /**
     * 
     * 
     * @return
     */
    public static SingletonSix getInstance() {
        return INSTANCE;
    }
    
    public void operation() {
        System.out.println("需要做些什么事情勒");
    }
}
