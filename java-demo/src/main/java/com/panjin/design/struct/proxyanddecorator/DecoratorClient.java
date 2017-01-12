package com.panjin.design.struct.proxyanddecorator;

import com.panjin.design.struct.proxyanddecorator.decorator.SubjectPostDecorator;
import com.panjin.design.struct.proxyanddecorator.decorator.SubjectPreDecorator;
import com.panjin.design.struct.proxyanddecorator.subject.ConcreteSubject;
import com.panjin.design.struct.proxyanddecorator.subject.ISubject;

public class DecoratorClient {

  public static void main(String[] args) {
    ISubject subject = new ConcreteSubject();
    ISubject preDecorator = new SubjectPreDecorator(subject);
    ISubject postDecorator = new SubjectPostDecorator(preDecorator);
    postDecorator.action();

  }

}
