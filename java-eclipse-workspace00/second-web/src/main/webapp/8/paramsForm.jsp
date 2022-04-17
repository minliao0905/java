<%@ page language="java"  import="entity.User" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
   
%>
<title>Insert title here</title>
<style>
.login-form {
	width: 100%;
	float: right;
	
	height: 300px;
	margin-left: 100px;
}

.login-form form {
	background-color:white;
	width: 350px;
	float:right;
	height: 300px;
	border: 5px solid black;
	margin-right:50px;
	margin-top:50px;
	margin-right: 100px;
	border-radius:10px;
}
.login-form form ul{
style-list:none;
}
.login-form  ul li{
border-bottom:1px solid black;
width:200px;
style-list:none;

}
.login-form  input {
	line-height: 30px;
	border: 1px solid black;
	margin-bottom: 5px;
}
.login-form button{
background-color:grey;
width:100px;
border-radius:15px;
height:30px;
margin-left:30px;
}
</style>
</head>
<body>
	<div class="login-form">
	<c:choose>
		<c:when test="${user==null }">
		<form  onsubmit="return loginUser();" action="../sevlet_8" method="post" id="loginForm">		
		<div class="form-u">
		   <p>欢迎您的登录！</p>
		</div>
			<ul>
				<li class="userId">
					userId:
					<input type="text" name="userId"></input>
				</li>
				<li class="userName">
					userName:
					<input type="text" name="userName"></input>
				</li>
				<li class="passWord">
					password:
					<input type="password" name="passWord"></input>
				</li>
			</ul>
			<button type="submit" name="提交" >登录</button>
			<button name="注册">注册新用户</button>
		</form>
		</c:when>
		<c:when test="${usernumber==-1}">
		<p>很遗憾，没有查找到你所输入的相关信息！</p>
		</c:when>
		<c:otherwise >
		 <p>欢迎您的登录！以下是查询所得到的信息</p>
		  <% out.println("<table border='3'>"); %>
	      <tr>
        <th>userId </th>
        <th>userName</th>
        <th>password</th>
        <th>userHeadImg</th>
          </tr>  
      <%
      User user = (User)request.getAttribute("user");
      out.println("<tr>");
      out.println("<th>"+ user.getUserId()+ "</th>");
      out.println("<th>"+ user.getUserName()+ "</th>");
      out.println("<th>"+ user.getPassWord()+ "</th>");
      out.println("<th>"+ user.getUserHeadImg()+ "</th>");
      out.println("</tr>");
      out.println("</table>");
      %>
		</c:otherwise>
		</c:choose>
		
	</div>
</body>

</html>
</html>