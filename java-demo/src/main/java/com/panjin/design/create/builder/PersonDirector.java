/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.builder;

/**
 *
 *
 * @author panjin
 * @version $Id: PersonDirector.java 2016年12月23日 下午4:03:55 $
 */
public class PersonDirector {

    public Person constructPerson(IPersonBuilder personBuilder) {
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildFoot();
        return personBuilder.buildPerson();
    }
}
