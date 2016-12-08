package com.panjin.base.clone;

/**
 * 浅克隆
 * @author panjin
 *
 */
public class ShallowStudent2 implements Cloneable {

	private int age;
	private String name;
	private Professor p;
	
	public ShallowStudent2(int age, String name, Professor p) {
		this.age = age;
		this.name = name;
		this.p = p;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		ShallowStudent2 s = null;
		s = (ShallowStudent2) super.clone();
		return s;
	}

	/**
	 * 这里仅仅保存的是对象的引用，这也导致clone后的非基本类型变量和原始对象中相应的变量指向的是同一个对象
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Professor p = new Professor(60, "Ayst");
		ShallowStudent2 s = new ShallowStudent2(20, "Jack", p);
		ShallowStudent2 s2 = (ShallowStudent2) s.clone();
		s2.p.setAge(63);
		s2.p.setName("Chen");
		System.out.println("age="+s.p.getAge()+",name="+s.p.getName());
		System.out.println("age="+s2.p.getAge()+",name="+s2.p.getName());
	}

}

class Professor {
	private int age;
	private String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Professor(int age, String name){
		this.age = age;
		this.name = name;
	}
}
