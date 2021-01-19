package com.xxd.pojo;

import java.util.Date;

/**
 * 
 *@author xiaoxiaodan
 *@Description 拍品记录实体类
 *
 */
public class Bid_xxd {
	private int id_xxd;
	private int UserId_xxd;
	private int GoodsId_xxd;
	private Date BidTime_xxd;
	private int BidPrice_xxd;
	private User_xxd user_xxd;
	private Goods_xxd goods_xxd;
	
	public int getId_xxd() {
		return id_xxd;
	}
	public void setId_xxd(int id_xxd) {
		this.id_xxd = id_xxd;
	}
	public int getUserId_xxd() {
		return UserId_xxd;
	}
	public void setUserId_xxd(int userId_xxd) {
		UserId_xxd = userId_xxd;
	}
	public int getGoodsId_xxd() {
		return GoodsId_xxd;
	}
	public void setGoodsId_xxd(int goodsId_xxd) {
		GoodsId_xxd = goodsId_xxd;
	}
	public Date getBidTime_xxd() {
		return BidTime_xxd;
	}
	public void setBidTime_xxd(Date bidTime_xxd) {
		BidTime_xxd = bidTime_xxd;
	}
	public int getBidPrice_xxd() {
		return BidPrice_xxd;
	}
	public void setBidPrice_xxd(int bidPrice_xxd) {
		BidPrice_xxd = bidPrice_xxd;
	}
	public User_xxd getUser_xxd() {
		return user_xxd;
	}
	public void setUser_xxd(User_xxd user_xxd) {
		this.user_xxd = user_xxd;
	}
	public Goods_xxd getGoods_xxd() {
		return goods_xxd;
	}
	public void setGoods_xxd(Goods_xxd goods_xxd) {
		this.goods_xxd = goods_xxd;
	}
	
	
	
}
