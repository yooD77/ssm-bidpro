<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>拍卖品列表</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body id="list_main">
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
    	
    	<div class="tourise_head">
    		<div class="tipclj"><a class="red" href="tourisereg_xxd">您当前为游客模式，想要进行拍卖操作需要进行登录，点击我前去注册！</a></div>
	     <div class="inputselect"><form action="TouriseSelServlet_xxd" method="post" name="select">
	   <input type="text" name="GoodsName_xxd" placeholder="请输入拍品名称"/>
	    <button class="btnse" name="selectOnclik_xxd" type="submit">搜索</button>
	    
	    </form>
	    </div>
	    </div>
  </div>

  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      
      <c:forEach var="goods_xxd" items="${sessionScope.goodsList_xxd}">
      	  <ul class="rows">
	        <li><a href="goodsServlet_xxd?GoodsId_xxd=${goods_xxd.goodsId_xxd}" title="">${goods_xxd.goodsName_xxd}</a></li>
	        <li class="list-wd">${goods_xxd.goodsDesc_xxd}</li>
	        <li>${goods_xxd.goodsStartTime_xxd}</li>
	        <li>${goods_xxd.goodsEndTime_xxd}</li>
	        <li>${goods_xxd.goodsPrice_xxd}</li>
	        <li class="borderno red"><a href="tourisegoodsServlet_xxd?GoodsId_xxd=${goods_xxd.goodsId_xxd}">竞拍</a></li>
	      </ul>  
      </c:forEach>
    
     <div class="page">
        <a href="touronePageServlet_xxd?curPage=1" title="">首页</a>
        
        <c:if test="${sessionScope.page_xxd.curPage > 1}">
        	<a href="touronePageServlet_xxd?curPage=${sessionScope.page_xxd.curPage-1}" title="">上一页</a>
        </c:if>
        <c:if test="${sessionScope.page_xxd.curPage == 1}">
        	<a title="">上一页</a>
        </c:if>
        
        <c:if test="${sessionScope.page_xxd.curPage < sessionScope.page_xxd.maxPage}">
        	<a href="touronePageServlet_xxd?curPage=${sessionScope.page_xxd.curPage+1}" title="">下一页</a>
        </c:if>
        
        <c:if test="${sessionScope.page_xxd.curPage == sessionScope.page_xxd.maxPage}">
        	<a title="">下一页</a>
        </c:if>
        
        <a href="touronePageServlet_xxd?curPage=${sessionScope.page_xxd.maxPage}" title="">尾页</a> 
    </div>
  </div>
<!-- main end-->
</div>
</body>
</html>