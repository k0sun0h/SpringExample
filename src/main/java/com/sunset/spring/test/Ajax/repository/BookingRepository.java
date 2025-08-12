package com.sunset.spring.test.Ajax.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.test.Ajax.domain.Booking;

@Mapper
public interface BookingRepository {

	public List<Booking> selectBookingList();
	
	public int insertBooking(
			@Param("name") String name
			, @Param("date") Date date
			, @Param("headcount") int headcount
			, @Param("day") int day
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state);
	
	public int deleteBooking(@Param("id") int id);
	
	public Booking selectBooking(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
	
}
