<%@ page language="java" import="java.util.*" import=" com.educoder.entity.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

Shops shops = (Shops) request.getSession().getAttribute("shops");
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
</head>
<body>
	<div class="main-page">
		<div class="head-page">
			<p>欢迎来到商家主界面 !</p>
			<c:choose>
				<c:when test="${user==null }">
					<p>请先进行登录</p>
				</c:when>
				<c:otherwise>
					<p>
						登录成功！<%
					System.out.println(shops.getShopsId());
					%>
					</p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="body-page">
		<div class="user-main">
			<div class="uI-left">
				<a href="${basePath}shops.jsp?page=shopslistPage" target="showleft" id="cart-a">查看商品信息</a>
				<a href="${basePath}shops.jsp?page=shopsnewgoodsPage" target="showleft" id="myuser-a"">提交新的商品</a>
				<a href="${basePath}shops.jsp?page=shopsInfoPage" target="showleft">我的商家信息</a>
				<a href="${basePath}main.jsp">返回主界面</a>
			</div>
			<div class="uI-right">
				<iframe id="showleft" name="showleft" src="${basePath}shops.jsp?page=shopslistPage" style="overflow: hidden; position: absolute" width="1300" height="1000" scrolling="yes" frameborder="1"> </iframe>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>
</html>