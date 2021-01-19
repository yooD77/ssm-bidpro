<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加拍品</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body id="reg_main">
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="logoutServlet_xxd" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form action="publishServlet_xxd" method="post" name="publish" onsubmit="return check(this)">
          <dl>
            <dd >
              <label>名称：</label>
              <input name="GoodsName_xxd" type="text" class="inputh lf" value="" />
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input name="GoodsPrice_xxd" type="number" class="inputh lf" value="" />
           
            </dd>
         
            <dd>
              <label>开始时间：</label>
              <input name="GoodsSTime_xxd"  type="date"  class="inputh lf" value="2020-05-27" />
              
            </dd>
            <dd>
              <label>结束时间：</label>
              <input name="GoodsETime_xxd"  type="date" class="inputh lf" value="2020-08-07" />
            
            </dd>
            <dd class="dds">
              <label>拍卖品图片：</label>
               <div class="lf salebd">  <input name="GoodsPic_xxd" type="file" class="offset10 lf" /></div>
                         
            </dd>
             <dd class="dds">
              <label>描述：</label>
              <textarea name="GoodsDesc_xxd" cols="" rows="" class="textarea"></textarea>
            </dd>
            <dd class="hegas">
                <input name="sive_xxd" type="submit" value="保 存" class="spbg buttombg buttombgs buttomb f14 lf" />
                <input name="cancel_xxd" type="reset" value="重置" class="spbg buttombg buttombgs buttomb f14 lf" />
            	<a href="toPesServlet_xxd">返回</a>
            </dd>
          </dl>
          </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 <script>
 function check(publish) {
		if (publish.GoodsName_xxd.value == "") {
			alert("拍品的名称不能为空");
			publish.GoodsName_xxd.focus();
			return false;
		}
		if (publish.GoodsPrice_xxd.value == "") {
			alert("起拍价不能为空");
			publish.GoodsPrice_xxd.focus();
			return false;
		}
		if (publish.GoodsSTime_xxd.value == "") {
			alert("拍品的开始时间不能为空");
			publish.GoodsSTime_xxd.focus();
			return false;
		}
		if (publish.GoodsETime_xxd.value == "") {
			alert("拍品的结束时间起拍价不能为空");
			publish.GoodsETime_xxd.focus();
			return false;
		}
		if (publish.GoodsPic_xxd.value == "") {
			alert("拍品的照片不能为空");
			publish.GoodsPic_xxd.focus();
			return false;
		}
		if (publish.GoodsDesc_xxd.value == "") {
			alert("拍品的描述不能为空");
			publish.GoodsDesc_xxd.focus();
			return false;
		}
 }
 </script>

</body>

</html>