package com.numarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.numarket.common.pojo.EUTreeNode;


public interface ItemCatService {
	List<EUTreeNode> getCatList(long parentId);
}
