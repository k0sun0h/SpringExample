package com.sunset.spring.test.Ajax;

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

import com.sunset.spring.test.Ajax.domain.Favorite;
import com.sunset.spring.test.Ajax.service.FavoriteService;

@Controller
@RequestMapping("/ajax/favorite")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/list")
	public String favoriteList(Model model) {
		
		List<Favorite> favoriteList = favoriteService.getFavoriteList();
		
		model.addAttribute("favoriteList", favoriteList);
		
		return "/ajax/favoriteList";
	}
	
	@GetMapping("/input")
	public String inputFavorite() {
		return "ajax/favoriteInput";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createFavorite(
			@RequestParam("name") String name
			, @RequestParam("url") String url) {
		
		int count = favoriteService.addFavorite(name, url);
		
		// 성공실패 여부 
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// 1. url 중복 확인 기능
	@PostMapping("/duplicate-url")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		boolean isDuplicate = favoriteService.isDuplicateUrl(url);
		
		Map<String, Boolean> resultMap = new HashMap<>();

		resultMap.put("isDuplicate", isDuplicate);
		
		return resultMap;
		
	}
	
	// 2. 삭제 기능
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteFavorite(@RequestParam("id") int id) {
		
		int count = favoriteService.deleteFavorite(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
}