package com.sunset.spring.test.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.test.mvc.domain.Seller;
import com.sunset.spring.test.mvc.service.SellerService;

@Controller
@RequestMapping("/mvc/seller")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// 하나의 판매자 정보 저장 기능
	// 닉네임, 온도, 프로필 사진 url
	// @RequestMapping(path="/mvc/seller/create", method=RequestMethod.POST)
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("temperature") double temperature
			, @RequestParam("profileImage") String profileImage) {
		
		int count = sellerService.addSeller(nickname, temperature, profileImage);
		
		return "실행 결과 : " + count;
	}
	
	@GetMapping("/input")
	public String inputSeller() {
		return "mvc/seller/sellerInput";
	}

	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		
		Seller seller = null;
		// id가 전달되면, 일치하는 판매자 정보 
		if(id != null) {
			seller = sellerService.getSeller(id);
		} else { // id가 전달되지 않으면, 가장 최근 등록된 판매자 정보			
			seller = sellerService.getLastSeller();
		}
		
		model.addAttribute("seller", seller);
		return "mvc/seller/sellerInfo";
	}
}
