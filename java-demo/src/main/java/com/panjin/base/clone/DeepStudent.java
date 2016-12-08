package com.panjin.base.clone;

/**
 * 深克隆
 * @author panjin
 *
 */
public class DeepStudent implements Cloneable {

	private int age;
	private String name;
	private DeepProfessor p;
	
	public DeepStudent(int age, String name, DeepProfessor p) {
		this.age = age;
		this.name = name;
		this.p = p;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		DeepStudent s = null;
		s = (DeepStudent)super.clone();
		s.p = (DeepProfessor) p.clone();
		return s;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		DeepProfessor p = new DeepProfessor(60, "Ayst");
		DeepStudent s = new DeepStudent(20, "Jack", p);
		DeepStudent s2 = (DeepStudent) s.clone();
		s2.p.setAge(63);
		s2.p.setName("Chen");
		System.out.println("age="+s.p.getAge()+",name="+s.p.getName());
		System.out.println("age="+s2.p.getAge()+",name="+s2.p.getName());
	}

}

class DeepProfessor implements Cloneable{
	private int age;
	private String name;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		DeepProfessor p = null;
		p = (DeepProfessor)super.clone();
		return p;
	}
	
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

	DeepProfessor(int age, String name){
		this.age = age;
		this.name = name;
	}
}
