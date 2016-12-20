package com.panjin.base.classloader;

public class Father extends Super {

	public static int a = 11;
	public static final int b = 22;
	//public static int c = 33;
	
	static {
		System.out.println("Father static!");
	}
}
