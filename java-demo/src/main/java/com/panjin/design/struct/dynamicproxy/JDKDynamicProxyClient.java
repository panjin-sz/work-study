package com.panjin.design.struct.dynamicproxy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.struct.dynamicproxy.proxy.jdkproxy.SubjectProxyHandler;
import com.panjin.design.struct.dynamicproxy.subject.ConcreteSubject;
import com.panjin.design.struct.dynamicproxy.subject.ISubject;

import sun.misc.ProxyGenerator;

public class JDKDynamicProxyClient {

  private static final Logger LOG = LoggerFactory.getLogger(JDKDynamicProxyClient.class);
  
  public static void main(String[] args) throws IOException {
    InvocationHandler handler = new SubjectProxyHandler(ConcreteSubject.class);
    ISubject subject =
        (ISubject) Proxy.newProxyInstance(JDKDynamicProxyClient.class.getClassLoader(),
            new Class[] {ISubject.class}, handler);
    subject.action();
    LOG.info("Proxy class name {}", subject.getClass().getName());
    byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy17", ConcreteSubject.class.getInterfaces());  
    try(OutputStream outputStream = new FileOutputStream("$Proxy17.class")){
      IOUtils.write(classFile, outputStream);
    }
  }

}
