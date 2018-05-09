package com.numarket.service;

import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbContent;

public interface ContentService {
	EUDataGridResult getItemParamList(Long categoryId, int page, int rows);
	TaotaoResult insertContent(TbContent content);
	
	
}
