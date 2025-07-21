package com.sunset.spring.test.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.test.mybatis.domain.RealEstate;
import com.sunset.spring.test.mybatis.repository.RealEstateRepository;

@Service
public class RealEstateService {

	@Autowired
	private RealEstateRepository realEstateRepository;
	
	// 1. id 로 select 하기
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateRepository.selectRealEstate(id);
		return realEstate;
	}
	
	// 2. 월세 조건 select
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByRentPrice(rentPrice);
		return realEstateList;
	}
	
	// 3. 복합조건 select
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		List<RealEstate> realEstateList = realEstateRepository.selectRealEstateListByAreaAndPrice(area, price);
		return realEstateList;
	}
	
	
	// 1. 객체로 insert 하기
	public int addRealEstateByObject(RealEstate realEstate) {
		
		int count = realEstateRepository.insertRealEstateByObject(realEstate);
		
		return count;
	}
	
	// 2. Parameter 로 insert 하기
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		
		int count = realEstateRepository.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		return count;
	}
	
	
	public int updateRealEstate(int id, String type, int price) {
		return realEstateRepository.updateRealEstateById(id, type, price);
	}
	
	
	public int deleteRealEstateById(int id) {
		return realEstateRepository.deleteRealEstateById(id);
	}
}
