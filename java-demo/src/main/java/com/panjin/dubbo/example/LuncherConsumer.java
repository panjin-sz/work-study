/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.dubbo.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.panjin.pojo.CustomerBase;

/**
 *
 *
 * @author panjin
 * @version $Id: LuncherConsumer.java 2016年12月9日 下午2:17:26 $
 */
public class LuncherConsumer {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        String configLocation="beans/dubbo-consumer.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.print("----------PJ----------Beans:");
        for (String name : beanNames) {
            System.out.print(name+",");
        }
        System.out.println();
        
        DemoService  demoService = (DemoService) context.getBean("demoService");
        CustomerBase customer = new CustomerBase();
        customer = demoService.returnCustomer(customer);
        System.out.println("customerid="+customer.getCustomerId() +",customerName="+customer.getCustomerName());
    }
}
