package com.xxd.service;

import java.util.List;

import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 *@author xiaoxiaodan
 *@Description 用户业务逻辑层
 *
 */
public interface UserService_xxd {

	/**
	 * 获取某页用户信息
	 *@param page
	 *@return
	 */
	public List<User_xxd> getUserByOnPage(Page_xxd page_xxd);
	/**
	 * 判断是否为本系统用户
	 *@param userName_xxd
	 *@return
	 */
	public String isUser(String userName_xxd);
	
	/**
	 * 判断用户是否存在
	 *@param userName_xxd
	 *@return
	 */
	public int checkuseNameIsExist(String userName_xxd);
	
	/**
	 * 增加用户
	 *@param user_xxd
	 */
	public void insert(User_xxd user_xxd);
	
	/**
	 * 修改用户信息
	 *@param goods_xxd
	 */
	public void update(User_xxd user_xxd);
	
	/**
	 * 根据userId_xxd返回用户信息
	 *@param userId_xxd
	 *@return
	 */
	public User_xxd getUserdByUserId(int userId_xxd);
	
	/**
	 * 根据useName_xxd和upwd返回用户信息
	 *@param  User_xxd
	 *@return
	 */
	public User_xxd getUserByUnAndUpw(User_xxd user_xxd);
	

}
