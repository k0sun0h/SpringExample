package com.sunset.spring.test.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.test.database.domain.Store;
import com.sunset.spring.test.database.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;

	// 가게의 모든 정보를 response에 담는 페이지
	@RequestMapping("db/store/list")
	@ResponseBody
	public List<Store> storeList() {
		
		// 가게 정보 얻어오기 
		List<Store> storeList = storeService.getStoreList();
		// 가게 리스트 response에 담기 
		return storeList;
		
	}
	
}
