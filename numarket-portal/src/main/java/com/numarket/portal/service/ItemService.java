package com.numarket.portal.service;

import com.numarket.portal.pojo.ItemInfo;

public interface ItemService {
	ItemInfo getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParam(Long itemId);
}
