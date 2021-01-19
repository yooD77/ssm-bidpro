package com.xxd.pojo;

import java.util.Date;
import java.util.List;

/**
 * 
 *@author xiaoxiaodan
 *@Description 拍品实体类
 *
 */
public class Goods_xxd {
	private int GoodsId_xxd;
	private int UserId_xxd;
	private String GoodsName_xxd;
	private int GoodsPrice_xxd;
	private String GoodsPic_xxd;
	private Date GoodsStartTime_xxd;
	private Date GoodsEndTime_xxd;
	private String GoodsDesc_xxd;
	private List<Bid_xxd> bid_xxd;
	private List<Goods_xxd> goods_xxd;
	
	public int getGoodsId_xxd() {
		return GoodsId_xxd;
	}
	public void setGoodsId_xxd(int goodsId_xxd) {
		GoodsId_xxd = goodsId_xxd;
	}
	
	public int getUserId_xxd() {
		return UserId_xxd;
	}
	public void setUserId_xxd(int userId_xxd) {
		UserId_xxd = userId_xxd;
	}
	public String getGoodsName_xxd() {
		return GoodsName_xxd;
	}
	public void setGoodsName_xxd(String goodsName_xxd) {
		GoodsName_xxd = goodsName_xxd;
	}
	public int getGoodsPrice_xxd() {
		return GoodsPrice_xxd;
	}
	public void setGoodsPrice_xxd(int goodsPrice_xxd2) {
		GoodsPrice_xxd = goodsPrice_xxd2;
	}
	public Date getGoodsStartTime_xxd() {
		return GoodsStartTime_xxd;
	}
	public void setGoodsStartTime_xxd(Date goodsStartTime_xxd) {
		GoodsStartTime_xxd = goodsStartTime_xxd;
	}
	public Date getGoodsEndTime_xxd() {
		return GoodsEndTime_xxd;
	}
	public void setGoodsEndTime_xxd(Date goodsEndTime_xxd) {
		GoodsEndTime_xxd = goodsEndTime_xxd;
	}
	public String getGoodsPic_xxd() {
		return GoodsPic_xxd;
	}
	public void setGoodsPic_xxd(String goodsPic_xxd) {
		GoodsPic_xxd = goodsPic_xxd;
	}
	public String getGoodsDesc_xxd() {
		return GoodsDesc_xxd;
	}
	public void setGoodsDesc_xxd(String goodsDesc_xxd) {
		GoodsDesc_xxd = goodsDesc_xxd;
	}
	public List<Bid_xxd> getBid_xxd() {
		return bid_xxd;
	}
	public void setBid_xxd(List<Bid_xxd> bid_xxd) {
		this.bid_xxd = bid_xxd;
	}

	public List<Goods_xxd> getGoods_xxd() {
		return goods_xxd;
	}
	public void setGoods_xxd(List<Goods_xxd> goods_xxd) {
		this.goods_xxd = goods_xxd;
	}
	
	

}
