package com.sunset.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {
	
	// 직접 만든 클래스의 객체를 response에 담는 페이지
	@RequestMapping("/3")
	public Person personResponse() {
		Person me = new Person("김인규", 32);
		
		return me;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Person> statusResponse() {
		Person me = new Person("김인규", 32);
		
		// HTTP Status Code
		// 200 OK
		// 404 Not Found : 페이지가 없음 (주소확인)
		// 405 Method Not Allow : 메소드가 일치 하지 않음 (Get, Post)
		// 400 Bad Request : 요청 잘못됨 (파라미터 일치 확인)
		// 500 Internal Server Error : 서버 에러 (클래스 자바 코드확인)
		
		// Status Code 수정 
		ResponseEntity<Person> entity = new ResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
		// 500 에러로 직접 지정 -> 일부러 에러로 보내는 예제
		// ResponseEntity로 만들면 → 상태 코드까지 내 마음대로 설정 가능
		
		return entity;
		
	}
}