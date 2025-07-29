package com.sunset.spring.test.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunset.spring.test.database.service.StoreService;
import com.sunset.spring.test.thymeleaf.service.StoreReviewService;

@Controller
@RequestMapping("/thymeleaf/store")
public class StoreReviewController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/list") 
	public String stores(Model model) {
		
		model.addAttribute("storeList", storeService.getStoreList());
		
		return "thymeleaf/store/storeList";
		
	}
	
	@Autowired
	private StoreReviewService storeReviewService;
	
	@GetMapping("/review")
	public String reviews(
			@RequestParam("storeId") int storeId
			,@RequestParam("storeName") String storeName
			, Model model)  {
		model.addAttribute("storeName", storeName);
		model.addAttribute("reviewList", storeReviewService.getReviewList(storeId));
		
		return "thymeleaf/store/reviewList";
	}
	
}