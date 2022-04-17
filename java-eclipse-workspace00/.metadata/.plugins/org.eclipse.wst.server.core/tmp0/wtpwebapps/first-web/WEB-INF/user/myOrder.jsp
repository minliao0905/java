<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java"%>
<%@ page import="com.educoder.entity.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

List<Order>  orderlist=(List<Order>)request.getAttribute("orderList");
System.out.println("myorder--"+orderlist);

%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${basePath}css/shoppingCart.css" type="text/css">
<script src="${basePath}js/jquery-1.11.3.js"></script>
<title>myOrder</title>
</head>
<body>
<div class="buycars-container">
		<div class="w">
			<div class="all">
				<em>全部订单</em>
			</div>
		</div>
		<!-- 头部全选模块header -->
		<div class="all-thead">
			<div class="t-checkbox">
				<input type="checkbox" name="" id="" class="checkall">
				全选
			</div>
			<div class="t-goods">商品</div>
			<div class="t-price">单价</div>
			<div class="t-num">数量</div>
			<div class="t-sum">收货地址</div>
			<div class="t-action">下单时间</div>
		</div>
		<!-- 商品详情 -->
		<!--  <div class="all-item-list">
			<div class="cart-item" id="1">
				<div class="p-checkbox">
					<input type="checkbox" name="" id="" class="j-checkbox">
				</div>
				<div class="p-goods">
					<div class="p-img">
						<img src="img/OIP (3).jfif" alt="">
					</div>
					<div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
				</div>
				<div class="p-price">￥12.6</div>
				<div class="p-num">
					<div class="quantity-form">
						<a class="decrement">-</a>
						<input type="text" class="itxt" value="1">
						<a class="increment">+</a>
					</div>
				</div>
				<div class="p-sum">address</div>
				<div class="p-action">
					<p>2021-10-10</p>
				</div>
			</div>-->
		    <% 
		    if(orderlist!=null){
		    	for(int i=0;i<orderlist.size();i++){
			    	String str = "<div class='cart-item' id='"+orderlist.get(i).getOrderId()+"'><div class='p-checkbox'> <input type='checkbox'  class='j-checkbox'></div> "+
			    "<div class='p-goods'> <div class='p-img'> </div> <div class='p-msg'>"+orderlist.get(i).getGoodsName()+"</div></div> "
			    	+ "<div class='p-price'>￥"+orderlist.get(i).getGoodsPrice()+"</div> <div class='p-num'> <div class='quantity-form'>"
			    	+"<a class='decrement'>-</a><input type='text' class='itxt' value='1'><a  class='increment'>+</a></div></div>"
			    +"<div class='p-sum'>"+orderlist.get(i).getAddressId()+"</div><div class='p-action'><p>"+orderlist.get(i).getOrderTime()+"</p></div> </div>" ;
			    	out.print(str);
			    	
			    }
		    }
		    
		    
		    
		    
		    %>
		    </div>
		    </div>
</body>
</html>