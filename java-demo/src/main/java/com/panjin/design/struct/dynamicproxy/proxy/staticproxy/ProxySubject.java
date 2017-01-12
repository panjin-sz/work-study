package com.panjin.design.struct.dynamicproxy.proxy.staticproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.struct.dynamicproxy.subject.ConcreteSubject;
import com.panjin.design.struct.dynamicproxy.subject.ISubject;

public class ProxySubject implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(ProxySubject.class);

  private ISubject subject;

  public ProxySubject() {
    subject = new ConcreteSubject();
  }

  @Override
  public void action() {
    preAction();
    subject.action();
    postAction();
  }

  public void preAction() {
    LOG.info("ProxySubject.preAction()");
  }

  public void postAction() {
    LOG.info("ProxySubject.postAction()");
  }

}
