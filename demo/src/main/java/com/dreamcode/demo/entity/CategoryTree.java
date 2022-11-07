package com.dreamcode.demo.entity;

import java.util.List;

public class CategoryTree {

	private CategoryNode root;

	public CategoryTree(CategoryNode root) {
		this.setRoot(root);
	}

	public CategoryNode getRoot() {
		return root;
	}

	public void setRoot(CategoryNode root) {
		this.root = root;
	}

	public CategoryNode findCategory(String categoryName) {
		return findCategory(root, categoryName);
	}

	private CategoryNode findCategory(CategoryNode node, String categoryName) {
		if (node == null) {
			return null;
		}

		if (node.getName().equalsIgnoreCase(categoryName)) {
			return node;
		} else {
			CategoryNode cnode = null;
			for (CategoryNode child : node.getChildren()) {
				if ((cnode = findCategory(child, categoryName)) != null) {
					return cnode;
				}
			}
		}
		return null;
	}

	public int searchLevel(List<CategoryNode> children, String categoryName, int initialLevel) {

		int level = initialLevel;

		for (CategoryNode child : children) {
			if (child.getName().equalsIgnoreCase(categoryName)) {
				return level;
			} else {
				if (!child.getChildren().isEmpty()) {
					level = level + 1;
					return searchLevel(child.getChildren(), categoryName, level);
				}
			}
		}

		return -1;
	}

}
