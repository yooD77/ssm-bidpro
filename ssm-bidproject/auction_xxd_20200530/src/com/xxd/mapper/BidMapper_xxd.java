package com.xxd.mapper;

import java.util.List;

import com.xxd.pojo.Bid_xxd;

/**
 * 
 *@author xiaoxiaodan
 *@Description 拍品记录的数据库持久层
 *
 */
public interface BidMapper_xxd {
	/**
	 * 根据拍品id查询竞拍记录
	 *@param GoodsId_xxd
	 *@return
	 */
	public List<Bid_xxd> getBidByGoodsId(int GoodsId_xxd);
	
	/**
	 * 根据用户id查询竞拍记录
	 *@param userId_xxd
	 *@return
	 */
	public List<Bid_xxd> getBidByUserId(int UserId_xxd);
	
	/**
	 * 获取某拍品当前最高价
	 *@param GoodsId_xxd;
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
	 *@return
	 */
	public void delete(int GoodsId_xxd);
	

}
