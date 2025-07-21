package com.sunset.spring.test.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sunset.spring.test.database.domain.Store;

//데이터 베이스 관련 처리 (query 수행) 
//Mybatis Framework
@Mapper
public interface StoreRepository {

	// store 모든 행 조회
	public List<Store> selectStoreList();
	
}
