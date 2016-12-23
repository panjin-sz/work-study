/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.factory.abstracts;

import com.panjin.design.create.factory.simple.MyInterface;

public class FactoryTest {

    public static void main(String[] args) {
        Provider provider = new MyFactoryOne();
        MyInterface factory = provider.create();
        factory.print();
    }

}
