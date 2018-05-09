package com.numarket.portal.service;

import com.numarket.pojo.TbUser;

public interface UserService {
	TbUser getUserByToken(String token);
}
