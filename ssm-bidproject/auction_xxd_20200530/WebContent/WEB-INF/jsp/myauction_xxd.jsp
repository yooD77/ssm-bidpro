<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心管理</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body id="list_main">
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	    <div class="logout right"><a href="logoutServlet_xxd" title="注销">注销</a></div>
	  <div class="logout right"><a href="addServlet_xxd" title="发布">发布</a></div>
	  <div class="logout right"><a href="AlllistServlet_xxd" title="拍卖中心">拍卖中心</a></div>
	  <div class="logout right"><a href="tomodifyServlet_xxd?UserId_xxd=${sessionScope.UserId_xxd}" title="个人信息">个人信息</a></div>
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
	        <li>${goods_xxd.goodsName_xxd}</li>
        	<li class="list-wd">${goods_xxd.goodsDesc_xxd}</li>
	        <li>${goods_xxd.goodsStartTime_xxd}</li>
	        <li>${goods_xxd.goodsEndTime_xxd}</li>
	        <li>${goods_xxd.goodsPrice_xxd}</li>
	        <li class="borderno red">
	        
	        <a href="pergoodsServlet_xxd?GoodsId_xxd=${goods_xxd.goodsId_xxd}" title="查看" >查看</a>
	         <a href="alterServlet_xxd?GoodsId_xxd=${goods_xxd.goodsId_xxd}" title="修改" >修改</a>
	         <a href="delServlet_xxd?GoodsId_xxd=${goods_xxd.goodsId_xxd}" title="下架" onclick="return abc();">下架</a>
	         
	        </li>
	      </ul>
	  </c:forEach>

  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){
	    
		   return true;
		 }
		 else{
			 return false;
			 }
			 
	   };
	 
  </script>
<!-- main end-->
</div>
</body>

</html>