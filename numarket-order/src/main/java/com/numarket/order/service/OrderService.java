package com.numarket.order.service;

import java.util.List;

import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbOrder;
import com.numarket.pojo.TbOrderItem;
import com.numarket.pojo.TbOrderShipping;

public interface OrderService {
	TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}
