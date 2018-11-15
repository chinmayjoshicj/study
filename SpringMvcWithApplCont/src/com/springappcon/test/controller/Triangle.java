package com.springappcon.test.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware  {

	/*private String type;
	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}
	private int height;
	
	public Triangle(String type) {
		super();
		this.type = type;
	}
	public void draw() {
		System.out.println("Triangle Drawn");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}*/
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context=null; 

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	public void draw() {
		System.out.println("Point A = ("+getPointA().getX()+", "+getPointA().getY()+")");
		System.out.println("Point B = ("+getPointB().getX()+", "+getPointB().getY()+")");
		System.out.println("Point C = ("+getPointC().getX()+", "+getPointC().getY()+")");
	}
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException 
	{
		this.context=context;
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Bean Name is: " +beanName);
	}
	
}
