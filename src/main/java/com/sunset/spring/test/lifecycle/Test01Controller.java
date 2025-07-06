package com.sunset.spring.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/lifecycle/test01")
public class Test01Controller {
	
	// 2. String 출력하기
	@ResponseBody
	@RequestMapping("/1")
	public String response() {
        return ""
        		+ "<html>\n"
        		+ "    <head><title>Spring</title></head>\n"
        		+ "    <body>\n"
        		+ "        <h2>테스트 프로젝트 완성</h2>\n"
        		+ "        <div>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</div>\n"
        		+ "    </body>\n"
        		+ "</html>";
    }
	
	// 3. Map JSON 출력
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Integer> mapResponse() {
		
		// 과목 : 점수 
		Map<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
		
	}
}