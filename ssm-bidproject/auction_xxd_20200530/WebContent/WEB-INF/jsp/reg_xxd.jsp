<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册页面</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>


<body id="reg_main">
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
        <form action="register_xxd" method="post" name="reg_xxd" onsubmit="return check(this)">
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text" class="inputh lf" value="" name="UserName_xxd"/><span>
              <font color="red">  
			    <%= request.getSession().getAttribute("messages") == null   
			        ? "" : request.getSession().getAttribute("messages")   
			    %>  
    		</font>
    		</span>
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input type="password" class="inputh lf" value="" name="pwd_xxd"/>
           
            </dd>
           
            <dd>
              <label> <small>*</small>确认密码</label>
              <input type="password" class="inputh lf" value="" name="userPasswordCheck_xxd" onkeyup="validate()"/><span id="msg"></span>
           
            </dd>
            
            <dd>
              <label> <small>*</small>手机号码</label>
              <input type="text" class="inputh lf" value="" name="tel_xxd"/>
           
            </dd>
            
            
            <dd>
              <label> <small>*</small>电子邮件</label>
              <input type="text" class="inputh lf" value="" name="email_xxd"/>
           
            </dd>
            
            <dd>
              <label> <small>*</small>家庭住址</label>
              <input type="text" class="inputh lf" value="" name="address_xxd"/>
           
            </dd>
            
         
            <dd class="hegas">
              <label>&nbsp;</label>
              <input id="submit" type="submit" value="立即注册" class="spbg buttombg buttombgs f14 lf" />
              <input id="reset" type="reset" value="重置" class="spbg buttombg buttombgs f14 lf" />
              <a href="">返回</a>
            </dd>
          </dl>
          
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
   <script>
  function validate(){
		var pw1 = document.reg_xxd.pwd_xxd.value;
	  	var pw2 = document.reg_xxd.userPasswordCheck_xxd.value;
	   if(pw1 == pw2){
		   document.getElementById("msg").innerHTML="<font color='green'>密码相同</font>";
		   document.getElementById("submit").disabled = false;
	   }
	   else{
		   document.getElementById("msg").innerHTML="<font color='red'>密码不相同</font>";
		   document.getElementById("submit").disabled = true;
	   }
   };
   
   function check(reg_xxd) {
		if (reg_xxd.pwd_xxd.value == "") {
			alert("密码不能为空");
			reg_xxd.pwd_xxd.focus();
			return false;
		}
		if (reg_xxd.userPasswordCheck_xxd.value == "") {
			alert("确认密码不能为空");
			reg_xxd.userPasswordCheck_xxd.focus();
			return false;
		}
		if (reg_xxd.tel_xxd.value == "") {
			alert("手机号码不能为空");
			reg_xxd.tel_xxd.focus();
			return false;
		}
		if (reg_xxd.address_xxd.value == "") {
			alert("家庭住址不能为空");
			reg_xxd.address_xxd.focus();
			return false;
		}
   }
  
   
  </script>
</body>
</html>