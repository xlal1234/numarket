package com.numarket.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.numarket.common.utils.HttpClientUtil;
import com.numarket.common.utils.JsonUtils;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.portal.pojo.Order;
import com.numarket.portal.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成taotaoResult
		TaotaoResult taotaoResult = TaotaoResult.format(json);
		if (taotaoResult.getStatus() == 200) {
			Object orderId = taotaoResult.getData();
			return orderId.toString();
		}
		return "";
	}

}

