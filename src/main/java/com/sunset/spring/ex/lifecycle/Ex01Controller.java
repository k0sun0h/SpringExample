package com.sunset.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	// 간단한 html을 response에 담는 페이지
    @ResponseBody
    @RequestMapping("/lifecycle/ex01/1")
    public String response() {
        return ""
        		+ "<html>\n"
        		+ "    <head><title>Spring</title></head>\n"
        		+ "    <body>\n"
        		+ "        <h2>Spring html response</h2>\n"
        		+ "    </body>\n"
        		+ "</html>";
    }
    
    // Map을 response에 담는 페이지 
    @RequestMapping("/lifecycle/ex01/2")
	@ResponseBody
	public Map<String, Integer> mapResponse() {
		
		// 과일이름 : 가격 
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 4500);
		fruitMap.put("orange", 1300);
		
		return fruitMap;
	}
}