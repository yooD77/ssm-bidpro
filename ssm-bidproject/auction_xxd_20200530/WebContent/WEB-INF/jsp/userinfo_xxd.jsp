<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户修改个人信息页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>


<body id="reg_main">
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户信息修改</h1>
        <form action="mdfinfoSe_xxd" method="post" name="update_xxd" onsubmit="return check(this)">
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text" readonly="readonly"class="inputh lf" value="${sessionScope.user_xxd.userName_xxd}" name="UserName_xxd"/>
            </dd>
            <dd>
              <label> <small>*</small>手机号码</label>
              <input type="text" class="inputh lf" value="${sessionScope.user_xxd.tel_xxd}" name="tel_xxd"/><span>（必填）</span>
           
            </dd>
            
            
            <dd>
              <label> <small>*</small>电子邮件</label>
              <input type="text" class="inputh lf" value="${sessionScope.user_xxd.email_xxd}" name="email_xxd"/>
           
            </dd>
            
            <dd>
              <label> <small>*</small>家庭住址</label>
              <input type="text" class="inputh lf" value="${sessionScope.user_xxd.address_xxd}" name="address_xxd"/><span>（必填）</span>
           
            </dd>
            
         
            <dd class="hegas">
              <label>&nbsp;</label>
              <input onclick="return modify();"name="sive_xxd" type="submit" value="立即修改" class="spbg buttombg buttombgs f14 lf" />
              <input name="cancel_xxd" type="submit" value="取消" class="spbg buttombg buttombgs f14 lf" />
            </dd>
          </dl>
          
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 <script>
 function modify(){
	   if(confirm("你真的确认要修改吗？请确认")){
		   return true;
		   }
		   else{
			   return false;
			   }
	   }
 
 function check(update_xxd) {
		if (update_xxd.tel_xxd.value == "") {
			alert("修改的手机号码不能为空");
			update_xxd.tel_xxd.focus();
			return false;
		}
		if (update_xxd.address_xxd.value == "") {
			alert("修改的地址不能为空");
			update_xxd.address_xxd.focus();
			return false;
		}
 }
 </script>

</body>
</html>