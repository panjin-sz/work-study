package com.panjin.design.struct.proxyanddecorator;

import com.panjin.design.struct.proxyanddecorator.proxy.ProxySubject;
import com.panjin.design.struct.proxyanddecorator.subject.ISubject;

public class StaticProxyClient {

  public static void main(String[] args) {
    ISubject subject = new ProxySubject();
    subject.action();
  }

}
