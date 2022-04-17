<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
Object message = request.getAttribute("message");
System.out.println("Register"+message);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">
<title>注册用户</title>
</head>
<body>
	<div class="main-page">
		<div class="head">
			<p>欢迎来到用户注册界面</p>
			<div class="local-form">
				<form  onsubmit="return RegisterUser();"action="Register.jsp" method="post" id="registerForm">
					<div class="form-u">
						<ul>
							<li class="model" >
								<select name="modelId" size="1" class="m_id">
									<option value="User">用户模式User</option>
									<option value="shops">商家选择模式-Shops</option>
									<option value="mycontorl">控制选择</option>
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
							<li class="nowpwd">
								password:
								<input type="password" name="nowpwd" class="u_p1"></input>
							</li>
							<li class="newpwd">
								请再次输入密码：
								<input type="password" name="newpwd" class="u_p2"></input>
							</li>
							<%  if(message!=null){
					if(message=="wrong")
					out.print("<script>alert('您输入的userId已被占用！请重新输入')</script>");
					else if(message =="ok"){
						out.print("<script>alert('注册成功')</script>");
					}
				}
				%>
						</ul>
						<button class="mybutton" type="submit" name="提交">注册用户</button>
						<button class="mybutton" type="" name="取消">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script src="js/jquery-1.11.3.js"></script>
<script>
	function RegisterUser() {
		var userid = $(".u_id").val();
		var username = $(".u_name").val();
		var nowpassword = $(".u_p1").val();
		var newpassword = $(".u_p2").val();
		if ("" == username || "" == nowpassword || "" == newpassword|| userid =="") {
			alert("请把信息填写完整！");
			return false;
		}
		if (!(nowpassword==newpassword)) {
			alert("两次填写的密码不一致哦！请重新填写。");
			return false;
		} 

		return true;
	}
</script>
</html>