package com.sunset.spring.test.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.test.database.domain.Store;
import com.sunset.spring.test.database.repository.StoreRepository;

//로직(business) 담당
//데이터 가공
//그외 복잡한 기능 수행 
@Service
public class StoreService {
	
	// 의존성 주입 - DI
	// 객체 생성을 Spring Framework 에서 직접 관리 
	@Autowired
	private StoreRepository storeRepository;

	
	// store 정보 모두 얻어오기
	public List<Store> getStoreList() {
		
		// store 테이블 모든 행 조회
		List<Store> usedGoodsList = storeRepository.selectStoreList();
		
		return usedGoodsList;
	}
	
}
