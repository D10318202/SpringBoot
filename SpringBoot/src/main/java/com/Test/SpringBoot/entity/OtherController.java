package com.Test.SpringBoot.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

	@GetMapping("/index")
	public String otherIndex(Model model) {
		model.addAttribute("forEach", createList());
		model.addAttribute("nullValue", null);
		model.addAttribute("nonNullValue", "notNull");
		return "index";
	}

	private List<String> createList() {
		var result = new ArrayList<String>();
		result.add("<span>test1</span>");
		result.add("<span>test2</span>");
		result.add("<span>test3 too long too show</span>");
		result.add("<span>test4</span>");
		return result;
	}
}
