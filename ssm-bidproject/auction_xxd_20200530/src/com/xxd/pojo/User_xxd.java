package com.xxd.pojo;
import java.util.List;

/**
 * 
 *@author xiaoxiaodan
 *@Description 用户实体类
 *
 */
public class User_xxd {
	private int UserId_xxd;
	private String UserName_xxd;
	private String pwd_xxd;
	private String tel_xxd;
	private String email_xxd;
	private String address_xxd;
	private int userIsAdmin_xxd;
	private List<Bid_xxd> bid_xxd;
	private List<Goods_xxd> goods_xxd;
	private List<User_xxd> usr_xxd;
	
	
	

	public List<User_xxd> getUsr_xxd() {
		return usr_xxd;
	}

	public void setUsr_xxd(List<User_xxd> usr_xxd) {
		this.usr_xxd = usr_xxd;
	}
	public List<Goods_xxd> getGoods_xxd() {
		return goods_xxd;
	}
	public void setGoods_xxd(List<Goods_xxd> goods_xxd) {
		this.goods_xxd = goods_xxd;
	}
	public int getUserId_xxd() {
		return UserId_xxd;
	}
	public void setUserId_xxd(int userId_xxd) {
		UserId_xxd = userId_xxd;
	}
	public String getUserName_xxd() {
		return UserName_xxd;
	}
	public void setUserName_xxd(String userName_xxd) {
		UserName_xxd = userName_xxd;
	}
	public String getpwd_xxd() {
		return pwd_xxd;
	}
	public void setpwd_xxd(String userpassword_xxd) {
		this.pwd_xxd = userpassword_xxd;
	}
	public String getTel_xxd() {
		return tel_xxd;
	}
	public void setTel_xxd(String tel_xxd) {
		this.tel_xxd = tel_xxd;
	}
	public String getEmail_xxd() {
		return email_xxd;
	}
	public void setEmail_xxd(String email_xxd) {
		this.email_xxd = email_xxd;
	}
	public String getAddress_xxd() {
		return address_xxd;
	}
	public void setAddress_xxd(String address_xxd) {
		this.address_xxd = address_xxd;
	}
	public int getUserIsAdmin_xxd() {
		return userIsAdmin_xxd;
	}
	public void setUserIsAdmin_xxd(int userIsAdmin_xxd) {
		this.userIsAdmin_xxd = userIsAdmin_xxd;
	}
	public List<Bid_xxd> getBid_xxd() {
		return bid_xxd;
	}
	public void setBid_xxd(List<Bid_xxd> bid_xxd) {
		this.bid_xxd = bid_xxd;
	}
	
	

	
	
	
}
