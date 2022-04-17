<%@ page language="java" import="com.educoder.entity.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
User user = (User)request.getSession().getAttribute("user");

//System.out.println(user.toString());
//成功获取数据当前用户已登录
//待实现的功能部分，当用户没有登录时，无法进行购物，则需要进行判断
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="js/main.js"></script>
<script src="js/jquery-1.11.3.js"></script>
<link rel="stylesheet" type="text/css" href="css/goodsinfo.css">
<title>my goodsInfo</title>
</head>
<body>
<div class="uu"><a href="#b_form">查看添加的信息</a> <a href='#topp'>返回页面顶部</a></div>
   <div class="tabs" id ="topp">
   <div class="tabs_title">
   <div class="title_item" id="title1" >综合</div>
   <div class="title_item" id="title2">商品</div>
   <div class="title_item" id="title3">价格</div>
   </div>   
   </div>
	<div class="first_tab">
		
	</div>
	
	<script>
window.onload = function(){
	getgoodslist();
	u_buy(); //click事件无效问题js加载获取动态元素
}
function checkaddress(){

	var uaddress = $(".u_address").val();
	 $(".buy_form").append("<input name='goodnum' value='"+buyarr.length+"'>");
	console.log(uaddress);
		if(uaddress=="")
			{
			alert("请填写您的地址信息！");
			return false;
			}else{
				alert("成功添加进入购物车！");
			}
		
		return  true;
}
var buyarr = [];
function u_buy(){
	 
	var text =  $(".u_buy");
	$(".first_tab").after("<form onsubmit='return checkaddress()' action='goodsinfo.jsp' method='post' class='buy_form' id='b_form'></form>")
	
	$(".u_buy").click(function(){
		alert("成功加入购物车！"+$(this).parent().parent().attr("id"));		
		var goodsid = $(this).parent().parent().attr("id");
		buyarr.push(goodsid);
		addbuy();
		var good = findbuy(goodsid);
		$(".buy_form").prepend("<input name='goodsid"+buyarr.length+"' value='"+good.goodsid+"'><input name='goodsname"+buyarr.length+"' value='"+good.goodsname+"'><input name='goodsprice"+buyarr.length+"' value='"+good.goodsprice+"'></from>");
	})	
	$(".buy_form").append("请填入您的个人收货地址：<input name='uaddress' value='' class='u_address'><button type='submit'>提交购物</button>");
	}

function addbuy(){
	for(var i=0;i<buyarr.length;i++){
		console.log(buyarr[i]);
	}
}
function findbuy(goodsid){
	//定义map数组
	var good ={};
$.each(good_list.message, function(i, n) {
		
		$.each(n.goodslist, function(j, m) {			
			if(m.goods_id==goodsid){
				good.goodsid = m.goods_id ;//随机生成订单号
				good.goodsname = m.goods_name; 
				good.goodsprice = m.goods_price;
				good.goodsimg = m.goods_id +".jpg";	
			}
		})
	});
	console.log(good);
	return good;
}

</script>
</body>
</html>