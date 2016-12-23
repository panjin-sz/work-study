/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.struct;

/**
 * 类的适配器
 * 继承了原类，实现了目标接口
 * @author panjin
 * @version $Id: Adapter.java 2016年12月23日 下午6:13:25 $
 */
public class Adapter extends Source implements Targetable {

    /** 
     * @see com.panjin.design.struct.Targetable#method2()
     */
    @Override
    public void method2() {
        System.out.println("Adapter-class:method2");
    }

}
