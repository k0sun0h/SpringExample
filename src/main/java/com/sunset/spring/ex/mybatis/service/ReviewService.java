package com.sunset.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.ex.mybatis.domain.Review;
import com.sunset.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {

	// 전달 받은 id와 일치하는 리뷰 정보 얻어오기 
	@Autowired
	private ReviewRepository reviewRepository;
	
	// new_review 테이블에서 전달받은 id와 일치하는 행 조회 
	public Review getReview(int id) {
		Review review = reviewRepository.selectReview(id);
		return review;
	}
	
	
	// sellerId, 메뉴, 작성자, 별점, 리뷰 저장 기능 
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	// Review 객체를 통해 리뷰 정보를 저장하는 기능 
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;	
	}
	
	
	// 리뷰 정보를 업데이트하는 기능 
	public int updateReviewById(int id, String review) {
		return reviewRepository.updateReviewById(id, review);
	}
	
	
	// 리뷰 정보를 삭제하는 기능 
	public int deleteReviewById(int id) {
		return reviewRepository.deleteReviewById(id);
	}
}
