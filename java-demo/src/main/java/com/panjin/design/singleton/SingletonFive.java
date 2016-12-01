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
    
    private static boolean flag = false;

    private static class Holder {
        private static SingletonFive instance = new SingletonFive();
    }

    private SingletonFive() {
        synchronized (SingletonFive.class) {
            // 防止通过反射模式构造单列对象
            if (flag == false) {
                flag = !flag;
            } else {
                throw new RuntimeException("单列模式被侵犯");
            }
        }
    }

    public static SingletonFive getSingleton() {
        return Holder.instance;
    }
}
