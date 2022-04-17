package com.ithem.first;

class Person{
	String name;
	int age;
	public Person(int a) {
		age=a;
	}
	public Person(String n,int a) {
		name = n;
		age = a;
	}
	public void speak() {
		System.out.println("ÎÒ½ñÄê"+age+"Ëê");
	}
}

public class example01 {
	public static void main(String[] args) {
		Person p1 = new Person(90);
	
		p1.speak();
	}
}
