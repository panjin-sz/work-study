package com.panjin.base.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 利用串行化来做深复制
 * @author panjin
 *
 */
public class DeepStudent2 implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int age;
	String name;
	Teacher t;
	
	public DeepStudent2(int age, String name, Teacher t) {
		this.age = age;
		this.name = name;
		this.t = t;
	}
	
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Teacher t = new Teacher(60, "Ayst");
		DeepStudent2 s = new DeepStudent2(20, "Jack", t);
		DeepStudent2 s2 = (DeepStudent2) s.deepClone();
		s2.t.age = 63;
		s2.t.name = "Tom";
		System.out.println("age="+s.t.age+",name="+s.t.name);
		System.out.println("age="+s2.t.age+",name="+s2.t.name);
	}
}

class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int age;
	String name;
	
	public Teacher(int age, String name) {
		this.age = age;
		this.name = name;
	}
}