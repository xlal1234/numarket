package com.numarket.rest.service;

import java.util.List;

import com.numarket.pojo.TbContent;

public interface ContentService {
	List<TbContent> getContentList(long contentCid);
}
