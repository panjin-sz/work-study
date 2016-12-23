package com.panjin.design.create.factory.simple;

public class FactoryTest {

    public static void main(String[] args) {
        MyFactory factory = new MyFactory();
        MyInterface obj = factory.create(ClassType.ONE);
        obj.print();
        
        MyInterface obj2 = MyFactory.createByStatic(ClassType.TWO);
        obj2.print();
    }

}
