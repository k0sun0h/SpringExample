package com.sunset.spring.test.lifecycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunset.spring.ex.lifecycle.Person;

@RestController  // @Controller + @ResponseBody
@RequestMapping("/lifecycle/test02")
public class Test01RestController {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> listMapResponse() {
		List<Map<String, Object>> movieList = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("title", "기생충");
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("rate", 15);
		
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인생은 아름다워");
		movie.put("director", "로베르토 베니니");
		movie.put("time", 116);
		movie.put("rate", 0);
		
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "인셉션");
		movie.put("director", "크리스토퍼 놀란");
		movie.put("time", 147);
		movie.put("rate", 12);
		
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		movie.put("director", "윤종빈");
		movie.put("time", 133);
		movie.put("rate", 19);
		
		movieList.add(movie);
		
		movie = new HashMap<>();
		movie.put("title", "헝거게임");
		movie.put("director", "프란시스 로렌스");
		movie.put("time", 137);
		movie.put("rate", 15);
		
		movieList.add(movie);
		
		return movieList;
	}
	
	@RequestMapping("/2")
	public List<Post> postListResponse() {
		
		List<Post> postList = new ArrayList<>();
		
		Post post = new Post("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다."); // Post 클래스의 생성자를 사용해서 객체를 하나 만듬
		postList.add(post);
		
		postList.add(new Post("헐 대박", "bada", "오늘 목요일이었어... 금요일인줄"));
		postList.add(new Post("오늘 데이트 한 이야기 해드릴게요", "dulumary", "...."));
		
		return postList;
		
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Post> entityResponse() {
		Post post = new Post("안녕하세요 가입인사 드립니다.", "hagulu", "안녕하세요. 가입했어요. 앞으로 잘 부탁드립니다. 활동 열심히 하겠습니다.");
		
		// Status Code 수정 
		ResponseEntity<Post> entity = new ResponseEntity(post, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
		
	}
}