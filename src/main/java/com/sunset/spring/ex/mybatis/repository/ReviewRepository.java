package com.sunset.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달 받은 id 행 조회 리턴
	public Review selectReview(@Param("id") int id);
	
	
	// sellerId, 메뉴, 작성자, 별점, 리뷰를 한 행 저장하는 기능
	public int insertReview(
			@Param("storeId") int storeId
			, @Param("menu") String menu
			, @Param("userName") String userName
			, @Param("point") double point
			, @Param("review") String review);
	
	// Review 객체를 통해 한 행 저장하는 기능 
	public int insertReviewByObject(Review review);
	
	
	// 리뷰 정보를 업데이트하는 기능 
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);
	
	
	// 리뷰 정보를 삭제하는 기능 
	public int deleteReviewById(@Param("id") int id);
	
}