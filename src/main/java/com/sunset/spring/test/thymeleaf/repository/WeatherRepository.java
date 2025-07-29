package com.sunset.spring.test.thymeleaf.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.test.thymeleaf.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeatherHistory();

	public int insertWeatherByObject(Weather weather);
}
