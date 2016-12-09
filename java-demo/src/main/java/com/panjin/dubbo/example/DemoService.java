/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.dubbo.example;

import com.panjin.pojo.CustomerBase;

/**
 *
 *
 * @author panjin
 * @version $Id: DemoService.java 2016年12月9日 下午1:59:51 $
 */
public interface DemoService {

    public void sayHello();
    
    public String returnHello();
    
    public CustomerBase returnCustomer(CustomerBase customer);
}
