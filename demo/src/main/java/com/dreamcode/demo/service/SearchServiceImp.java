package com.dreamcode.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamcode.demo.entity.CategoryNode;
import com.dreamcode.demo.entity.CategoryTree;

import java.util.Collections;

@Service
public class SearchServiceImp implements SearchService {

	private CategoryService categoryService;
	private CategoryTree tree;

	@Autowired
	public SearchServiceImp(CategoryService categoryService) {
		this.categoryService = categoryService;
		this.tree = new CategoryTree(this.categoryService.getRoot());
	}

	@Override
	public CategoryNode getCategoryByName(String categoryName) {
		return tree.findCategory(categoryName);
	}

	@Override
	public List<String> getCategoryKeywords(String categoryName) {
		CategoryNode category = getCategoryByName(categoryName);
		if (category == null) {
			return Collections.emptyList();
		}
		return category.getKeywords().isEmpty() ? category.getParent().getKeywords() : category.getKeywords();
	}

	@Override
	public int getCategoryLevel(String categoryName) {
		if (tree.getRoot().getName().equalsIgnoreCase(categoryName)) {
			return 0;
		}
		return tree.searchLevel(tree.getRoot().getChildren(), categoryName, 1);
	}

}
