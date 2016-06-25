/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.singleton;

/**
 * 单线程写法
 *
 * @author panjin
 * @version $Id: SingletonTwo.java 2016年6月25日 下午3:56:04 $
 */
public class SingletonTwo {

    private static SingletonTwo instance = null;

    private SingletonTwo() {
        
    }

    public static SingletonTwo getIntance() {
        if (instance == null) {
            instance = new SingletonTwo();
        }
        return instance;
    }
}
