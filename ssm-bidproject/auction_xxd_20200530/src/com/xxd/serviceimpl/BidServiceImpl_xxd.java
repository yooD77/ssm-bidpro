package com.xxd.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxd.mapper.BidMapper_xxd;
import com.xxd.pojo.Bid_xxd;
import com.xxd.service.BidService_xxd;
/**
 * 
 *@author xiaoxiaodan 
 *@Description 拍品记录业务逻辑层实现
 *
 */
@Service
public class BidServiceImpl_xxd implements BidService_xxd{
	@Autowired
	BidMapper_xxd bidmapper_xxd;
	
	public List<Bid_xxd> getBidByGoodsId(int GoodsId_xxd) {
		return bidmapper_xxd.getBidByGoodsId(GoodsId_xxd);
	}

	public List<Bid_xxd> getBidByUserId(int UserId_xxd) {
		return bidmapper_xxd.getBidByUserId(UserId_xxd);
	}

	public int getHighestPriceByGoodsId(int GoodsId_xxd) {
		return bidmapper_xxd.getHighestPriceByGoodsId(GoodsId_xxd);
	}

	public void insert(Bid_xxd bid_xxd) {
		bidmapper_xxd.insert(bid_xxd);
	}

	public void delete(int GoodsId_xxd) {
		bidmapper_xxd.delete(GoodsId_xxd);
	}

}
