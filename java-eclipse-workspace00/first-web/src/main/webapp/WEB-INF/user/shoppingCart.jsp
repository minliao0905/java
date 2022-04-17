<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java"%>
<%@ page import="com.educoder.entity.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

List<Order>  orderlist=(List<Order>)request.getAttribute("orderList");
//System.out.println(orderlist+"owieiw");

%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- 引入facicon.ico网页图标 -->
<link rel="stylesheet" href="${basePath}css/shoppingCart.css" type="text/css">
<script src="${basePath}js/jquery-1.11.3.js"></script>

</head>
<body>
	<!-- 购物车中心 -->
	<div class="buycars-container">
		<div class="w">
			<div class="all">
				<em>全部商品</em>
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
			<div class="t-sum">小计</div>
			<div class="t-action">操作</div>
		</div>
		<!-- 商品详情 -->
		<div class="all-item-list">
		<!-- <div class="cart-item" id="1">
				<div class="p-checkbox">
					<input type="checkbox" name="" id="" class="j-checkbox">
				</div>
				<div class="p-goods">
					<div class="p-img">
						<img src="img/OIP (3).jfif" alt="">
					</div>
					<div class="p-msg">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>
				</div>
				<div class="p-price">￥12.60</div>
				<div class="p-num">
					<div class="quantity-form">
						<a href="javascript:;" class="decrement">-</a>
						<input type="text" class="itxt" value="1">
						<a href="javascript:;" class="increment">+</a>
					</div>
				</div>
				<div class="p-sum">￥12.60</div>
				<div class="p-action">
					<a href="javascript:;">删除</a>
				</div>
			</div>  -->
		    <% 
		    if(orderlist!=null){
		    	for(int i=0;i<orderlist.size();i++){
			    	String str = "<div class='cart-item' id='"+orderlist.get(i).getOrderId()+"'><div class='p-checkbox'> <input type='checkbox'  class='j-checkbox'></div> "+
			    "<div class='p-goods'> <div class='p-img'> </div> <div class='p-msg'>"+orderlist.get(i).getGoodsName()+"</div></div> "
			    	+ "<div class='p-price'>￥"+orderlist.get(i).getGoodsPrice()+"</div> <div class='p-num'> <div class='quantity-form'>"
			    	+"<a href='javascript:;' class='decrement'>-</a><input type='text' class='itxt' value='1'><a href='javascript:;' class='increment'>+</a></div></div>"
			    +"<div class='p-sum'>￥"+orderlist.get(i).getGoodsPrice()+"</div><div class='p-action'><a href='javascript:;'>删除</a></div> </div>" ;
			    	out.print(str);
			    	
			    }
		    }    
		    %>
			<div class="cart-floatbar">
				<div class="select-all">
					<input type="checkbox" name="" id="" class="checkall">
					全选
				</div>
				<div class="operation">
					<a href="javascript:;" class="remove-batch"> 删除选中的商品</a>
					<a href="javascript:;" class="clear-all">清空购物车</a>
				</div>
				<div class="toolbar-right">
					<div class="amount-sum">
						已经选
						<em>1</em>
						件商品
					</div>
					<div class="price-sum">
						总价：
						<em>￥12.60</em>
					</div>
					<div class="btn-area"><a href="javascript:;" class="all_pay">支付</a></div>
				</div>
			</div>
		</div>
	</div>
	<script>
	
		$(function() {
			$(".checkall").change(
					function() {
						$(".j-checkbox,.checkall").prop("checked",
								$(this).prop("checked")); //全选的选择状态赋值
						if ($(this).prop("checked")) {
							$(".cart-item").addClass("check-cart-item");
						} else {
							$(".cart-item").removeClass("check-cart-item");

						}
					});
			$(".j-checkbox")
					.change(
							function() {
								if ($(".j-checkbox:checked").length == $(".j-checkbox").length) {
									$(".checkall").prop("checked", true);
								} else {
									$(".checkall").prop("checked", false);
								}
								if ($(this).prop("checked")) {
									$(this).parents(".cart-item").addClass(
											"check-cart-item");
								} else {
									$(this).parents(".cart-item").removeClass(
											"check-cart-item");
								}
							});
			$(".increment").click(
					function() {
						var n = $(this).siblings(".itxt").val();
						n++;
						$(this).siblings(".itxt").val(n);
						
						//查找parent元素 使用parents("elementname");返回指定祖先元素
						var p = $(this).parents(".p-num").siblings(".p-price")
								.html();
						p = p.substr(1);
						$(this).parent().parent().siblings(".p-sum").html(
								"￥" + (p * n).toFixed(2));
						getSum();

					})
			$(".decrement").click(
					function() {
						var n = $(this).siblings(".itxt").val();
						if (n > 1) {
							n--;
						}
						$(this).siblings(".itxt").val(n);
						var p = $(this).parent().parent().siblings(".p-price")
								.html();
						p = p.substr(1);
						// console.log(p);
						$(this).parent().parent().siblings(".p-sum").html(
								"￥" + (p * n).toFixed(2));//tofixed（）操作，保留两位小数
						getSum();

					})
			$(".itxt").change(
					function() {
						var n = $(this).val();
						var p = $(this).parents(".p-num").siblings(".p-price").html();
						p = p.substr(1);
						$(this).parent().parent().siblings(".p-sum").html(
								"￥" + (p * n).toFixed(2));
						getSum();

					})
			// 5. 计算总计和总额模块
			getSum();

			function getSum() {
				var count = 0; // 计算总件数 
				var money = 0; // 计算总价钱
				$(".itxt").each(function(i, ele) { //each遍历 第一个参数自定义 
					count += parseInt($(ele).val());
				});
				$(".amount-sum em").text(count);
				$(".p-sum").each(function(i, ele) {
					money += parseFloat($(ele).text().substr(1));
				});
				$(".price-sum em").text("￥" + money.toFixed(2));
				
				// 由于只能写入string json.stringify 转了一下
			//	localStorage.setItem('orderlist', JSON.stringify(orderlist));
				 
			}
			// 6. 删除商品模块
			// (1) 商品后面的删除按钮
			$(".p-action a").click(function() {
				
				//通过class获取id值
				var orderid = $(this).parents(".cart-item").attr("id");
				// 删除的是当前的商品 
				$(this).parents(".cart-item").remove();
				getSum();
			});
			// (2) 删除选中的商品
			$(".remove-batch").click(function() {
				// 删除的是小的复选框选中的商品
				$(".j-checkbox:checked").parents(".cart-item").remove();
				getSum();
			});
			// (3) 清空购物车 删除全部商品
			$(".clear-all").click(function() {
				$(".cart-item").remove();
				$(".cart-floatbar").remove();
				getSum();
			})
			//7支付功能的实现
		  $(".all_pay").click(function(){
			
			  var goodsId=[];
			  $(".cart-item").each(function(i, ele) { //each遍历 第一个参数自定义 
					goodsId.push($(ele).attr("id"));
				});
			  console.log(goodsId);
			  $(".all-item-list").after("<form action='myOrder.jsp' method='GET' class='form_delete'><form>");
			  for(var i=0;i<goodsId.length;i++){
				  $(".form_delete").prepend("<input class='d_goodsid' name='d_goodsid"+i+"' value='"+goodsId[i]+"'> ");
			  }
			  $(".form_delete").append("<input class='d_num' name='d_numid' value='"+goodsId.length+"'>是否确定保存你所要保存的订单：<button type='submit'>确认</button>")
		              alert("支付成功！"); 
			  })
		})
	</script>
</body>
</html>