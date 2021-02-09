package com.java_shoppingTest;

import java.util.ArrayList;

public class Category {
	private String categoryName;
	private ArrayList<String> item;
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
		this.item = new ArrayList<String>();
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategory() {
		return categoryName; 
	}
	
	public void showItem() {
		if(item.size() != 0) {
			for(int index=0; index < item.size(); index++)
				System.out.println(item.get(index));			
		} else {
			System.out.println("Don't find Item");			
		}
	}
	
	public String getItem(int index) {
		String itemName = item.get(index);
		return itemName;
	}
	
	public void addItem(String name) {
		if(!item.contains(name)) {
			item.add(name);
			System.out.println("Success add item");			
		} else {
			System.out.println("Duplicate");
		}	
	}
}
