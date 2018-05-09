package com.numarket.service;

import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
