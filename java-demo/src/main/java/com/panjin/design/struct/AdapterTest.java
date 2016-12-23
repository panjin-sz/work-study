/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.struct;

import com.panjin.design.struct.wrapper.Wrapper;

/**
 *
 *
 * @author panjin
 * @version $Id: AdapterTest.java 2016年12月23日 下午6:14:05 $
 */
public class AdapterTest {

    /**
     * 有一个Source类，拥有一个方法，待适配，目标接口是Targetable，通过Adapter类，
     * 将Source的功能扩展到Targetable里
     * @param args
     */
    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
        
        System.out.println("--------------------------------");
        Source source = new Source();
        Targetable target2 = new Wrapper(source);
        target2.method1();
        target2.method2();
    }

}
