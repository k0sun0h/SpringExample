package com.sunset.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunset.spring.ex.mybatis.domain.Review;
import com.sunset.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 전달 받은 id와 일치하는 리뷰 정보를 reponse에 json으로 담는다
	@RequestMapping("/")
	@ResponseBody
	public Review review(@RequestParam("id") int id) {
		
		// 전달 받은 id와 일치하는 리뷰 정보 얻어오기 
		Review review = reviewService.getReview(id);
		return review;
		
	}
	
	
	// 리뷰 한행을 추가하는 기능 
	@RequestMapping("/insert")
	@ResponseBody
	public String createReview() {
			
		// 4, 치즈피자, 김인규, 4.5, 치즈피자 존맛!
//		int count = reviewService.addReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 김인규, 4.0, 역시 뿌링클은 진리입니다
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("김인규");
		review.setPoint(4.0);
		review.setReview("역시 뿌링클은 진리입니다");
		
		int count = reviewService.addReviewByObject(review);
		
		return "수행결과 : " + count;
		
	}
	
	
	// 리뷰 정보를 업데이트하는 기능 
	@RequestMapping("/update")
	@ResponseBody
	public String updateReview(
			@RequestParam("id") int id,
			@RequestParam("review") String review) {
		
		int row = reviewService.updateReviewById(id, review);
		
		return "update 성공 " + row;
	}
	
	
	// 리뷰 정보를 삭제하는 기능 
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteReview(@RequestParam("id") int id) {
		
		int row = reviewService.deleteReviewById(id);
		
		return "delete 성공 " + row;
	}
}
