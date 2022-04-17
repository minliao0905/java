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
			<div class="t-check">收货状态</div>
			
		</div>
		<!-- 商品详情 -->
		<div class="all-item-list">
		    <% 
		    if(orderlist!=null){
		    	for(int i=0;i<orderlist.size();i++){
			    	String str = "<div class='cart-item' id='"+orderlist.get(i).getOrderId()+"'><div class='p-checkbox'> <input type='checkbox'  class='j-checkbox'></div> "+
			          "<div class='p-goods'> <div class='p-img'> </div> <div class='p-msg'>"+orderlist.get(i).getGoodsName()+"</div></div> "
			    	+ "<div class='p-price'>￥"+orderlist.get(i).getGoodsPrice()+"</div> <div class='p-num'> <div class='quantity-form'>"
			    	+"<a class='decrement'>-</a><input type='text' class='itxt' value='1'><a  class='increment'>+</a></div></div>"
			    +"<div class='p-sum'>"+orderlist.get(i).getAddressId()+"</div><div class='p-action'><p>"+orderlist.get(i).getOrderTime()+"</p></div><div class='p-check'>"+orderlist.get(i).getGoodsCheck()+"</div>"
			    	+"<button class='checkbtn'>确认收货</button> </div>" ;
			    	
			    	out.print(str);			    	
			    }
		    }	    
		    %>
		    </div>
		    <form action="user-main.jsp" method="post" class="check-form"  onsubmit="return checkfunc()">请再次确认您已收货的订单<button type="submit" class="ch-formbtn">确认</button></form>
		    </div>
<script>
var num = 0;
$(".checkbtn").click(function(){
	$(this).siblings(".p-check").html("已收货");
	
	 var id = $(this).parent().attr("id");	 
	  $(".check-form").prepend("<input  name='ch-id"+num+"' value='"+id+"'> ");
	  $(this).remove();
	num++;
}); 

function checkfunc(){
	$(".check-form").prepend("<input name='ch-num' value='"+num+"'>");
	$(".ch-formbtn").remove();
	return false;
}
</script>
</body>

</html>