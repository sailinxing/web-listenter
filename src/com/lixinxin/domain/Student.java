package com.lixinxin.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class Student implements HttpSessionActivationListener, Serializable {
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("我被钝化了");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("我被活化了");
	}

}
