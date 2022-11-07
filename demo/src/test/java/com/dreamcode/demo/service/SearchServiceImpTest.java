package com.dreamcode.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SearchServiceImpTest {

	@Autowired
	private SearchService searchService;

	@Test
	void categoryFoundTest() {
		assertNotNull(searchService.getCategoryByName("minor appliances"));
	}

	@Test
	void categoryNotFoundTest() {
		assertNull(searchService.getCategoryByName("other category"));
	}

	@Test
	void foundCategoryAndGetKeywordsTest() {
		List<String> keywords = searchService.getCategoryKeywords("minor appliances");
		assertEquals(2, keywords.size());
	}

	@Test
	void foundCategoryWithoutKeywordsAndGetParentKeywords() {
		List<String> parentKeywords = Arrays.asList("major", "appliances");
		List<String> keywords = searchService.getCategoryKeywords("general");
		assertEquals(parentKeywords, keywords);
	}

	@Test
	void findCategoryLevelTest() {
		assertEquals(3, searchService.getCategoryLevel("kitchen"));
	}
	
	@Test
	void notFoundCategoryLevelTest() {
		assertEquals(-1, searchService.getCategoryLevel("other category"));
	}

}
