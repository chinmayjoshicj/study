package com.springappcon.test.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication{

	public static void main(String[] args) {
		/*Triangle triangle=new Triangle();
		triangle.draw();*/
//		BeanFactory beanFactory= new XmlBeanFactory(new FileSystemResource("spring.xml"));
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		/*Shape shape= (Triangle) context.getBean("triangle1");
		shape.draw();*/
		Shape shape= (Circle) context.getBean("circle");
		shape.draw();
		context.destroy();
//		System.out.println(context.getMessage("greeting", null, "default Greeting", null));
	}
 }