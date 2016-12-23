/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.builder;

/**
 *
 *
 * @author panjin
 * @version $Id: IPersonBuilder.java 2016年12月23日 下午3:58:39 $
 */
public interface IPersonBuilder {

    void buildHead();
    
    void buildBody();
    
    void buildFoot();
    
    Person buildPerson();
}
