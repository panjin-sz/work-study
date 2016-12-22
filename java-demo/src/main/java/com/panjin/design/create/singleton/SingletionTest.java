/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.singleton;

/**
 *
 *
 * @author panjin
 * @version $Id: SingletionTest.java 2016年11月25日 下午4:01:07 $
 */
public class SingletionTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        SingletonSix.getInstance().operation();
        SingletonSix.INSTANCE.operation();
    }

}
