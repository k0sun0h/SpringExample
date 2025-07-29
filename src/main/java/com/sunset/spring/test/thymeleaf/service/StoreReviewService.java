package com.sunset.spring.test.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.ex.mybatis.domain.Review;
import com.sunset.spring.test.thymeleaf.repository.StoreReviewRepository;

@Service
public class StoreReviewService {
	
	@Autowired
	private StoreReviewRepository storeReviewRepository;

	public List<Review> getReviewList(int storeId) {
	    return storeReviewRepository.selectReviewByStoreId(storeId);
	}
	
}
