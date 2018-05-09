package com.numarket.portal.service;

import com.numarket.portal.pojo.SearchResult;

public interface SearchService {
	
	SearchResult search(String queryString, int page);
}
