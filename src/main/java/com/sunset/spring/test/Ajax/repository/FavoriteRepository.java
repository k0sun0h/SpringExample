package com.sunset.spring.test.Ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sunset.spring.test.Ajax.domain.Favorite;

@Mapper
public interface FavoriteRepository {

	public List<Favorite> selectFavoriteList();
	
	public int insertFavorite(
			@Param("name") String name
			, @Param("url") String url);
	
	// 1. url 중복 확인 기능
	public int selectCountUrl(@Param("url") String url);
	
	// 2. 삭제 기능
	public int deleteFavorite(@Param("id") int id);
	
}