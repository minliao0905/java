<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>帐号设置</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" href="${basePath}res/css/userInfo.css">
<script src="${basePath}js/jquery-1.11.3.js"></script>
</head>
<body>
	<div class="main-1">		
		<div class="make-change">
			<a href="javascript:;" class="m-change">修改我的个人信息</a>
		</div>
		<h1>我的用户信息</h1>
		<img src="" width="200px" ; height="200px">
		<h2>username</h2>
	</div>
	<div class="main-2">
		<ul class="nowul">
			<li class="number">电话号码：12345656</li>
			<li class="adress">送货地址：XXX 路 XXXX街</li>
			<li class="sighname">个性签名：本人很有个性，并未留下任何签名</li>
		</ul>
	</div>
	<div class="main-3">
		<p>本人什么记录也没有~~</p>
	</div>
	<script>
		$(function() {
			var flag=0;
			$(".m-change").click(
							function() {
							  if(flag==0){
								  $(".main-2").removeClass(".nowul");
								//设置form表单完成数据修改的功能
								var str = "<from action ='Register.jsp' method='post' id='userchangeFrom'><div class='from-u'>"+"<ul class='newmessage'>用户名：<input type='text' name='username'>"
										+ "用户密码：<input type='text' name='userpassword'>"
										+ "电话号码：<input type='text' name='userphonenum'></br>"
										+ "用户地址：<input type='text' name='useraddress'>"
										+ "个性签名：<input type='text' name='usersign'>" + "<button class='mybutton' type='submit' name ='提交'>修改信息</button></div></form>";
								$(".main-2").prepend(str);
								flag++;
							  }
								
							})
		})
	</script>
</body>
</html>