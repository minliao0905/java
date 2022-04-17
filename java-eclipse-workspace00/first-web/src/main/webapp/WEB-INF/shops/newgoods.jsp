<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java"%>
<%@ page import="com.educoder.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- 引入facicon.ico网页图标 -->
<link rel="stylesheet" href="${basePath}css/newGoods.css" type="text/css">
<script src="${basePath}js/jquery-1.11.3.js"></script>
<title>shopsInfo</title>
</head>
<body>
	<div class="buycars-container">
		<div class='w'>
			<div class='all'>
				<em>待新提交的商品</em>	
			</div>
		</div>

		<div class="all-thead">
		 	<div id="t"><button class="InsertBtn">添加商品</button></div>
				<div id="t" class="t-goods">商品</div>
				<div id="t" class="t-price">单价</div>
				<div id="t" class="t-num">数量</div>
				<div id="t" class="t-from">来源</div>
				<div id="t" class="t-img">图片(网址)</div>
				<div id="t" class="t-description">简介</div>
				<div id="t" class="t-classfiy">类别</div>		
		</div>
		<div class="s-thead"></div>
	</div>
		<form action="goods.jsp" method="post" class="goodsform" onsubmit ="return newcheck()"></form>
				
</body>
<script>
var flag=0;
var num = 1;
	$(".InsertBtn")
			.click(
					function() {
						var str = "商品单号：<input class='p-id' name='p-id'> "
								+ "商品名：<input class='p-goods' name='p-goods'> </br>"
								+ " 单价：<input class='p-price' name='p-price'> "
								+ "数量：<input class='p-num' name='p-num'> "
								+ "来源：<input class='p-from' name='p-from'> </br>"
								+ "图片：<input class='p-img' name='p-img'> "
								+ "简介：<input class='p-description' name='p-description'>"
								+ "类别：<input class='p-classfiy' name='p-classfiy'> <br>"
								+"<button type='submit'style='margin-left:50px'>确认申请</button><button type='reset' style='margin-left:50px'>取消</button>";
						if(flag==0){
							$(".goodsform").append(str);
							flag=1;
						}
						
					})
					
function newcheck(){
		var goodsid = $(".p-id").val();
		var goodsname = $(".p-goods").val();
		var goodsprice = $(".p-price").val();
		var goodsnum = $(".p-num").val();
		var goodsfrom = $(".p-from").val();
		var goodsimg = $(".p-img").val();
		var goodsdescription = $(".p-description").val();
		var goodsclassfiy = $(".p-classfiy").val();
		var newgood = [];
	newgood.push(goodsid);
	newgood.push(goodsname);
	newgood.push(goodsprice);
	newgood.push(goodsnum);
	newgood.push(goodsfrom);
	newgood.push(goodsimg);
	newgood.push(goodsdescription);
	newgood.push(goodsclassfiy);
    for(var i=0;i<newgood.length;i++){
		if(newgood[i]==""){
			alert("请将您的信息填写完整! ");
			return false;		
		}
	}
   /*表单添加成分*/
   str = "<div class='s-order' id ='"+num+"'>"+num+"</div> <div class='s-id'>"+goodsid+"</div><div class='s-goods'>"+goodsname+"</div> <div class='s-price'>"+goodsprice+"</div>"
   +" <div class='s-num'>"+goodsnum+"</div> <div class='s-from'>"+goodsfrom+"</div> "
   +"<div class='s-img'>"+goodsimg+"</div> <div class='s-description'>"+goodsdescription+"</div> <div class='s-classfiy'> "+goodsclassfiy+"</div>"
	  console.log(newgood);
   num++;
   $(".s-thead").prepend(str);
	  flag = 0;
	  return false;
	}
</script>
</html>