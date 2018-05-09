package com.numarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbItem;
import com.numarket.service.ItemParamService;
import com.numarket.service.ItemService;

@Controller

public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemParamService itemParamService;
	@RequestMapping("/item/{itemId}") 
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		System.out.println("itemId: " + itemId);
		TbItem tbItem = itemService.getItemById(itemId);
		
		
		return tbItem;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	@RequestMapping(value = "/item/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		TaotaoResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
	@RequestMapping("item/param/list")
	@ResponseBody
	public EUDataGridResult getItemParamList(@RequestParam(defaultValue = "1") Integer page,
											@RequestParam(defaultValue = "30") Integer rows) {
		EUDataGridResult result = itemParamService.getItemParamList(page, rows);
		return result;
	}
}
