<%@ page language="java" import="java.util.*" import=" com.educoder.entity.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
List<Goods> goods_clist = (List<Goods>)request.getAttribute("goods_clist");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="${basePath}res/layer/layer.js"></script>
<script src="${basePath}res/js/jquery.min.js"></script>
<link href="${basePath}res/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/userInfo.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<!-- 引入facicon.ico网页图标 -->
<link rel="stylesheet" href="${basePath}css/newGoods.css" type="text/css">
<script src="${basePath}js/jquery-1.11.3.js"></script>
<title>shopsInfo</title>
</head>
<body>
	<div class="main-page">
		<div class="head-page">
			<p>欢迎来到商家主界面 !</p>			
		</div>
	<div class="buycars-container">
		<div class='w'>
			<div class='all'>
				<em>待新提交的商品</em>	
			</div>
		</div>
		<div class="all-thead">
				<div id="t" class="t-goods">商品</div>
				<div id="t" class="t-price">单价</div>
				<div id="t" class="t-num">数量</div>
				<div id="t" class="t-from">来源</div>
				<div id="t" class="t-img">图片(网址)</div>
				<div id="t" class="t-description">简介</div>
				<div id="t" class="t-classfiy">类别</div>		
		</div>
		<div class="s-thead">
		<%
		 if(goods_clist!=null){
		    	for(int i=0;i<goods_clist.size();i++){
		    		Goods goods = goods_clist.get(i);
		    		String str = "<div class='goods-item'><div class='s-id'>"+goods.getGoodsId()+"</div><div class='s-goods'>"+goods.getGoodsName()+"</div> <div class='s-price'>"+goods.getGoodsPrice()+"</div>"
		    				   +" <div class='s-num'>"+goods.getGoodsNum()+"</div> <div class='s-from'>"+goods.getGoodsFrom()+"</div> "
		    				   +"<div class='s-img'>"+goods.getGoodsImg()+"</div> <div class='s-description'>"+goods.getGoodsDescribe()+"</div> <div class='s-classfiy'> "+goods.getGoodsClass()+"</div><button class='ag-goods'>同意</button><button class='de-goods'>拒绝</button> </br></div> ";
			    	out.println(str);
			    }
		    	
		    }  
		 
		%>
		</div>
	</div>
		<form action="mycontrol.jsp" method="post" class="goodsform" onsubmit ="return newcheck1()"><button type="submit">确认提交</button> 您拒绝的商品单号如下:</form>
	  	<form action="mycontrol.jsp" method="post" class="goods_agree" onsubmit ="return newcheck2()"><button type="submit">确认提交</button> 您同意的商品单号如下:</form>				
	</div>
<script>
var num1 = 0;
var  num2 = 0;

//删除
$(".de-goods").click(function(){
	num1++;
 var res = confirm("确定删除该商品请求吗？")
if(res){
	$(this).parents(".goods-item").remove();
	$(".goodsform").append("<input name='de-id"+num1+"' value = '"+$(this).siblings(".s-id").html()+"'>");
}	 
})

//同意
$(".ag-goods").click(function(){
	num2++;
 var res = confirm("确定同意该商品请求吗？")
if(res){
	$(this).parents(".goods-item").remove();
	$(".goods_agree").append("<input name='ag-id"+num2+"' value = '"+$(this).siblings(".s-id").html()+"'>");
}	 
})

var f1=0;
var f2=0;
function newcheck1(){
	if(f1==0){
		$(".goodsform").append("    已经拒绝的数量:<input name='de-num' value = '"+num1+"'>");
		f1=1;
	}	
	return false;
}
function newcheck2(){
	if(f2==0){
			$(".goods_agree").append("    已经同意的数量:<input name='ag-num' value = '"+num2+"'>");
			f2 =1;
	}

	return false;
}
</script>
</body>
</html>