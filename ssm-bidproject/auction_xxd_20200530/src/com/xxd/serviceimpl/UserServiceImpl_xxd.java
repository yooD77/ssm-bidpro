package com.xxd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxd.mapper.UserMapper_xxd;
import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.service.UserService_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 *@author xiaoxiaodan 
 *@Description 用户业务逻辑层实现
 *
 */
@Service
public class UserServiceImpl_xxd implements UserService_xxd{

	@Autowired
	UserMapper_xxd usermapper_xxd;
	
	public List<User_xxd> getUserByOnPage(Page_xxd page_xxd) {
		return usermapper_xxd.getUserByOnePage(page_xxd);
	}

	public String isUser(String userName_xxd) {
		return usermapper_xxd.isUser(userName_xxd);
	}


	public void insert(User_xxd user_xxd) {
		usermapper_xxd.insert(user_xxd);
	}

	public void update(User_xxd user_xxd) {
		usermapper_xxd.update(user_xxd);
	}

	public User_xxd getUserdByUserId(int userId_xxd) {
		return usermapper_xxd.getUserByUserId(userId_xxd);
	}

	public User_xxd getUserByUnAndUpw(User_xxd user_xxd) {
		return usermapper_xxd.getUserByUnAndUpw(user_xxd);
	}

	public int checkuseNameIsExist(String userName_xxd) {
		return usermapper_xxd.checkuseNameIsExist(userName_xxd);
	}




}
