<%@ page language="java" import="java.util.*" import=" com.educoder.entity.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Access-Control-Allow-Origin" content="*" />
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">
<link rel="stylesheet" href="css/swiper.css">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<!-- Swiper -->
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="https://api-hmugo-web.itheima.net/pyg/banner1.png" width="100%;" height="350">
			</div>
			<div class="swiper-slide">
				<img src="https://api-hmugo-web.itheima.net/pyg/banner2.png" width="100%;" height="350">
			</div>
			<div class="swiper-slide">
				<img src="https://api-hmugo-web.itheima.net/pyg/banner3.png" width="100%;" height="350">
			</div>
		</div>
		<!-- Add Pagination -->
		<div class="swiper-pagination"></div>
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	<div class="banner-nav-bg"></div>
	<!-- 目录展示 -->
	<div class="main-1">	
	
		<div class="nav-item"><a href='goodsList.jsp'>
			<img src="https://api-hmugo-web.itheima.net/pyg/icon_index_nav_4@2x.png" width="200" height="200"></a>
		</div>
		<div class="nav-item">	<a href='goodsList.jsp'>
			<img src="https://api-hmugo-web.itheima.net/pyg/icon_index_nav_3@2x.png" width="200" height="200"></a>
		</div>
		<div class="nav-item">	<a href='goodsList.jsp'>
			<img src="https://api-hmugo-web.itheima.net/pyg/icon_index_nav_2@2x.png" width="200" height="200"></a>
		</div>
		<div class="nav-item">	<a href='goodsList.jsp'>
			<img src="https://api-hmugo-web.itheima.net/pyg/icon_index_nav_1@2x.png" width="200" height="200"></a>
		</div>
		<div class="nav-item">	<a href='goodsList.jsp'>
			<img src="imgs/photo/20150226100534QqezQ85N6y.jpg" width="100%;" height="300"></a>
		</div>
		<div class="nav-item">	<a href='goodsList.jsp'>
			<img src="imgs/photo/20140926184007v2rjcVFcbW.jpg" width="100%;" height="300"></a>
		</div>
		
	</div>
	<div class="main-2">
		<div class="nav-item"></div>
	</div>
	<div class="body-page">
		<!-- 如果用户没有登录 -->
	</div>
</body>
<script src="js/jquery-1.11.3.js"></script>
<script src="js/swiper.min.js"></script>
<script>
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        loop: true,
        autoplay: 3000,
        speed: 1000,
        prevButton: '.swiper-button-prev',
        nextButton: '.swiper-button-next',
        effect: 'fade',//  effect: 'flip',effect: 'coverflow',slide', 'fade',cube
        grabCursor: true,
        cube: {
            shadow: false,
            slideShadows: false,
            shadowOffset: 20,
            shadowScale: 0.94
        }
    });
    window.onload = function(){
    	getfloorList();
    }  
    function getfloorList() {
    	var  floorList = { "message": [{"floor_title": { "name":"时尚女装", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_title.png"}, 
    	 "product_list": [{ "name":"优质服饰", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_1@2x.png", "image_width":"232", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=服饰"}, { "name":"春季热门", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_2@2x.png", "image_width":"233", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=热"}, { "name":"爆款清仓", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_3@2x.png", "image_width":"233", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=爆款"},
    	  { "name":"倒春寒", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_4@2x.png", "image_width":"233", "open_type":"navigate",
    	   "navigator_url":"/pages/goods_list?query=春季"},
    	   
    	    { "name":"怦然心动", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor01_5@2x.png", "image_width":"233", "open_type":"navigate", 
    	    "navigator_url":"/pages/goods_list?query=心动"}] }, 
    	    { "floor_title": { "name":"户外活动", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_title.png"}, 
    	    "product_list": [{ "name":"勇往直前", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_1@2x.png", "image_width":"232", 
    	    "open_type":"navigate", "navigator_url":"/pages/goods_list?query=户外"},
    	     { "name":"户外登山包", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_2@2x.png", "image_width":"273", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=登山包"}, { "name":"超强手套", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_3@2x.png", "image_width":"193", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=手套"}, { "name":"户外运动鞋", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_4@2x.png", "image_width":"193", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=运动鞋"}, { "name":"冲锋衣系列", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor02_5@2x.png", "image_width":"273", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=冲锋衣"}] }, { "floor_title": { "name":"箱包配饰", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_title.png"}, "product_list": [{ "name":"清新气质", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_1@2x.png", "image_width":"232", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=饰品"}, { "name":"复古胸针", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_2@2x.png", "image_width":"263", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=胸针"}, { "name":"韩版手链", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_3@2x.png", "image_width":"203", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=手链"}, { "name":"水晶项链", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_4@2x.png", "image_width":"193", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=水晶项链"}, { "name":"情侣表", "image_src":"https://api-hmugo-web.itheima.net/pyg/pic_floor03_5@2x.png", "image_width":"273", "open_type":"navigate", "navigator_url":"/pages/goods_list?query=情侣表"}] }], "meta": { "msg":"获取成功", "status":200} }
    	//遍历渲染数据；
    	$.each(floorList.message,function(i,n){
    		$.each(n.product_list,function(j,m){       		
    			$(".main-2").prepend("<div class='floor_item' id='"+i+j+"'><img src='"+m.image_src +"'></div></div>");
    		})
    		$(".main-2").prepend("<div class='floor_title'></div>");
		})
		var test = $(".floor_title");
    		$.each(floorList.message,function(i,n){
        		$(test[i]).prepend("<div class='floor_list'><img src='"+n.floor_title.image_src+"'></div>");
        
    		})	
    		
    }
    	
</script>
<script type="text/javascript"> 
	function loginUser() {
		var userid = document.getElementById("userId").value.trim();
		var username = document.getElementById("userName").value.trim();
		var userpassword = documnet.getElementById("passWord").value.trim();
		if(userid=""||username=""||userpassword=""){
			alert("请把用户信息填写完整！");
			return false;
		}else{
			return true;
		}
	}
</script>
</html>
</html>