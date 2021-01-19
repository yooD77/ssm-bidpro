<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>拍品信息</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body id="reg_main">
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="" title="登录">登录</a></div>
    
  </div>
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${sessionScope.goods_xxd.goodsName_xxd}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${sessionScope.goods_xxd.goodsDesc_xxd}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${sessionScope.goods_xxd.goodsStartTime_xxd}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${sessionScope.goods_xxd.goodsEndTime_xxd}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${sessionScope.goods_xxd.goodsPrice_xxd}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="${sessionScope.goods_xxd.goodsPic_xxd}" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  
  <form action="tourise_xxd" method="post" name="saled">
	  <div class="top10 salebd">
	       <p>
	       <label for="sale_xxd">出价：</label>
	       <input type="number"  class="inputwd" id="sale_xxd" name="sale_xxd" value="" onkeyup="validate_xxd()"/>
	      
	       </p>
	       <p class="f14 red" id="msg"></p>
	  </div>
	  <div class="top10">
	    <input name="refresh" type="submit" value="刷 新" disabled="true" class="spbg buttombg f14" />
	    <input name="returnList_xxd" type="submit" value="返回列表" class="spbg buttombg f14" />
	  </div>
  </form>
  <div class="offer">
    <h3>出价记录</h3>
    <div class="items sg-font">
      <ul class="rows even strong">
        <li>竞拍时间</li>
        <li>竞拍价格</li>
        <li class="borderno">竞拍人</li>
      </ul>
      
      <c:forEach var="bid_xxd" items="${sessionScope.bidList_xxd}">
	      <ul class="rows">
	        <li>${bid_xxd.bidTime_xxd}</li>
	        <li>${bid_xxd.bidPrice_xxd}</li>
	        <li class="borderno">${bid_xxd.user_xxd.userName_xxd}</li>
	      </ul>
	  </c:forEach>
  </div>
  </div>
<!-- main end-->
</div>


   <script>
   function validate_xxd(){
	   alert("竞价失败，您当前尚未进行登录无法进行竞价！")
   }
  </script>
  
</body>

</html>