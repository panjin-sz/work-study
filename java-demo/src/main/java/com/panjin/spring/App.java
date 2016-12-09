/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 * @author panjin
 * @version $Id: App.java 2016年12月9日 上午11:27:19 $
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
    }

}
