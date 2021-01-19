package com.xxd.service;

import java.util.List;

import com.xxd.pojo.Bid_xxd;

/**
 * 
 *@author xiaoxiaodan 
 *@Description 拍品记录业务逻辑层
 *
 */

public interface BidService_xxd {
	
	/**
	 *根据拍品id查询竞拍记录
	 *@param GoodsId
	 *@return
	 */
	public List<Bid_xxd> getBidByGoodsId(int GoodsId_xxd);

	/**
	 * 根据用户Id查询竞拍记录
	 *@param UserId
	 *@return
	 */
	public List<Bid_xxd> getBidByUserId(int UserId_xxd);
	
	/**
	 * 获取某拍品当前最高价
	 *@param  GoodsId
	 *@return
	 */
	public int getHighestPriceByGoodsId(int GoodsId_xxd);
	
	/**
	 * 竞拍某拍品
	 *@param Bid_xxd
	 *@return
	 */
	public void insert(Bid_xxd bid_xxd);
	
	/**
	 * 删除相关拍品信息记录
	 *@param GoodsId_xxd
	 */
	public void delete(int GoodsId_xxd);
}
