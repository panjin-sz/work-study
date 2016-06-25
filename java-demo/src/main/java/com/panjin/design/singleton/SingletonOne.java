/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.singleton;

/**
 * 饿汉式
 *
 * @author panjin
 * @version $Id: SingletonOne.java 2016年6月25日 下午3:40:52 $
 */
public class SingletonOne {

    private static SingletonOne instance = new SingletonOne();
    
    private SingletonOne(){
        
    }
    
    public static SingletonOne getIntance() {
        return instance;
    }
}
