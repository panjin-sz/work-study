/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.singleton;

/**
 * 考虑线程安全的写法
 *
 * @author panjin
 * @version $Id: SingletonThree.java 2016年6月25日 下午3:59:13 $
 */
public class SingletonThree {

    private static volatile SingletonThree instance = null;

    private SingletonThree() {

    }

    public static SingletonThree getIntance() {
        synchronized (SingletonThree.class) {
            if (instance == null) {
                instance = new SingletonThree();
            }
        }
        return instance;
    }
}
