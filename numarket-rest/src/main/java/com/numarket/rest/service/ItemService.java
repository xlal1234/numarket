package com.numarket.rest.service;

import com.numarket.common.utils.TaotaoResult;

public interface ItemService {
	TaotaoResult getItemBaseInfo(long itemId);
	TaotaoResult getItemDesc(long itemId);
	TaotaoResult getItemParam(long itemId);
}
