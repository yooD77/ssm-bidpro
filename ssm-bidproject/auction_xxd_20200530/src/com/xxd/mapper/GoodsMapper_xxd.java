package com.xxd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxd.pojo.Goods_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 *@author xiaoxiaodan
 *@Description 拍品的数据库持久层
 *
 */
public interface GoodsMapper_xxd {
	/**
	 * 获取某也拍品信息
	 *@param page_xxd
	 *@return
	 */
	public List<Goods_xxd> getGoodsByOnePage(Page_xxd page_xxd);
	
	/**
	 * 获取全部拍拍信息
	 *@param Goods_xxd
	 *@return
	 */
	public List<Goods_xxd> getAllGoods();
	
	/**
	 * 通过输入商品名称查询到相关商品
	 *@param 
	 *@return
	 */
	public List<Goods_xxd> getGoodsByInput(@Param("GoodsName_xxd") String GoodsName_xxd);
	
	/**
	 * 通过用户id获得上传了的拍品
	 *@param 
	 *@return
	 */
	public List<Goods_xxd> getGoodsByUserId(int UserId_xxd);
	/**
	 * 根据Id获取某件商品信息
	 *@param GoodsId_xxd
	 *@return
	 */
	public Goods_xxd getGoodsByGoodsId(int GoodsId_xxd);
	
	/**
	 * 增加拍品
	 *@param Goods_xxd
	 */
	public void insert(Goods_xxd goods_xxd);
	
	/**
	 * 删除拍品
	 *@param Goods_xxd
	 */
	public void delete(int GoodsId_xxd);
	
	/**
	 * 修改拍品
	 *@param Goods_xxd
	 */
	public void update(Goods_xxd goods_xxd);
	
	/**
	 * 统计总拍品数
	 *@return
	 */
	public int total();
}
