package com.example.firstproject;

import java.util.ArrayList;

public class ItemBO {
	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// 
	public static ArrayList getItems() {
		ArrayList list = new ArrayList();
		ItemBO item;

		item = new ItemBO();
		item.setName("item 1");
		item.setDescription("desc 1");
		list.add(item);

		item = new ItemBO();
		item.setName("item 2");
		item.setDescription("desc 2");
		list.add(item);

		item = new ItemBO();
		item.setName("item 3");
		item.setDescription("desc 3");
		list.add(item);

		return list;
	}
}
