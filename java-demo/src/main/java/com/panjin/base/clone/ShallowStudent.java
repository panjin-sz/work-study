package com.panjin.base.clone;

/**
 * 浅复制
 * @author panjin
 *
 */
public class ShallowStudent implements Cloneable{

	private int age;
	private String name;
	
	public ShallowStudent(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ShallowStudent s = null;
		s = (ShallowStudent)super.clone();
		return s;
	}

	/**
	 * 1、拷贝对象是返回的是一个新的对象，而不是一个引用
	 * 2、拷贝对象与用new操作符返回的新对象的区别就是这个拷贝已经包含了一些原来对象的信息，而不是对象的初始信息
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowStudent student = new ShallowStudent(20, "Jack");
		ShallowStudent s2 = (ShallowStudent) student.clone();
		System.out.println(student == s2);
		s2.age = 30;
		s2.name = "Vito";
		System.out.println("age:"+student.age+",name:"+student.name);
		System.out.println("age:"+s2.age+",name:"+s2.name);
	}

}
