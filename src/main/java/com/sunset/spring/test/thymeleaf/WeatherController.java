package com.sunset.spring.test.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunset.spring.test.thymeleaf.domain.Weather;
import com.sunset.spring.test.thymeleaf.service.WeatherService;

@RequestMapping("/thymeleaf/weather")
@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		// 날씨 리스트 얻어오기 
		List<Weather> weatherHistory = weatherService.getWeatherHistory();
		
		model.addAttribute("weatherList", weatherHistory);
		
		return "thymeleaf/weatherList";
	}
	
	@GetMapping("/input")
	public String weatherInput(Model model) {
		return "thymeleaf/weatherInput";
	}
	
	@GetMapping("/insert")
	public String insertWeather(@ModelAttribute Weather weather) {

		weatherService.addWeatherByObject(weather);
		
		return "redirect:/thymeleaf/weather/list";	
	}
}
