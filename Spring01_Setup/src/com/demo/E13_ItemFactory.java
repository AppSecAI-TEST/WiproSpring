package com.demo;

import com.dto.Item;

public class E13_ItemFactory {
	public static Item createItemOfType(String type) {
		if ("mobile".equals(type) || "laptop".equals(type)) {
			Item item = new Item();
			item.setName(type);
			return item;
		} else {
			throw new IllegalArgumentException("Unknown product");
		}
	}
}
