/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.builder;

/**
 *
 *
 * @author panjin
 * @version $Id: BuilderTest.java 2016年12月23日 下午4:05:14 $
 */
public class BuilderTest {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        IPersonBuilder personBuilder = new ManBuilder();
        Person person = pd.constructPerson(personBuilder);
        System.out.println(person);
    }

}
