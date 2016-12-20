package com.panjin.base.classloader;

public class Super {

	public static int a = 1;
	public static final int b = 2;
	public static int c = 3;
	
	static {
		c = 4;
		System.out.println("super static!");
	}
}
