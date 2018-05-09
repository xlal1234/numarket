package com.numarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbContent;
import com.numarket.service.ContentService;
@Controller
@RequestMapping("/content")
public class ContentController {
	@Autowired
	private ContentService contentService;
	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getItemParamList(Long categoryId, int page, int rows) {
		EUDataGridResult result = contentService.getItemParamList(categoryId, page, rows);
		return result;
	}
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		TaotaoResult result = contentService.insertContent(content);
		return result;
	}

}
