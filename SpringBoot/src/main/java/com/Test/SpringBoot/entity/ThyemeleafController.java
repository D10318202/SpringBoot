package com.Test.SpringBoot.entity;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThyemeleafController implements Serializable{

	private static final long serialVersionUID = 1L;

	@RequestMapping("/Thymeleaf")
	public ModelAndView thymeleaf(ModelAndView mav) {
		mav.addObject("user_id", 999);
		User user = new User("¯«¥Ð¤Ó­¦", 25);
		mav.addObject("user", user);
	    mav.setViewName("howto");
		return mav;
	}
}

class User{
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}		
}
