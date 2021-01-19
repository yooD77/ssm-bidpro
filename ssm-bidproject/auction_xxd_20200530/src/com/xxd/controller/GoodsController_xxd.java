package com.xxd.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xxd.pojo.Bid_xxd;
import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.service.BidService_xxd;
import com.xxd.service.GoodsService_xxd;
import com.xxd.util.Page_xxd;

/**
 * 
 * @author xiaoxiaodan
 * @Description 拍品控制器
 *
 */
@Controller
@RequestMapping("")
public class GoodsController_xxd {
	@Autowired
	GoodsService_xxd goodsservice_xxd;
	@Autowired
	BidService_xxd bidservice_xxd;

	/**
	 * 查询某页拍品列表
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("onePageServlet_xxd")
	public ModelAndView getOnePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int curPage = Integer.parseInt(request.getParameter("curPage"));
		Page_xxd page_xxd = (Page_xxd) session.getAttribute("page_xxd");
		page_xxd.setCurPage(curPage);
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		User_xxd user_xxd = (User_xxd) session.getAttribute("user_xxd");
		if (user_xxd.getUserIsAdmin_xxd() == 0) {
			mav.setViewName("list_xxd");
			return mav;
		} else {
			mav.setViewName("list_xxd");
			return mav;
		}
	}
	
	/**
	 * 游客查询某页拍品列表
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("touronePageServlet_xxd")
	public ModelAndView tourisegetOnePage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int curPage = Integer.parseInt(request.getParameter("curPage"));
		Page_xxd page_xxd = (Page_xxd) session.getAttribute("page_xxd");
		page_xxd.setCurPage(curPage);
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		mav.setViewName("main_xxd");
		return mav;
		
	}
	
	/**
	 * 拍卖中心所有拍品列表
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("AlllistServlet_xxd")
	public ModelAndView getAlllist(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		Page_xxd page_xxd = new Page_xxd();
		page_xxd.setCount(10);
		page_xxd.caculatemaxPage(goodsservice_xxd.total());
		page_xxd.caculateStart();
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
		session.setAttribute("page_xxd", page_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		mav.setViewName("list_xxd");
		return mav;
		}

	/**
	 * 获取拍品信息
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("goodsServlet_xxd")
	public ModelAndView getGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int GoodsId_xxd = Integer.parseInt(request.getParameter("GoodsId_xxd"));
		Goods_xxd goods_xxd = goodsservice_xxd.getGoodsById(GoodsId_xxd);
		List<Bid_xxd> bidList_xxd = bidservice_xxd.getBidByGoodsId(GoodsId_xxd);
		int highestPrice_xxd = 0;
		if (!bidList_xxd.isEmpty()) {
			highestPrice_xxd = bidservice_xxd.getHighestPriceByGoodsId(GoodsId_xxd);
		} else {
			highestPrice_xxd = goods_xxd.getGoodsPrice_xxd();
		}
		session.setAttribute("goods_xxd", goods_xxd);
		session.setAttribute("highestPrice_xxd", highestPrice_xxd);
		session.setAttribute("bidList_xxd", bidList_xxd);
		mav.setViewName("auction_xxd");
		return mav;
	}
	/**
	 * 获取搜索的拍品
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("selectgoodsServlet_xxd")
	public ModelAndView getGoodsName(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String GoodsName_xxd = request.getParameter("GoodsName_xxd");
		String selectOnclik_xxd = request.getParameter("selectOnclik_xxd");
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByInput(GoodsName_xxd);
		if(selectOnclik_xxd != null){
			session.setAttribute("goodsList_xxd", goodsList_xxd);
			if(goodsList_xxd.size() == 0 ||null == goodsList_xxd){
				session.setAttribute("messege", "没有搜索到相关拍品！");
				//System.out.println("运行了列表为空时-----------");
				mav.setViewName("inputselect_xxd");
				return mav;
			}else{
			session.setAttribute("messege", null);	
			//System.out.println(goodsList_xxd.size()+"---------------");
			mav.setViewName("inputselect_xxd");
			return mav;
		}		
		}
		mav.setViewName("list_xxd");
		return mav;
		
	}
	
	/**
	 * 获取搜索的拍品
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("TouriseSelServlet_xxd")
	public ModelAndView getGoodsmessage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		String GoodsName_xxd = request.getParameter("GoodsName_xxd");
		String selectOnclik_xxd = request.getParameter("selectOnclik_xxd");
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByInput(GoodsName_xxd);
		if(selectOnclik_xxd != null){
			session.setAttribute("goodsList_xxd", goodsList_xxd);
			if(goodsList_xxd.size() == 0 ||null == goodsList_xxd){
				session.setAttribute("messege", "没有搜索到相关拍品！");
				mav.setViewName("TouriseInput_xxd");
				return mav;
		}else {
			session.setAttribute("messege", null);
			mav.setViewName("TouriseInput_xxd");
			return mav;
		}
		}
		mav.setViewName("main_xxd");
		return mav;
		
	}
	
	/**
	 * 拍卖中心所有拍品列表
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("touriseallServlet_xxd")
	public ModelAndView tourisgetAll(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		Page_xxd page_xxd = new Page_xxd();
		page_xxd.setCount(10);
		page_xxd.caculatemaxPage(goodsservice_xxd.total());
		page_xxd.caculateStart();
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
		session.setAttribute("page_xxd", page_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		mav.setViewName("main_xxd");
		return mav;
		}

	/**
	 * 获取拍品人信息
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("pergoodsServlet_xxd")
	public ModelAndView getperGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int GoodsId_xxd = Integer.parseInt(request.getParameter("GoodsId_xxd"));
		Goods_xxd goods_xxd = goodsservice_xxd.getGoodsById(GoodsId_xxd);
		List<Bid_xxd> bidList_xxd = bidservice_xxd.getBidByGoodsId(GoodsId_xxd);
		session.setAttribute("goods_xxd", goods_xxd);
		session.setAttribute("bidList_xxd", bidList_xxd);
		mav.setViewName("perauction_xxd");
		return mav;
	}
	
	/**
	 * 跳转到个人上传拍品页面
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("toPesServlet_xxd")
	public ModelAndView toPerGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		User_xxd user_xxd = (User_xxd) session.getAttribute("user_xxd");
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByUserId(user_xxd.getUserId_xxd());
		int UserId_xxd = user_xxd.getUserId_xxd();
		session.setAttribute("UserId_xxd", UserId_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		mav.setViewName("myauction_xxd");
		return mav;
	}
	
	/**
	 * 获取个人拍品信息
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("PergoodsServlet_xxd")
	public ModelAndView getPerGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int UserId_xxd = (int) session.getAttribute("userId_xxd");
		Goods_xxd goods = (Goods_xxd) session.getAttribute("goods_xxd");
		System.out.println(UserId_xxd+"******************");
		Goods_xxd goods_xxd = (Goods_xxd) goodsservice_xxd.getGoodsById(goods.getGoodsId_xxd());
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByUserId(UserId_xxd);
		session.setAttribute("goods_xxd", goods_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);
		mav.setViewName("myauction_xxd");
		return mav;
	}
	
	/**
	 * 游客获取拍品信息
	 * 
	 * @param reqeust response session
	 * @return
	 */
	@RequestMapping("tourisegoodsServlet_xxd")
	public ModelAndView tourisegetGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int GoodsId_xxd = Integer.parseInt(request.getParameter("GoodsId_xxd"));
		Goods_xxd goods_xxd = goodsservice_xxd.getGoodsById(GoodsId_xxd);
		List<Bid_xxd> bidList_xxd = bidservice_xxd.getBidByGoodsId(GoodsId_xxd);
		double highestPrice_xxd = 0.0;
		if (!bidList_xxd.isEmpty()) {
			highestPrice_xxd = bidservice_xxd.getHighestPriceByGoodsId(GoodsId_xxd);
		} else {
			highestPrice_xxd = goods_xxd.getGoodsPrice_xxd();
		}
		session.setAttribute("goods_xxd", goods_xxd);
		session.setAttribute("hightestPrice_xxd", highestPrice_xxd);
		session.setAttribute("bidList_xxd", bidList_xxd);
		mav.setViewName("touriseauction_xxd");
		return mav;
	}

	/**
	 * 跳转到添加拍品页面
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("addServlet_xxd")
	public ModelAndView addGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("add_xxd");
		return mav;
	}

	/**
	 * 调价拍品
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("publishServlet_xxd")
	public ModelAndView publishiGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sive_xxd = request.getParameter("sive_xxd");
		String cancel_xxd = request.getParameter("cancel_xxd");
		Goods_xxd goods_xxd = new Goods_xxd();
		if (sive_xxd != null) {
			User_xxd user_xxd = (User_xxd) session.getAttribute("user_xxd");
			String GoodsName_xxd = request.getParameter("GoodsName_xxd");
			int GoodsPrice_xxd = Integer.valueOf(request.getParameter("GoodsPrice_xxd"));
			String GoodsPic_xxd = request.getParameter("GoodsPic_xxd");
			Date GoodsSTime_xxd = java.sql.Date.valueOf(request.getParameter("GoodsSTime_xxd"));
			Date GoodsETime_xxd = java.sql.Date.valueOf(request.getParameter("GoodsETime_xxd"));
			String GoodsDesc_xxd = request.getParameter("GoodsDesc_xxd");
			goods_xxd.setUserId_xxd(user_xxd.getUserId_xxd());
			goods_xxd.setGoodsName_xxd(GoodsName_xxd);
			goods_xxd.setGoodsPrice_xxd(GoodsPrice_xxd);
			goods_xxd.setGoodsPic_xxd(GoodsPic_xxd);
			goods_xxd.setGoodsStartTime_xxd(GoodsSTime_xxd);
			goods_xxd.setGoodsEndTime_xxd(GoodsETime_xxd);
			goods_xxd.setGoodsDesc_xxd(GoodsDesc_xxd);
			goodsservice_xxd.insert(goods_xxd);

			Page_xxd page_xxd = (Page_xxd) session.getAttribute("page_xxd");
			page_xxd.caculatemaxPage(goodsservice_xxd.total());

			List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
			session.setAttribute("page_xxd", page_xxd);
			session.setAttribute("goodsList_xxd", goodsList_xxd);
			mav.setViewName("list_xxd");

		} else if (cancel_xxd != null) {
			mav.setViewName("myauction_xxd");
		}
		return mav;
	}

	/**
	 * 删除拍品
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("delServlet_xxd")
	public ModelAndView delGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		int GoodsID_xxd = Integer.parseInt(request.getParameter("GoodsId_xxd"));
		bidservice_xxd.delete(GoodsID_xxd);
		goodsservice_xxd.delete(GoodsID_xxd);

		Page_xxd page_xxd = (Page_xxd) session.getAttribute("page_xxd");
		page_xxd.caculatemaxPage(goodsservice_xxd.total());
		if (page_xxd.getMaxPage() < page_xxd.getCurPage()) {
			page_xxd.setCurPage(page_xxd.getMaxPage());
		}
		List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
		session.setAttribute("page_xxd", page_xxd);
		session.setAttribute("goodsList_xxd", goodsList_xxd);

		mav.setViewName("list_xxd");
		return mav;
	}

	/**
	 * 跳转到修改界面
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("alterServlet_xxd")
	public ModelAndView alterGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		int GoodsId_xxd = Integer.parseInt(request.getParameter("GoodsId_xxd"));
		Goods_xxd goods_xxd = goodsservice_xxd.getGoodsById(GoodsId_xxd);
		session.setAttribute("goods_xxd", goods_xxd);
		mav.setViewName("update_xxd");
		return mav;
	}

	/**
	 * 修改拍品
	 * 
	 * @param request response session
	 * @return
	 */
	@RequestMapping("updateServlet_xxd")
	public ModelAndView updateGoods(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sive_xxd = request.getParameter("sive_xxd");
		String cancel_xxd = request.getParameter("cancel_xxd");
		Goods_xxd gds = (Goods_xxd) session.getAttribute("goods_xxd");
		if (sive_xxd != null) {
			Goods_xxd goods_xxd = new Goods_xxd();
			String GoodsName_xxd = request.getParameter("GoodsName_xxd");
			int GoodsPrice_xxd = Integer.valueOf(request.getParameter("GoodsPrice_xxd"));
			String GoodsPic_xxd = request.getParameter("GoodsPic_xxd");
			Date GoodsSTime_xxd = java.sql.Date.valueOf(request.getParameter("GoodsSTime_xxd"));
			Date GoodsETime_xxd = java.sql.Date.valueOf(request.getParameter("GoodsETime_xxd"));
			String GoodsDesc_xxd = request.getParameter("GoodsDesc_xxd");
			goods_xxd.setGoodsId_xxd(gds.getGoodsId_xxd());
			goods_xxd.setGoodsName_xxd(GoodsName_xxd);
			goods_xxd.setGoodsPrice_xxd(GoodsPrice_xxd);
			goods_xxd.setGoodsPic_xxd(GoodsPic_xxd);
			goods_xxd.setGoodsStartTime_xxd(GoodsSTime_xxd);
			goods_xxd.setGoodsEndTime_xxd(GoodsETime_xxd);
			goods_xxd.setGoodsDesc_xxd(GoodsDesc_xxd);

			goodsservice_xxd.update(goods_xxd);
			Page_xxd page_xxd = (Page_xxd) session.getAttribute("page_xxd");
			List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
			session.setAttribute("goodsList_xxd", goodsList_xxd);
			mav.setViewName("list_xxd");
			return mav;
		} else if(cancel_xxd != null) {
			mav.setViewName("myauction_xxd");
			return mav;
		}
		mav.setViewName("list_xxd");
		return mav;
	}

	/**
	 * 导出拍品信息
	 * 
	 * @param request response session
	 * @return IOException
	 *//*
		 * @RequestMapping("exportExcelServlet_xxd") public void
		 * exportExcel(HttpServletRequest request,HttpServletResponse response,
		 * HttpSession session) throws IOException{
		 * 
		 * List<Goods_xxd> list = goodsservice_xxd.getGoods();
		 * 
		 * HSSFWorkbook wb = goodsservice_xxd.export(list);
		 * response.setContentType("application/vnd.ms-excel");
		 * response.setHeader("Content-disposition", "attachment;filename=auction.xls");
		 * OutputStream ouputStream = response.getOutputStream(); wb.write(ouputStream);
		 * ouputStream.flush(); ouputStream.close();
		 * 
		 * }
		 */
}
