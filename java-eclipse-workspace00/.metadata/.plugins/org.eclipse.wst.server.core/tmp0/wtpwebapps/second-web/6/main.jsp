<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" import=" com.educoder.entity.*" 
	language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车主界面</title>
<link rel="stylesheet" type="text/css" href="main.css">
</head>
<body>
	<header>
		<div class="top-menu">
			<div class="lf">
				<ul>
					<li>欢迎来到我的界面</li>				
				</ul>
			</div>
			<div class="rt">
			<c:choose>
			<c:when test="${user == null }">
				<ul>
				<li><a href="login.jsp"><span class="rr">登录</span></a></li>
					<li><a href="registerjsp"><span class="ll">注册</span></a></li>
				</ul>
				
			</c:when>
			<c:otherwise>
			<ul>
			<li><a href="6/shoppingCart.jsp" id="cart-a">显示我的购物车</a></li>
			<li><a href="6/login.jsp" id="back">退出登录</a></li>
			</ul>
			</c:otherwise>
			</c:choose>
			</div>
			
		</div>
	</header>

</body>
</html>