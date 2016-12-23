/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.factory.abstracts;

import com.panjin.design.create.factory.simple.MyClassOne;
import com.panjin.design.create.factory.simple.MyInterface;

public class MyFactoryOne implements Provider {

    /** 
     * @see com.panjin.design.create.factory.abstracts.Provider#create()
     */
    @Override
    public MyInterface create() {
        return new MyClassOne();
    }

}
