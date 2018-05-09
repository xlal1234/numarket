package com.numarket.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.numarket.search.pojo.SearchResult;

public interface SearchDao {
	SearchResult search(SolrQuery query) throws Exception;
}
