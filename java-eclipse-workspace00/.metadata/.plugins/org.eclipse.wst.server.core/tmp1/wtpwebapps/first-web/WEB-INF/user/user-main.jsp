<%@ page language="java" import="java.util.*" import=" com.educoder.entity.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

User user = (User) request.getSession().getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${basePath}res/layer/layer.js"></script>
<script src="${basePath}res/js/jquery.min.js"></script>
<link href="${basePath}res/css/bootstrap.min.css" type="text/css" rel="stylesheet" media="all">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/userInfo.css">
</head>
<body>
	<div class="main-page">
		<div class="head-page">
			<p>欢迎来到主界面 !</p>
			<c:choose>
				<c:when test="${user==null }">
					<p>请先进行登录</p>
				</c:when>
				<c:otherwise>
			<p>登录成功！<% System.out.println(user.getUserId());%></p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="body-page">
		<div class="user-main">
			<div class="uI-left">
				<a href="${basePath}user-main.jsp?page=orderPage" target="showleft" id="cart-a">显示我的购物车详情</a>
				<a href="${basePath}user-main.jsp?page=userInfoPage" target="showleft" id="myuser-a"">修改我的个人信息</a>
		         <a href="${basePath}user-main.jsp?page=myOrderPage"  target="showleft" >我的订单</a>
		         <a href="${basePath}user-main.jsp?page=checkOrderPage" target="showleft" id="myuser-a">查看订单状态</a>
		         <a href="${basePath}main.jsp" >返回主界面</a>
		       
	</div>
			
			</div>
				<div class="uI-right">
				 <iframe id="showleft" name="showleft" src="${basePath}user-main.jsp?page=orderPage" style="overflow:hidden; position:absolute " width="1300" height="1000" scrolling="yes" frameborder="1" >
             </iframe>
				</div>
		</div>
	</div>
</body>
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