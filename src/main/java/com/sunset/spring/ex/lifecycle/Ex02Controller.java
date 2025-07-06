package com.sunset.spring.ex.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Ex02Controller {

	@RequestMapping("/lifecycle/test02")
	public String thymeleafFesponse() {
		
		return "lifecycle/test02";
		
	}
	
}