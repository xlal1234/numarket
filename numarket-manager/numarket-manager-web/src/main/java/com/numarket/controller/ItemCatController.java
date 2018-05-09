package com.numarket.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.numarket.common.pojo.EUTreeNode;
import com.numarket.pojo.TbItemCat;
import com.numarket.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	//@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/list")
	@ResponseBody
	private List<EUTreeNode> getCatList(@RequestParam(value="id", defaultValue="0" )Long parentId){
		//List catList = new ArrayList();
		List<EUTreeNode> list = itemCatService.getCatList(parentId);
		/*for(TbItemCat tbItemCat : list) {
			Map node = new HashMap();
			node.put("id", tbItemCat.getId());
			node.put("text", tbItemCat.getName());
			node.put("state", tbItemCat.getIsParent()?"closed" : "open");
			catList.add(node);
		}*/
		return list;
	}
}
