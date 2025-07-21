package com.sunset.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	
	 // 가장 최근에 삽입된 행 조회 
	 public User selectLastUser();

}