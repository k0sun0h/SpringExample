package com.sunset.spring.test.Ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunset.spring.test.Ajax.domain.Favorite;
import com.sunset.spring.test.Ajax.repository.FavoriteRepository;

@Service
public class FavoriteService {
	
	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> getFavoriteList() {
		
		List<Favorite> favoriteList = favoriteRepository.selectFavoriteList();
		
		return favoriteList;
	}
	
	public int addFavorite(String name, String url) {
		
		int count = favoriteRepository.insertFavorite(name, url);
		
		return count;
	}
	
	// 1. url 중복 확인 기능
	public boolean isDuplicateUrl(String url) {
		
		int count = favoriteRepository.selectCountUrl(url);
		
		return count >= 1;
		
	}
	
	// 2. 삭제 기능
	public int deleteFavorite(int id) {
		
		int count = favoriteRepository.deleteFavorite(id);
		
		return count;
		
	}
	
}