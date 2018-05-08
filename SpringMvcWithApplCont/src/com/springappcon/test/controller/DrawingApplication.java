package com.springappcon.test.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication{

	public static void main(String[] args) {
		/*Triangle triangle=new Triangle();
		triangle.draw();*/
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle= (Triangle) context.getBean("triangle1");
		triangle.draw();
	}
 }