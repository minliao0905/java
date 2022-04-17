<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" import="com.educoder.entity.*" language="java"%>
<%@ page import="com.educoder.entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
//Shops shops =(Shops)request.getAttribute("shops");
//System.out.println(shops);
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="">
<head>
<meta charset="UTF-8">
<title>我的购物车</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">

<script src="${basePath}js/jquery-1.11.3.js"></script>
<title>shopsInfo</title>
</head>
<body>
<div class="myinfo">
<h2>商店信息</h2>
<table>  
<tr>
<th>商家名称: ${shops.getShopsName() }   </th>
<th>商家id:${shops.getShopsId() }      </th>
<th>商家地址：${shops.getShopsAddress() }   </th>
</tr>
<tr>
<th>开店时间:${shops.getShopsCreatetime() }   </th>
<th>商店类别:${shops.getShopsClassify() }    </th>
<th>在架商品数量：1000+  </th>
<th>商品销量:10w+     </th>
</tr>

</table>

</div>
</body>	
</html>