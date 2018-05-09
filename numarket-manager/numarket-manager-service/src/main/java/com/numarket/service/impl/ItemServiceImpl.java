package com.numarket.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.numarket.common.pojo.EUDataGridResult;
import com.numarket.common.utils.IDUtils;
import com.numarket.common.utils.TaotaoResult;
import com.numarket.mapper.TbItemDescMapper;
import com.numarket.mapper.TbItemMapper;
import com.numarket.mapper.TbItemParamItemMapper;
import com.numarket.mapper.TbItemParamMapper;
import com.numarket.pojo.TbItem;
import com.numarket.pojo.TbItemDesc;
import com.numarket.pojo.TbItemExample;
import com.numarket.pojo.TbItemExample.Criteria;
import com.numarket.pojo.TbItemParam;
import com.numarket.pojo.TbItemParamExample;
import com.numarket.pojo.TbItemParamItem;
import com.numarket.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemDescMapper;
	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Autowired
	private TbItemParamMapper itemParamMapper;
	@Override
	public TbItem getItemById(long itemId) {
		
		TbItemExample example = new TbItemExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andIdEqualTo(itemId);
		
		List<TbItem> list = itemMapper.selectByExample(example);
		System.out.println(list.get(0).toString());
		if(list != null && list.size() > 0) {
			TbItem item = list.get(0);
			return item;
		}
		return null;
		
	}
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;

	}
	@Override
	public TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception {
		
		Long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		
		itemMapper.insert(item);
		
		TaotaoResult result = insertItemDesc(itemId, desc);
		if(result.getStatus() != 200) {
			throw new Exception();
		}
		result = insertItemParamItem(itemId, itemParam);
		if(result.getStatus() != 200) {
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	
	private TaotaoResult insertItemDesc(Long itemId, String desc) {
		TbItemDesc itemDesc = new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		return TaotaoResult.ok();
	}
	private TaotaoResult insertItemParamItem(Long itemId, String itemParam) {
		//创建一个pojo
		TbItemParamItem itemParamItem = new TbItemParamItem();
		itemParamItem.setItemId(itemId);
		itemParamItem.setParamData(itemParam);
		itemParamItem.setCreated(new Date());
		itemParamItem.setUpdated(new Date());
		//向表中插入数据
		itemParamItemMapper.insert(itemParamItem);
		
		return TaotaoResult.ok();
		
	}
	
}
