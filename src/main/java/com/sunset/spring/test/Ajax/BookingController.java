package com.sunset.spring.test.Ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sunset.spring.test.Ajax.domain.Booking;
import com.sunset.spring.test.Ajax.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ajax/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/main")
	public String mainBooking() {
		return "ajax/bookingMain";
	}
	
	@GetMapping("/list")
	public String bookingList(Model model) {
		
		List<Booking> bookingList = bookingService.bookingList();
		
		model.addAttribute("bookingList", bookingList);
		
		return "/ajax/bookingList";
	}
	
	@GetMapping("/input")
	public String inputBooking() {
		return "ajax/bookingInput";
	}
	
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createBooking(
			@RequestParam("name") String name
			, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingService.addBooking(name, date, day, headcount, phoneNumber);
		
		// 성공실패 여부 
		// 성공 : {"result":"success"}
		// 실패 : {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			// 성공
			resultMap.put("result", "success");
		} else {
			// 실패
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteBooking(@RequestParam("id") int id) {
		
		int count = bookingService.deleteBooking(id);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
		
	}
	
	@GetMapping("/search")
	@ResponseBody
	public Map<String, Object> searchBooking(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		Booking booking = bookingService.getBooking(name, phoneNumber);
		
		// 조회 결과가 있는지 없는지를 명확히 구분 해서 response를 구성
		// 조회 성공 실패 여부를 response에 추가
		// 조회 성공시 : {"result":"success", "booking":{"name":"혜리", "date":"2024-02-26", "day":2, ....}
		// 조회 실패시 : {"result":"fail"}
		
		Map<String, Object> resultMap = new HashMap<>();
		
		if(booking != null) {
			// 조회 성공
			resultMap.put("result", "success");
			resultMap.put("booking", booking);
		} else {
			// 조회 실패
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
