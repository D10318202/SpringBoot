package com.Test.SpringBoot.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CarDao carDao;
	
	@RequestMapping("/go")
	public String go(Model model) {
		List<Car> carlist = carDao.queryBycarType("ToyoTa");
		Car c = carlist.get(0);
		model.addAttribute("carType", c.getCarType());
		model.addAttribute("country", c.getCountry());
		return "go";
	}
	
//	@RequestMapping("/Thymeleaf")
//	public String thymeleaf(Model model) {
//		return "Thymeleaf";
//	}
	
	@RequestMapping("/howto")
	public String howto(Model model) {
		return "howto";
	}
}
