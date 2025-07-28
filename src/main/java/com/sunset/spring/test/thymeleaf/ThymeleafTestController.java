package com.sunset.spring.test.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafTestController {
	
	@GetMapping("/test01")
	public String test01() {
		return "thymeleaf/test01";
	}

}