package com.sunset.spring.test.mybatis.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.ex.mybatis.domain.Review;
import com.sunset.spring.test.mybatis.domain.RealEstate;

@Mapper
public interface RealEstateRepository {

	// 1. id 로 select 하기
	public RealEstate selectRealEstate(@Param("id") int id);
	
	
	// 2. 월세 조건 select
	public List<RealEstate> selectRealEstateListByRentPrice(@Param("rent") int rentPrice);
	
	
	// 3. 복합조건 select
	public List<RealEstate> selectRealEstateListByAreaAndPrice(@Param("area") int area, @Param("price") int price);
	
	
	// 1. 객체로 insert 하기
	public int insertRealEstateByObject(RealEstate realEstate);
	
	// 2. Parameter 로 insert 하기
	public int insertRealEstate(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") int rentPrice);
	
	
	public int updateRealEstateById(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	
	public int deleteRealEstateById(@Param("id") int id);
}
