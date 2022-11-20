package com.Test.SpringBoot.entity;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("click", false);
		model.addAttribute("message", "please click!");
		return "hello";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.POST)
	public String click(Model model) {
		model.addAttribute("click", true);
		model.addAttribute("afterClickMsg", "It was clicked");
		return "hello";
	}
	
	@GetMapping("/hi")
	public String hi(Model model) {
		model.addAttribute("modelValue", "Model Value!!");
		return "hi";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", Arrays.asList(1, 2, 3));
		return "hi";
	}
	
    @GetMapping("/hoge")
    public String hoge(Model model) {   	
		model.addAttribute("hoge", new Hoge());		    	
    	return "hi";   	
    }
    
    public static class Hoge{        	
    	public int publicField = 1;
    	
    	public int publicMethod() {return 2;}
    	
    	public int getPublicValue() {return 3;}
    	
    	public String name = "hogeee";
    	
    	public String value = "HOGEEE";
    }

    @GetMapping("/message")
    public String message(Model model) {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("message", "Hello World!!");
    	
    	model.addAttribute("map", map);
    	return "hi";
    }

    @GetMapping("/http")
    public String http(Model model) {
    	return "http";
    }
    
    @GetMapping("/see")
    public String see(Model model) {
    	model.addAttribute("list", Arrays.asList("hoge", "fuga", "piyo"));
    	return "http";
    }
    
    @GetMapping("/letter")
    public String letter(Model model) {
    	HashMap<String, String> map = new HashMap<>();
    	map.put("hoge", "HOGE");
    	map.put("fuge", "FUGA");
    	map.put("piyo", "PIYO");
    	
    	model.addAttribute("map", map);
    	
    	return "http";
    }
}
