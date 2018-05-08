package com.springappcon.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping(value="success")
	public ModelAndView displaySuccessPage() {
		System.out.println("inside my success page method");
		return new ModelAndView("/jsp/success.jsp");
	}
}
