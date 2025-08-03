package com.sunset.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.ex.mvc.domain.User;
import com.sunset.spring.ex.mvc.service.UserService;

@Controller
@RequestMapping("/ajax/user")
public class NewUserController {
	
	@Autowired
	private UserService userService;

	// response가 json 데이터 형태인 페이지 
	// 사용자 추가 API 
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce) {
		
		User user = new User();
		user.setName(name);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userService.addUser(name, birthday, email, introduce);
		
		// 성공실패 여부 
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) { // 성공
			resultMap.put("result", "success");
			 
		} else { // 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 입력 화면 view
	@GetMapping("/input")
	public String inputUser() {
		
		return "ajax/Input";

	}
}