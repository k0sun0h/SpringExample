package com.sunset.spring.test.thymeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sunset.spring.ex.mybatis.domain.Review;

@Mapper
public interface StoreReviewRepository {

	public List<Review> selectReviewByStoreId(int storeId);

}