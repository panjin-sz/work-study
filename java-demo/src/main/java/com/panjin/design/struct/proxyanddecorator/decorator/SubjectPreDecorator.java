package com.panjin.design.struct.proxyanddecorator.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.struct.proxyanddecorator.subject.ISubject;

public class SubjectPreDecorator implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(SubjectPreDecorator.class);

  private ISubject subject;

  public SubjectPreDecorator(ISubject subject) {
    this.subject = subject;
  }

  @Override
  public void action() {
    preAction();
    subject.action();
  }

  private void preAction() {
    LOG.info("SubjectPreDecorator.preAction()");
  }

}
