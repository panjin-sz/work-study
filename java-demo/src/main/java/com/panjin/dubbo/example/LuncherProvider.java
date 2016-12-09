/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.dubbo.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 *
 * @author panjin
 * @version $Id: LuncherProvider.java 2016年12月9日 下午2:12:32 $
 */
public class LuncherProvider {

    public static void main(String[] args) throws InterruptedException {
        start();
        Thread.sleep(1000*60*10);
    }

    public static void start() {
        String configLocation="beans/dubbo-provider.xml";
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.print("----------PJ----------Beans:");
        for (String name : beanNames) {
            System.out.print(name+",");
        }
        System.out.println();
    }
}
