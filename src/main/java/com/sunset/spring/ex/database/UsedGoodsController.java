package com.sunset.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.ex.database.domain.UsedGoods;
import com.sunset.spring.ex.database.service.UsedGoodsService;

// request, response 처리 가능 
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	// 중고 게시글 모든 정보를 response에 담는 페이지
	@RequestMapping("db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		
		// 중고 게시글 정보 얻어오기 
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		// 중고물품 게시글 리스트 response에 담기 
		return usedGoodsList;
		
	}
}
