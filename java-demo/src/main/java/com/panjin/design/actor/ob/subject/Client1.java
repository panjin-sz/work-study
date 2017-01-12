package com.panjin.design.actor.ob.subject;

import com.panjin.design.actor.ob.observer.Architect;
import com.panjin.design.actor.ob.observer.ITalent;
import com.panjin.design.actor.ob.observer.JuniorEngineer;
import com.panjin.design.actor.ob.observer.SeniorEngineer;

public class Client1 {

  public static void main(String[] args) {
    ITalent juniorEngineer = new JuniorEngineer();
    ITalent seniorEngineer = new SeniorEngineer();
    ITalent architect = new Architect();
    
    AbstractHR subject = new HeadHunter();
    subject.addTalent(juniorEngineer);
    subject.addTalent(seniorEngineer);
    subject.addTalent(architect);
    
    subject.publishJob("Top 500 big data position");
  }

}
