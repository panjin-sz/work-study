/**
 * Copyright (c) 2011-2016 All Rights Reserved.
 */
package com.panjin.design.create.builder;

/**
 *
 *
 * @author panjin
 * @version $Id: Person.java 2016年12月23日 下午3:57:43 $
 */
public class Person {

    private String head;
    private String body;
    private String foot;
    public String getHead() {
        return head;
    }
    public void setHead(String head) {
        this.head = head;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getFoot() {
        return foot;
    }
    public void setFoot(String foot) {
        this.foot = foot;
    }
    @Override
    public String toString() {
        return "Person [head=" + head + ", body=" + body + ", foot=" + foot + "]";
    }
    
}
