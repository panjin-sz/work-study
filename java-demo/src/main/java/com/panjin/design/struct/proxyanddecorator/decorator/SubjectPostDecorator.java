package com.panjin.design.struct.proxyanddecorator.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.panjin.design.struct.proxyanddecorator.subject.ISubject;

public class SubjectPostDecorator implements ISubject {

  private static final Logger LOG = LoggerFactory.getLogger(SubjectPostDecorator.class);

  private ISubject subject;

  public SubjectPostDecorator(ISubject subject) {
    this.subject = subject;
  }

  @Override
  public void action() {
    subject.action();
    postAction();
  }

  private void postAction() {
    LOG.info("SubjectPostDecorator.preAction()");
  }

}
