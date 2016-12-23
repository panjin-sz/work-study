/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.builder;

/**
 *
 *
 * @author panjin
 * @version $Id: ManBuilder.java 2016年12月23日 下午4:00:13 $
 */
public class ManBuilder implements IPersonBuilder {
    
    Person person;
    
    public ManBuilder() {
        person = new Person();
    }

    /** 
     * @see com.panjin.design.create.builder.IPersonBuilder#buildHead()
     */
    @Override
    public void buildHead() {
        person.setHead("构造男人的头");
    }

    /** 
     * @see com.panjin.design.create.builder.IPersonBuilder#buildBody()
     */
    @Override
    public void buildBody() {
        person.setBody("构造男人的身体");
    }

    /** 
     * @see com.panjin.design.create.builder.IPersonBuilder#buildFoot()
     */
    @Override
    public void buildFoot() {
        person.setFoot("构造男人的脚");
    }

    /** 
     * @see com.panjin.design.create.builder.IPersonBuilder#buildPerson()
     */
    @Override
    public Person buildPerson() {
        return person;
    }

}
