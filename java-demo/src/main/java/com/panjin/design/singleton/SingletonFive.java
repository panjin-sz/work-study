/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.singleton;

/**
 * 静态内部类法
 *
 * @author panjin
 * @version $Id: SingletonFive.java 2016年6月25日 下午4:06:05 $
 */
public class SingletonFive {

    private static class Holder {
        private static SingletonFive instance = new SingletonFive();
    }

    private SingletonFive() {
    }

    public static SingletonFive getSingleton() {
        return Holder.instance;
    }
}
