package com.sunset.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	
	 // 가장 최근에 삽입된 행 조회 
	 public User selectLastUser();

	 public int insertUser(
			 @Param("name") String name
			 , @Param("birthday") String birthday
			 , @Param("email") String email
			 , @Param("introduce") String introduce);
	 
	 public int insertUserByObject(User user);
	 
	// 전달받은 email 값을 가진 행의 개수 조회 
	public int selectCountEmail(@Param("email") String email);
}