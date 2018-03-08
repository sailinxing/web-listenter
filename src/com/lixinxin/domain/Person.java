package com.lixinxin.domain;


import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;


public class Person implements HttpSessionBindingListener{

	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("我被绑了！");

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("我被放了！");

	}

}
