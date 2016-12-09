/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.dubbo.example;

import com.panjin.pojo.CustomerBase;

/**
 *
 *
 * @author panjin
 * @version $Id: DemoServiceImpl.java 2016年12月9日 下午2:01:26 $
 */
public class DemoServiceImpl implements DemoService {

    /** 
     * @see com.panjin.dubbo.example.DemoService#sayHello()
     */
    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    /** 
     * @see com.panjin.dubbo.example.DemoService#returnHello()
     */
    @Override
    public String returnHello() {
        return "hello world";
    }

    /** 
     * @see com.panjin.dubbo.example.DemoService#returnCustomer(com.panjin.pojo.CustomerBase)
     */
    @Override
    public CustomerBase returnCustomer(CustomerBase customer) {
        customer.setCustomerId(999L);
        customer.setCustomerName("Vito");
        return customer;
    }

}
