package com.dreamcode.demo.service;

import java.util.List;

import com.dreamcode.demo.entity.CategoryNode;

public interface SearchService {

	public CategoryNode getCategoryByName(String categoryName);

	public List<String> getCategoryKeywords(String categoryName);

	public int getCategoryLevel(String categoryName);
}
