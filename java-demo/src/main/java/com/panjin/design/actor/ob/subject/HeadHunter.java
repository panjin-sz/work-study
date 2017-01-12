package com.panjin.design.actor.ob.subject;

import com.panjin.design.actor.ob.observer.ITalent;

public class HeadHunter extends AbstractHR {

  @Override
  public void publishJob(String job) {
//    allTalents.forEach(talent -> talent.newJob(job));
      for (ITalent iTalent : allTalents) {
          iTalent.newJob(job);
    }
  }

}
