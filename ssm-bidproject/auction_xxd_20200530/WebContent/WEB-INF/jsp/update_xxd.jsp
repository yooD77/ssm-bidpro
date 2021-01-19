<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改拍卖信息</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="wrap">
  <!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="logoutServlet_xxd" title="注销">注销</a></div>
  </div>
      <div class="login logns produce">
        <h1 class="blues">拍卖品信息</h1>
        <form action="updateServlet_xxd" method="post" name="update" onsubmit="return check(this)">
          <dl>
            <dd >
              <label>名称：</label>
              <input name="GoodsName_xxd" type="text" class="inputh lf" value="${sessionScope.goods_xxd.goodsName_xxd}" />
              <div class="xzkbg spbg lf"></div>
            </dd>
            <dd>
              <label>起拍价：</label>
              <input name="GoodsPrice_xxd" type="number" class="inputh lf" value="${sessionScope.goods_xxd.goodsPrice_xxd}" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>底价：</label>
              <input name="endprice_xxd" type="text" class="inputh lf" value="5000.00" />
              <div class="lf red laba">必须为数字</div>
            </dd>
            <dd>
              <label>开始时间：</label>
              <input name="GoodsSTime_xxd"  type="date" class="inputh lf" value="2018-04-27" />
              <div class="lf red laba">格式：yyyy-mm-dd</div>
            </dd>
            <dd>
              <label>结束时间：</label>
              <input name="GoodsETime_xxd"  type="date" class="inputh lf" value="2018-05-07" />
              <div class="lf red laba">格式：yyyy-mm-dd</div>
            </dd>
            <dd class="dds">
              <label>描述：</label>
              <textarea name="GoodsDesc_xxd" cols="" rows="" class="textarea">${sessionScope.goods_xxd.goodsDesc_xxd}</textarea>
            </dd>
            <dd>
              <label>修改图片：</label>
              <div class="lf salebd"><a href="#"><img src="images/ad20.jpg" width="100" height="100" /></a></div>
               <input name="GoodsPic_xxd" type="file" class="marg10" />
            </dd>
            <dd class="hegas">
                <input name="sive_xxd" type="submit" value="保 存" class="spbg buttombg buttombgs f14 lf buttomb" />
                <input name="cancel_xxd" type="reset" value="重置" class="spbg buttombg buttombgs f14 lf buttomb" />
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
		if (update.GoodsName_xxd.value == "") {
			alert("修改的拍品名称不能为空");
			update.GoodsName_xxd.focus();
			return false;
		}
		if (update.GoodsPrice_xxd.value == "") {
			alert("修改的起拍价不能为空");
			update.GoodsPrice_xxd.focus();
			return false;
		}
		if (update.GoodsSTime_xxd.value == "") {
			alert("修改的开始时间起拍价不能为空");
			update.GoodsSTime_xxd.focus();
			return false;
		}
		if (update.GoodsETime_xxd.value == "") {
			alert("修改的结束时间起拍价不能为空");
			update.GoodsETime_xxd.focus();
			return false;
		}
		if (update.GoodsPic_xxd.value == "") {
			alert("修改的拍品照片不能为空");
			update.GoodsPic_xxd.focus();
			return false;
		}
		if (update.GoodsDesc_xxd.value == "") {
			alert("修改的拍品描述不能为空");
			update.GoodsDesc_xxd.focus();
			return false;
		}
}
 </script>
</body>

</html>