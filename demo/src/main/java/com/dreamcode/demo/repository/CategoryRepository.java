package com.dreamcode.demo.repository;

import com.dreamcode.demo.entity.CategoryNode;

public class CategoryRepository {

	public CategoryNode getRoot() {
		CategoryNode root = new CategoryNode("products");

		CategoryNode furniture = new CategoryNode("furniture");
		furniture.getKeywords().add("furniture");
		furniture.getKeywords().add("sofa");
		root.addChild(furniture);
		CategoryNode electronics = new CategoryNode("electronics");
		electronics.getKeywords().add("electronics");
		electronics.getKeywords().add("tv");
		electronics.getKeywords().add("radio");
		root.addChild(electronics);
		CategoryNode homeAppliances = new CategoryNode("home appliances");
		homeAppliances.getKeywords().add("home appliances");
		homeAppliances.getKeywords().add("home");
		CategoryNode majorAppliances = new CategoryNode("major appliances");
		majorAppliances.getKeywords().add("major");
		majorAppliances.getKeywords().add("appliances");
		CategoryNode kitchen = new CategoryNode("kitchen");
		kitchen.getKeywords().add("kitchen");
		kitchen.getKeywords().add("stove");
		kitchen.getKeywords().add("refrigerator");
		majorAppliances.addChild(kitchen);
		CategoryNode general = new CategoryNode("general");
//		general.getKeywords().add("general");
//		general.getKeywords().add("products"); // for testing purpose
		majorAppliances.addChild(general);
		homeAppliances.addChild(majorAppliances);
		CategoryNode minorAppliances = new CategoryNode("minor appliances");
		minorAppliances.getKeywords().add("minor");
		minorAppliances.getKeywords().add("appliances");
		homeAppliances.addChild(minorAppliances);
		CategoryNode lawnGarden = new CategoryNode("lawn & garden");
		lawnGarden.getKeywords().add("lawn");
		lawnGarden.getKeywords().add("garden");
		lawnGarden.getKeywords().add("gardentools");
		homeAppliances.addChild(lawnGarden);
		root.addChild(homeAppliances);
		return root;
	}

}
