package com.sunset.spring.test.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.ex.mybatis.domain.Review;
import com.sunset.spring.test.mybatis.domain.RealEstate;
import com.sunset.spring.test.mybatis.service.RealEstateService;

@Controller
@RequestMapping("/mybatis/real-estate")
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;
	
	// 1. id 로 select 하기
	@RequestMapping("/select/1")
	@ResponseBody
	public RealEstate review(@RequestParam("id") int id) {
		
		RealEstate review = realEstateService.getRealEstate(id);
		return review;
		
	}
	
	// 2. 월세 조건 select
	@RequestMapping("/select/2")
	@ResponseBody
	public List<RealEstate> realEstateListByRentPrice(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByRentPrice(rentPrice);
		return realEstateList;
	}

	// 3. 복합조건 select
	@RequestMapping("/select/3")
	@ResponseBody
	public List<RealEstate> realEstateListByRentPrice(@RequestParam("area") int area, @RequestParam("price") int price) {
		
		List<RealEstate> realEstateList = realEstateService.getRealEstateListByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	
	// // 1. 객체로 insert 하기
	@RequestMapping("/insert/1")
	@ResponseBody
	public String createRealEstateByObject() {

		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateService.addRealEstateByObject(realEstate);
		
		return "입력 성공 : " + count;
		
	}
	
	// 2. Parameter 로 insert 하기
	@RequestMapping("/insert/2")
	@ResponseBody
	public String createRealEstate(@RequestParam("realtorId") int realtorId) {

		int count = realEstateService.addRealEstate(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
		
	}
	
	
	@RequestMapping("/update")
	@ResponseBody
	public String updateRealEstate() {
		
		int row = realEstateService.updateRealEstate(22, "전세", 70000);
		
		return "update 성공 " + row;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteRealEstate(@RequestParam("id") int id) {
		
		int row = realEstateService.deleteRealEstateById(id);
		
		return "삭제 성공 : " + row;
	}
}
