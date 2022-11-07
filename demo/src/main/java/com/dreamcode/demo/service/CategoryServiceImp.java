package com.dreamcode.demo.service;

import org.springframework.stereotype.Service;

import com.dreamcode.demo.entity.CategoryNode;
import com.dreamcode.demo.repository.CategoryRepository;

@Service
public class CategoryServiceImp implements CategoryService {

	@Override
	public CategoryNode getRoot() {
		return new CategoryRepository().getRoot();
	}

}
