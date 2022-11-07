package com.dreamcode.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class CategoryNode {

	private String name;
	private CategoryNode parent;
	private List<CategoryNode> children;
	private List<String> keywords;

	public CategoryNode(String name) {
		this.name = name;
		this.children = new ArrayList<>();
		this.keywords = new ArrayList<>();
	}

	public void addChild(CategoryNode child) {
		child.setParent(this);
		children.add(child);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryNode getParent() {
		return parent;
	}

	public void setParent(CategoryNode parent) {
		this.parent = parent;
	}

	public List<CategoryNode> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryNode> children) {
		this.children = children;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

}
