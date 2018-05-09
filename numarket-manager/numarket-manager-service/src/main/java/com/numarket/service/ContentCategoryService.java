package com.numarket.service;

import java.util.List;

import com.numarket.common.pojo.EUTreeNode;
import com.numarket.common.utils.TaotaoResult;

public interface ContentCategoryService {
	List<EUTreeNode> getCategoryList(long parentId);
	TaotaoResult insertContentCategory(long parentId, String name);
	TaotaoResult deleteContentCategory(long id );
	TaotaoResult renameContentCategory(long id, String name);
}
