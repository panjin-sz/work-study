package com.panjin.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.panjin.pojo.CustomerBase;

public class ObjectsTest {

	public static void main(String[] args) {
		CustomerBase customer = new CustomerBase();
		customer.setCustomerName("alan");
		ToStringHelper helper = MoreObjects.toStringHelper(customer).add("name", customer.getCustomerName());
		System.out.println(helper.toString());
	}

}
