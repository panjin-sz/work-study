package com.panjin.base.classloader;

public class Child extends Father {

	public static int d = c;
	
	static {
		System.out.println("child static!");
	}
}
