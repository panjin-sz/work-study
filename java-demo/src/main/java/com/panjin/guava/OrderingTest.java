package com.panjin.guava;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Longs;
import com.panjin.pojo.CustomerBase;

public class OrderingTest {

	public static void main(String[] args) {
		CustomerBase customer1 = new CustomerBase();
		customer1.setCustomerId(100L);
		customer1.setCustomerName("customerName1");
		CustomerBase customer2 = new CustomerBase();
		customer2.setCustomerId(200L);
		customer2.setCustomerName("customerName2");
		
		Ordering<CustomerBase> byCustomerIdOrdering = new Ordering<CustomerBase>() {
			
			@Override
			public int compare(CustomerBase left, CustomerBase right) {
				return Longs.compare(left.getCustomerId(), right.getCustomerId());
			}
		};
		
		CustomerBase customer = byCustomerIdOrdering.min(customer1, customer1);
		System.out.println(customer.equals(customer1));
		
		Ordering<CustomerBase> ordering = Ordering.natural().nullsFirst().onResultOf(new Function<CustomerBase, Long>() {
			
			@Override
			public Long apply(CustomerBase input) {
				return input.getCustomerId();
			}
		});
		
		CustomerBase otherCustomer = ordering.max(customer1, customer2);
		System.out.println(otherCustomer.equals(customer1));
	}

}
