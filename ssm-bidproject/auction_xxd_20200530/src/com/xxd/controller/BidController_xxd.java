package com.xxd.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xxd.pojo.Bid_xxd;
import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.service.BidService_xxd;
/**
 * 
 *@author xiaoxiaodan
 *@Description 拍品记录控制器
 *
 */
@Controller
@RequestMapping("")
public class BidController_xxd {
	@Autowired
	BidService_xxd bidservice_xxd;
	
	/**
	 * 竞拍拍品
	 *@param  request response session
	 *@return
	 */
	@RequestMapping("jingpaiServlet_xxd")
	public ModelAndView aucitongoods(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String BidPrice_xxd = request.getParameter("BidPrice_xxd");
		String refresh_xxd = request.getParameter("refresh_xxd");
		String returnList_xxd = request.getParameter("returnList_xxd");
		String returnperList_xxd = request.getParameter("returnperList_xxd");
		if(BidPrice_xxd != null) {
			if(request.getParameter("sale_xxd") == "") {
				mav.setViewName("auction_xxd");
				return mav;
			}
			int goodsprice_xxd = Integer.parseInt(request.getParameter("sale_xxd"));
			int highestPrice_xxd = goodsprice_xxd;
			session.setAttribute("highestPrice_xxd", highestPrice_xxd);
			Bid_xxd bid_xxd = new Bid_xxd();
			User_xxd user_xxd = (User_xxd) session.getAttribute("user_xxd");
			Goods_xxd goods_xxd = (Goods_xxd) session.getAttribute("goods_xxd");
			bid_xxd.setUserId_xxd(user_xxd.getUserId_xxd());
			bid_xxd.setGoodsId_xxd(goods_xxd.getGoodsId_xxd());
			bid_xxd.setBidTime_xxd(new java.sql.Date(new Date().getTime()));
			bid_xxd.setBidPrice_xxd(goodsprice_xxd);
			bidservice_xxd.insert(bid_xxd);
			List<Bid_xxd> bidList_xxd = bidservice_xxd.getBidByGoodsId(goods_xxd.getGoodsId_xxd());
			session.setAttribute("bidList_xxd", bidList_xxd);
			
			mav.setViewName("auction_xxd");
			return mav;
		}else if(returnList_xxd != null) {
			mav.setViewName("list_xxd");
			return mav;
		}else if(returnperList_xxd != null){
			mav.setViewName("myauction_xxd");
			return mav;
		}else if(refresh_xxd != null){
			mav.setViewName("perauction_xxd");
			return mav;
		}
		return mav;
	}
	
}
