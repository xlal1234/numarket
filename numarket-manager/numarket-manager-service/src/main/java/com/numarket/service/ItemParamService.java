package com.numarket.service;

import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbItemParam;

public interface ItemParamService {
	TaotaoResult getItemParamByCid(long cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
	EUDataGridResult getItemParamList(int page, int rows);
}
