package com.springappcon.test.aop.service.model;

import com.springappcon.test.aop.service.Shape;

public class Circle implements Shape{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getArea() {
		return 1;
	}

	
}
