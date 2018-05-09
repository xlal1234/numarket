package com.numarket.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;

import com.numarket.common.utils.TaotaoResult;
import com.numarket.portal.pojo.CartItem;

public interface CartService {
	TaotaoResult addCartItem(long itemId, int num, 
			HttpServletRequest request, HttpServletResponse response);
	 List<CartItem> getCartItemList(HttpServletRequest request, 
			 HttpServletResponse response); 
	 TaotaoResult updateNum(long itemId, int num,
				HttpServletRequest request, HttpServletResponse response);
	TaotaoResult deleteCartItem(long itemId, 
			HttpServletRequest request, HttpServletResponse response);
}
