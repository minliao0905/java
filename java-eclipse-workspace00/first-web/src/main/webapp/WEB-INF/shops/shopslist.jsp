<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="${basePath}js/main.js"></script>
<script src="${basePath}js/jquery-1.11.3.js"></script>
<link rel="stylesheet" type="text/css" href="css/goodsinfo.css">
<title>shopslist</title>
</head>
<body>
<div class="uu"><a href='#topp'>返回页面顶部</a></div>
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
	getshopslist();
}
</script>
</body>
</html>