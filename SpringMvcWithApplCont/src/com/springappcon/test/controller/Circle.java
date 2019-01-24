package com.springappcon.test.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@Service
@Repository
public class Circle implements Shape {

	private Point center;
	@Autowired
	private MessageSource messageSource;

	public Point getCenter() {
		return center;
	}
	/*@Required*/
	/*@Autowired
	@Qualifier("circleRelated")*/
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center; 
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle ");
		System.out.println("Circle: Point is " + center.getX() + " " + center.getY());
		System.out.println(this.messageSource.getMessage("greeting", null, "default Greeting", null));
	}
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Initialize Circle");
	}
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy Circle");
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
