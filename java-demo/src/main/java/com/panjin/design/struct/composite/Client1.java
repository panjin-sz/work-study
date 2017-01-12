package com.panjin.design.struct.composite;

import com.panjin.design.struct.composite.organization.Company;
import com.panjin.design.struct.composite.organization.Department;
import com.panjin.design.struct.composite.organization.Organization;

/**
 * 对于一家大型公司，每当公司高层有重要事项需要通知到总部每个部门以及分公司的各个部门时，并不希望逐一通知，
 * 而只希望通过总部各部门及分公司，再由分公司通知其所有部门。这样，对于总公司而言，不需要关心通知的是总部的部门还是分公司。
 *
 * @author panjin
 * @version $Id: Client1.java 2017年1月12日 上午11:19:27 $
 */
public class Client1 {

  public static void main(String[] args) {
    Organization shCompany = new Company("shCompany");
    
    Organization shHR = new Department("shHR");
    shCompany.addOrg(shHR);
    
    Organization shAdmin = new Department("shAdmin");
    shCompany.addOrg(shAdmin);
    
    Organization shFinance = new Department("shFinance");
    shCompany.addOrg(shFinance);
    
    Organization bjCompany = new Company("bjCompany");
    
    Organization bjHR = new Department("bjHR");
    bjCompany.addOrg(bjHR);
    
    Organization bjAdmin = new Department("bjAdmin");
    bjCompany.addOrg(bjAdmin);
    
    Organization bjFinance = new Department("bjFinance");
    bjCompany.addOrg(bjFinance);
    
    Organization company = new Company("company");
    Organization hr = new Department("hr");
    company.addOrg(hr);
    Organization admin = new Department("admin");
    company.addOrg(admin);
    Organization finance = new Department("finance");
    company.addOrg(finance);
    
    company.addOrg(shCompany);
    company.addOrg(bjCompany);
    
    company.inform("Cheers");
  }

}
