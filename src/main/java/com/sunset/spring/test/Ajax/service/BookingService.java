package com.sunset.spring.test.Ajax.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.test.Ajax.domain.Booking;
import com.sunset.spring.test.Ajax.repository.BookingRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	public List<Booking> bookingList() {
		
		List<Booking> bookingList = bookingRepository.selectBookingList();
		
		return bookingList;
		
	}
	
	public int addBooking(
			String name
			, Date date
			, int headcount
			, int day
			, String phoneNumber) {
		
		int count = bookingRepository.insertBooking(name, date, headcount, day, phoneNumber, "대기중");
		
		return count;
		
	}
	
	public int deleteBooking(int id) {
		
		int count = bookingRepository.deleteBooking(id);
		
		return count;
		
	}
	
	public Booking getBooking(String name, String phoneNumber) {
		
		Booking booking = bookingRepository.selectBooking(name, phoneNumber);
		
		return booking;
	}

}
