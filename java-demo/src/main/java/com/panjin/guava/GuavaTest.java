package com.panjin.guava;

import java.util.Random;

import com.google.common.base.Optional;
import com.panjin.pojo.CustomerBase;

public class GuavaTest {

	public static void main(String[] args) {
		CustomerBase customer = null;
//		Optional<CustomerBase> optinal = Optional.of(customer);
//		CustomerBase otherCustomer = optinal.get();
//		System.out.println(otherCustomer.getCustomerId());
		
		Optional<CustomerBase> optinal1 = Optional.fromNullable(customer);
		CustomerBase otherCustomer1 = optinal1.get();
		if (otherCustomer1 == null) {
			System.out.println("otherCustomer1 is null");
		} else {
			System.out.println(otherCustomer1);
			System.out.println(otherCustomer1.getCustomerId());
		}
		
		CustomerBase c = Optional.of(get()).or(get());
		System.out.println(c.getCustomerId());
	}

	public static CustomerBase get() {
		Random r = new Random();
		int random = r.nextInt(10);
		System.out.println(random);
		if (random % 2 == 0) {
			System.out.println("return new object");
			CustomerBase customer = new CustomerBase();
			customer.setCustomerId(random);
			return customer;
		} else {
			System.out.println("return null");
			return null;
		}
	}
}

