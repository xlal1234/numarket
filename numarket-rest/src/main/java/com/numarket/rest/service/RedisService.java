package com.numarket.rest.service;

import com.numarket.common.utils.TaotaoResult;

public interface RedisService {
	TaotaoResult syncContent(long contentCid);
}
