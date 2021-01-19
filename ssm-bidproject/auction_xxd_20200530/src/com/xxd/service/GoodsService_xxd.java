package com.xxd.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xxd.pojo.Goods_xxd;
import com.xxd.util.Page_xxd;


/**
 * 
 *@author xiaoxiaodan 
 *@Description 拍品业务逻辑层
 *
 */
public interface GoodsService_xxd {
	/**
	 * 获取某页拍品信息
	 *@param page
	 *@return
	 */
	public List<Goods_xxd> getGoodsByOnePage(Page_xxd page_xxd);
	
	/**
	 * 获取全部拍品信息
	 *@return
	 */
	public List<Goods_xxd> getGoods();
	
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
	 * 根据id获取某件拍品信息
	 *@param GoodsId_xxd
	 *@return
	 */
	public Goods_xxd getGoodsById(int GoodsId_xxd);
	
	/**
	 * 增加拍品
	 *@param goods_xxd
	 */
	public void insert(Goods_xxd goods_xxd);
	
	/**
	 * 删除拍品
	 *@param GoodsId_xxd
	 */
	public void delete(int GoodsId_xxd);
	
	/**
	 * 修改拍品
	 *@param goods_xxd
	 */
	public void update(Goods_xxd goods_xxd);
	
	/**
	 * 统计总拍品数
	 *@return
	 */
	public int total();
	
	/**
	 * 导出拍品信息
	 *@param list
	 *@return
	 */
	public HSSFWorkbook export(List<Goods_xxd> list);
}
