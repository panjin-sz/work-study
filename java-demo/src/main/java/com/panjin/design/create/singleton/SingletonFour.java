/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.singleton;

/**
 * 兼顾线程安全和效率的写法
 *
 * @author panjin
 * @version $Id: SingletonFour.java 2016年6月25日 下午4:03:41 $
 */
public class SingletonFour {

    private static volatile SingletonFour instance = null;

    private SingletonFour() {

    }

    public static SingletonFour getIntance() {
        if (instance == null) {
            synchronized (SingletonFour.class) {
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }
        return instance;
    }
}
