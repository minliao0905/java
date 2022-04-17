<%@ page language="java" import="java.util.*" import=" com.educoder.entity.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
System.out.println("uyty"+request.getSession().getAttribute("modelId"));  
User user = (User) request.getSession().getAttribute("user");
int condition = 0;
if(user!=null){
	System.out.println(user.toString());
	condition = 1;
}
Shops shops = (Shops) request.getSession().getAttribute("shops");
if(shops!=null){
	System.out.println(shops.toString());
	condition = 2;
}

Mycontrol control= (Mycontrol) request.getSession().getAttribute("control");
if(control!=null){
	System.out.println(control.toString());
	condition = 3;
}

%>

<!DOCTYPE>
<html>
<head>
<base href="${basePath}">
<title>网上购物商城</title>
<link rel="shortcut icon" href="${basePath}imgs/title.ico">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" href="${basePath}res/css/global.css">
<link rel="stylesheet" href="${basePath}res/css/index_main.css">
<link rel="stylesheet" type="text/css" href="${basePath}/res/css/form.css">
</head>
<body>
	<div class="header" style="top: 0px; width: 100%">
		<div class="main">
			<div class="nav-me">
				<p>欢迎来到网上购物界面（当前默认模式为购物模式）</p>
			</div>
			<div class="nav-search" style="top: 5px;">
				<div class="search-view">
					<input type="text" class="text" value="" placeholder="搜索 商品名 类型" id="search-input">
					<button type="button" id="search-button" onclick="search()">搜 索</button>
				</div>
			</div>
			<!--用户导航栏显示登录和注册，还有用户信息连接指向user.jsp  -->
			<div class="nav-user" style="float: right; color: white;">
				<div class="nav-cart" >
					<a onclick="isLogin(this)" target="content" id="cart-a">
						<img src="${basePath}res/images/pcart.png">
					</a>
				</div> 
				<c:choose>	
						
			    <c:when test="${control!=null}">
						<div class="nav" style="color: white">
							<a href="${basePath}home.jsp?page=mainPage" target="content" id="login-a">首页</a>
							<a href="${basePath}mycontrol.jsp?page=MycontrolPage" target="content" id="login-a">控制界面</a>
							<a href="${basePath}login.jsp?page=loginPage" target="content" id="login-a">退出登录</a>
						</div>
				</c:when>
					
				 <c:when test="${shops!=null} ">
						<div class="nav" style="color: white">
							<a href="${basePath}home.jsp?page=mainPage" target="content" id="login-a">首页</a>
							<a href="${basePath}shops.jsp?page=shopsmainPage" target="content">${shops.getShopsName() }</a>
							<a href="${basePath}login.jsp?page=loginPage" target="content">退出登录</a>
						</div>
				 </c:when> 
				 <c:when test="${user.getUserName()!=null} ">
						<div class="nav" style="color: white">
						    <a href="${basePath}home.jsp?page=mainPage" target="content" id="login-a">首页</a>
							<a href="${basePath}user-main.jsp?page=usermainPage" target="content">${user.getUserName()}</a>
							<a href="${basePath}login.jsp?page=loginPage" target="content" id="login-a">退出登录</a>							
						</div>
				</c:when>	
					<c:otherwise>
					   	<div class="nav">
							<a href="${basePath}home.jsp?page=mainPage" target="content" id="login-a">首页</a>
							<a href="${basePath}login.jsp?page=loginPage" target="content" id="login-a">${user.getUserName()}登录</a>
							<a href="${basePath}Register.jsp?page=registerPage" target="content">注册</a>
						</div>					
					</c:otherwise>								   
				</c:choose>
			</div>
		</div>
	</div>
	<!--  显示主页  -->
	<iframe id="content" src="${basePath}home.jsp?page=mainPage" style="height: 100%; width: 101%;" name="content" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes"></iframe>
	<div class="footer">Copyright @ xiaoguo 2021-6-10</div>
</body>
<script src="${basePath}res/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

	function isLogin(obj) {
		if ('${user}' != null && '${user}' != '') {
			obj.href = '${basePath}user-main.jsp?page=usermainPage';
		} else {
			alert("hello,请先登录哦！");
			obj.href = '${basePath}login.jsp?page=loginPage'; 
			
		}
		
	}
	
	function search() {
		var value = $('#search-input').val();
		if (value != null && value != '') {
			///alert('ajax搜索');
			$
					.ajax({
						type : "GET",
						dataType : "text",
						async : false,
						url : '${basePath}home.jsp?page=searchGoods',
						data : {
							"condition" : value
						},
						success : function(msg) {
							if (msg == 'success') {
								//windows.parent.location.open('result');
								window.content.location.href = '${basePath}home.jsp?page=result';
							} else {
								layer.msg('没有找到您要的商品！', {
									icon : 5
								});
							}
						},
						error : function() {
							layer.msg('服务器响应失败！', {
								icon : 5
							});
						}
					});
		} else {
			layer.tips('请输入您要找的商品！', '#search-input');
		}
	}

	//监听搜索input回车事件
	$('#search-input').bind('keypress', function(event) {
		if (event.keyCode == "13") {
			event.preventDefault();
			$('#search-button').click();
		}
	});
</script>
</html>
