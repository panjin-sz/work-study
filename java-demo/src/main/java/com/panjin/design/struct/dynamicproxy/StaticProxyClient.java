package com.panjin.design.struct.dynamicproxy;

import com.panjin.design.struct.dynamicproxy.proxy.staticproxy.ProxySubject;
import com.panjin.design.struct.dynamicproxy.subject.ISubject;

public class StaticProxyClient {

  public static void main(String[] args) {
    ISubject subject = new ProxySubject();
    subject.action();
  }

}
