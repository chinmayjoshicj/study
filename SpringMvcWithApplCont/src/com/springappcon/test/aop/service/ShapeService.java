package com.springappcon.test.aop.service;

public class ShapeService {

	private Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void printArea() {
		System.out.println("Area:" + shape.getArea());
	}

}
