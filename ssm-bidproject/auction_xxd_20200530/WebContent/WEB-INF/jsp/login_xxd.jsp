<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登陆页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body id="bg_main">
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebarg fnone">
     <form class="loginForm" action="loginning_xxd" method="post" >
    <div class="login">
      <dl>
        <dt>用户登陆</dt>
        <dd><label for="UserName_xxd">用户名：</label><input type="text" class="inputh"  id="UserName_xxd" name="UserName_xxd"/></dd>
        <dd><label for="pwd_xxd">密 码：</label><input type="password" class="inputh" value="" id="pwd_xxd" name="pwd_xxd"/></dd>
       	<dd><label for="checkpassword_xxd">验证码：</label><input type="text" name="check_xxd" class="inputh">  
	       <img   
	           alt=""   
	           src="<%= request.getContextPath() %>/authImage_xxd"  
	           align="bottom"  
	           title="看不清可单击图片刷新"   
	           onclick="this.src='<%= request.getContextPath() %>/authImage_xxd?d='+Math.random();"  
	       />  
       	</dd>
        <dd class="buttom">
           <input name="login_xxd" type="submit" value="登 录" class="spbg buttombg buttomb f14 lf" />
           <input name="reg_xxd" type="submit" value="注 册" class="spbg buttombg buttomb f14 lf" />
         <a class="clj" href="tourise_xxd" >随便逛逛</a>
          
           <div class="cl"></div>
        </dd>
       	
       	<dd>
       		 <font color="red">  
			    <%= request.getSession().getAttribute("message") == null   
			        ? "" : request.getSession().getAttribute("message")   
			    %>  
    		</font>  
       	</dd>
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->
 
</html>