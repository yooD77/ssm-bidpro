package com.xxd.mapper;

import java.util.List;

import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 *@author xiaoxiaodan
 *@Description 用户信息的数据库持久层
 *
 */
public interface UserMapper_xxd {
	
	/**
	 * 获取某个用户信息
	 *@param page_xxd
	 *@return
	 */
	public List<User_xxd> getUserByOnePage(Page_xxd page_xxd);
	/**
	 * 判断是否为本系统用户
	 *@param UserName_xxd
	 *@return
	 */
	public String isUser(String UserName_xxd);
	
	
	/**
	 * 判断用户名是否存在
	 *@param UserName_xxd
	 *@return
	 */
	public int checkuseNameIsExist(String userName_xxd);
	
	/**
	 * 增加用户
	 *@param user_xxd
	 *@return
	 */
	public void insert(User_xxd user_xxd);
	
	/**
	 * 修改拍品
	 *@param Goods_xxd
	 */
	public void update(User_xxd user_xxd);
	/**
	 * 根据userId返回用户信息
	 *@param userId
	 *@return
	 */
	public User_xxd getUserByUserId(int UserId_xxd);
	
	/**
	 * 根据uerName和userpassword返回用户信息
	 *@param User_xxd
	 *@return
	 */
	public User_xxd getUserByUnAndUpw(User_xxd user_xxd);
	
}
