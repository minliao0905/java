<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
Object message = request.getAttribute("message");
System.out.println("login"+message);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">

<title>用户登录界面</title>
</head>
<body>
	<div class="local-form">
		<form onsubmit="return loginUser()" action="login.jsp" method="post" id="loginForm">
			<div class="form-u">
				<p>欢迎您的登录！--用户登录</p>
			</div>
			<ul>
				<li class="model">
					<select name="modelId" size = "1">
						<option value="User" >用户模式User</option>
						<option value="shops">商家选择模式-Shops</option>
						<option value="mycontrol">控制选择</option>
					</select>
				</li>
				<li class="userId">
					userId:
					<input type="text" name="userId" class="u_id"></input>
				</li>
				<li class="userName">
					userName:
					<input type="text" name="userName" class="u_name"></input>
				</li>
				<li class="passWord">
					password:
					<input type="password" name="passWord" class="u_password"></input>
				</li>
				<%  if(message!=null){
					if(message=="wrong")
					out.print("<script>alert('您输入的userId或者password有误！')</script>");
				}
				%>
			</ul>
			<button class="mybutton1" type="submit" name="login">登录</button>
			<button class="mybutton2"><a class="mybutton" href="${basePath}Register.jsp?page=registerPage" target="content">注册新用户</a></button>
		</form>
	</div>
</body>
<script src="js/jquery-1.11.3.js"></script>
<script>

function loginUser() {
	var userid = $(".u_id").val();
	var username = $(".u_name").val();
	var userpassword = $(".u_password").val();
	
   if(userid==""||username==""||userpassword ==""){
	     alert("请将您的信息填写完整! ");
   return false;
   }
 
return true;
}
	
	
</script>
</html>
</html>