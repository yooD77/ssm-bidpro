package com.xxd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xxd.util.VerifyCodeUtils;
import com.xxd.pojo.Goods_xxd;
import com.xxd.pojo.User_xxd;
import com.xxd.service.GoodsService_xxd;
import com.xxd.service.UserService_xxd;
import com.xxd.util.Page_xxd;
/**
 * 
 *@author xiaoxiaodan
 *@Description 用户控制器
 * 
 */
@Controller
@RequestMapping("")
public class UserController_xxd {
	@Autowired
	UserService_xxd userservice_xxd;
	@Autowired
	GoodsService_xxd goodsservice_xxd;
	
	/**
	 * 登陆页面
	 *@return
	 */
	@RequestMapping("")
	public ModelAndView view(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login_xxd");
		return mav;
	}
	
	/**
	 * 登陆或者注册
	 *@param request response session
	 *@return
	 */
	@RequestMapping("loginning_xxd")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		ModelAndView mav = new ModelAndView();
		String login_xxd = request.getParameter("login_xxd");
		String reg_xxd = request.getParameter("reg_xxd");
		String check_xxd = request.getParameter("check_xxd");
		String rand_xxd = (String)session.getAttribute("rand_xxd");
		session.setAttribute("messages", null);
		rand_xxd = rand_xxd.toLowerCase();
		check_xxd = check_xxd.toLowerCase();
		if(login_xxd != null) {
			if(check_xxd.equals(rand_xxd)) {
				User_xxd user_xxd = new User_xxd();
				String UserName_xxd = request.getParameter("UserName_xxd");
				String pwd_xxd = userservice_xxd.isUser(UserName_xxd);
				if(request.getParameter("pwd_xxd") == null){
					session.setAttribute("message", "请输入密码！");
					mav.setViewName("login_xxd");
					return mav;
				}
				if(request.getParameter("pwd_xxd").equals(pwd_xxd)){
					user_xxd.setUserName_xxd(UserName_xxd);
					user_xxd.setpwd_xxd(pwd_xxd);
					user_xxd = userservice_xxd.getUserByUnAndUpw(user_xxd);
					session.setAttribute("user_xxd", user_xxd);
					
					Page_xxd page_xxd = new Page_xxd();
					
					if(user_xxd.getUserIsAdmin_xxd() == 0){
						page_xxd.setCount(10);
						page_xxd.caculatemaxPage(goodsservice_xxd.total());
						page_xxd.caculateStart();
						List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
						session.setAttribute("page_xxd", page_xxd);
						session.setAttribute("goodsList_xxd", goodsList_xxd);
						session.setAttribute("message", null);
						mav.setViewName("list_xxd");
						return mav;
					}else {
						page_xxd.setCount(5);
						page_xxd.caculatemaxPage(goodsservice_xxd.total());
						page_xxd.caculateStart();
						List<Goods_xxd> goodsList_xxd = goodsservice_xxd.getGoodsByOnePage(page_xxd);
						session.setAttribute("page_xxd", page_xxd);
						session.setAttribute("goodsList_xxd", goodsList_xxd);
						mav.setViewName("auctionmanager_xxd");
						return mav;
					}
				}else {
					session.setAttribute("message", "账号或密码错误！");
					mav.setViewName("login_xxd");
					return mav;
				}
			}else {
				session.setAttribute("message", "验证码错误");
				mav.setViewName("login_xxd");
				return mav;
			}
		}else {
			mav.setViewName("reg_xxd");
			return mav;
		}
	}
	
	/**
	 * 注册
	 *@param request response session 
	 *@return
	 */
	@RequestMapping("register_xxd")
	public ModelAndView reg(HttpServletRequest request,HttpServletResponse response, HttpSession session)throws ServletException, IOException {
		ModelAndView mav = new ModelAndView();
		String userName_xxd = request.getParameter("UserName_xxd");
		String pwd_xxd =request.getParameter("pwd_xxd");
		String userPassWordCheck_xxd = request.getParameter("userPasswordCheck_xxd");
		String tel_xxd =request.getParameter("tel_xxd");
		String email_xxd =request.getParameter("email_xxd");
		String address_xxd =request.getParameter("address_xxd");
		User_xxd user_xxd = new User_xxd();
		
		if(userName_xxd ==null || userName_xxd == ""){
			session.setAttribute("messages", "用户名不能为空！");
			mav.setViewName("reg_xxd");
			return mav;
		}
		int x = userservice_xxd.checkuseNameIsExist(userName_xxd);
		if(x > 0){
			session.setAttribute("messages", "用户名已存在！");
			mav.setViewName("reg_xxd");
			return mav;
		}else if(pwd_xxd.equals(userPassWordCheck_xxd)) {
			user_xxd.setUserName_xxd(userName_xxd);
			user_xxd.setpwd_xxd(pwd_xxd);
			user_xxd.setTel_xxd(tel_xxd);
			user_xxd.setEmail_xxd(email_xxd);
			user_xxd.setAddress_xxd(address_xxd);
			user_xxd.setUserIsAdmin_xxd(0);
			userservice_xxd.insert(user_xxd);
			mav.setViewName("login_xxd");
			return mav;
		}else{
			mav.setViewName("reg_xxd");
			return mav;
		}
		
	}
	
	/**
	 * 跳转修改个人信息页面
	 *@return 
	 */
	@RequestMapping("tomodifyServlet_xxd")
	public ModelAndView tomodifyinfo(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		int UserId_xxd= Integer.parseInt(request.getParameter("UserId_xxd"));
		System.out.println(UserId_xxd+"-------------------------");
		User_xxd user_xxd = userservice_xxd.getUserdByUserId(UserId_xxd);
		session.setAttribute("user_xxd", user_xxd);
		mav.setViewName("userinfo_xxd");
		return mav;
	}
	
	/**
	 * 修改个人信息页面
	 *@return modifyinfoServlet_xxd
	 */
	@RequestMapping("mdfinfoSe_xxd")
	public ModelAndView modifyinfo(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		ModelAndView mav = new ModelAndView();
		
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception e) {
			e.printStackTrace();
		}
		String sive_xxd = request.getParameter("sive_xxd");
		String cancel_xxd = request.getParameter("cancel_xxd");
		User_xxd use = (User_xxd) session.getAttribute("user_xxd");
		if(sive_xxd != null) {
			User_xxd user_xxd = new User_xxd();
			String tel_xxd = request.getParameter("tel_xxd");
			String email_xxd = request.getParameter("email_xxd");
			String address_xxd = request.getParameter("address_xxd");
			user_xxd.setUserId_xxd(use.getUserId_xxd());
			user_xxd.setUserName_xxd(use.getUserName_xxd());
			user_xxd.setpwd_xxd(use.getpwd_xxd());
			user_xxd.setTel_xxd(tel_xxd);
			user_xxd.setEmail_xxd(email_xxd);
			user_xxd.setAddress_xxd(address_xxd);
			user_xxd.setUserIsAdmin_xxd(use.getUserIsAdmin_xxd());
			userservice_xxd.update(user_xxd);
			mav.setViewName("myauction_xxd");
			return mav;
		}else if(cancel_xxd != null) {
			mav.setViewName("myauction_xxd");
			return mav;
		}
		mav.setViewName("userinfo_xxd");
		return mav;
	}
	/**
	 * 游客模式
	 *@param 
	 *@return
	 */
	@RequestMapping("tourise_xxd")
	public ModelAndView tourist(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
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
	 * 游客进行注册
	 */
	@RequestMapping("tourisereg_xxd")
	public ModelAndView touristreg() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("reg_xxd");
		return mav;
		
	}
	
	/**
	 * 注销
	 *@param request response session 
	 *@return
	 */
	@RequestMapping("logoutServlet_xxd")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.setAttribute("user_xxd", null);
		session.setAttribute("page_xxd", null);
		session.setAttribute("goodsList_xxd", null);
		session.setAttribute("bidList_xxd", null);
		mav.setViewName("login_xxd");
		return mav;
	}
	
	
	/**
	 * 验证码图片
	 *@param request response 
	 *@throws ServletException IOException
	 */
	@RequestMapping("authImage_xxd")
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  response.setHeader("Pragma", "No-cache");    
	        response.setHeader("Cache-Control", "no-cache");    
	        response.setDateHeader("Expires", 0);    
	        response.setContentType("image/jpeg");    
	            
	        //生成随机字串    
	        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);    
	        //存入会话session    
	        HttpSession session = request.getSession(true);    
	        session.setAttribute("rand_xxd", verifyCode.toLowerCase());    
	        //生成图片    
	        int w = 100, h = 30;    
	        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
	}
}

