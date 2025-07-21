package com.sunset.spring.ex.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunset.spring.ex.mvc.domain.User;
import com.sunset.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/mvc/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	// 가장 최근 등록한 사용자 정보를 html로 response에 담는다.
	@GetMapping("/info")
	public String userInfo(Model model) {
		// 가장 최근에 등록한 사용자 정보 얻어오기
		User user = userService.getLastUser();
		
		// Model
		model.addAttribute("title", "가장 최근 등록 사용자");
		model.addAttribute("result", user);
		
		return "mvc/userInfo";
	}
	
}