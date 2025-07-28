package com.sunset.spring.test.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.test.mvc.domain.Realtor;
import com.sunset.spring.test.mvc.repository.RealtorRepository;

@Service
public class RealtorService {

	@Autowired
	private RealtorRepository realtorRepository;
	
	public int addRealtor(Realtor realtor) {
		int count = realtorRepository.insertRealtor(realtor);
		
		return count;
	}
	
}