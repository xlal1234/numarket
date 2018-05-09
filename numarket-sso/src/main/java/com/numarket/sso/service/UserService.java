package com.numarket.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.numarket.common.utils.TaotaoResult;
import com.numarket.pojo.TbUser;

public interface UserService {
	TaotaoResult checkData(String content, Integer type);

	TaotaoResult createUser(TbUser user);

	TaotaoResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);

	TaotaoResult getUserByToken(String token);
	
	
}	
