package com.panjin.design.struct.dynamicproxy;

import com.panjin.design.struct.dynamicproxy.proxy.cglibproxy.SubjectInterceptor;
import com.panjin.design.struct.dynamicproxy.subject.ConcreteSubject;
import com.panjin.design.struct.dynamicproxy.subject.ISubject;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CgLibProxyClient {

  public static void main(String[] args) {
    MethodInterceptor methodInterceptor = new SubjectInterceptor();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(ConcreteSubject.class);
    enhancer.setCallback(methodInterceptor);
    ISubject subject = (ISubject)enhancer.create();
    subject.action();
  }

}
