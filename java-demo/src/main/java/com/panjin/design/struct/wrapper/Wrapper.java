/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.struct.wrapper;

import com.panjin.design.struct.Source;
import com.panjin.design.struct.Targetable;

/**
 * 持有source类的实例，以达到解决兼容性的问题
 * 
 * @author panjin
 * @version $Id: Wrapper.java 2016年12月23日 下午6:22:55 $
 */
public class Wrapper implements Targetable {

    private Source source;
    
    public Wrapper(Source source) {
        this.source = source;
    }
    
    /** 
     * @see com.panjin.design.struct.Targetable#method1()
     */
    @Override
    public void method1() {
        source.method1();
    }

    /** 
     * @see com.panjin.design.struct.Targetable#method2()
     */
    @Override
    public void method2() {
        System.out.println("Wrapper-class:method2");
    }

}
