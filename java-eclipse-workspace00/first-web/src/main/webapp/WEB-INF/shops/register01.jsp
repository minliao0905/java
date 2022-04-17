<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${basePath}res/css/form.css">
<title>shops-register</title>
</head>
<body>
<div class="main-page">
		<div class="head">
			<p>欢迎来到商家注册界面</p>
			<div class="local-form">
				<form action="Register.jsp" method="post" id="registerForm">
					<div class="form-u">
						<ul>
							<li class="userId">
								shopsId:
								<input type="text" name="userId"></input>
							</li>
							<li class="userName">
								shopsName:
								<input type="text" name="userName"></input>
							</li>
							<li class="nowpwd">
								password:
								<input type="password" name="nowpwd"></input>
							</li>
							<li class="newpwd">
								请再次输入密码：
								<input type="password" name="newpwd"></input>
							</li>
							<li class="address">
							 Address:<input type="text" name="address"></input>
							</li>
							<li class="classify">
							<select>
							<option value="daily-use" selected>日常用品</option>
							<option value="electrical">家用电器</option>
							<option value="school-supplies">学习用品</option>
							<option value="clothes">服饰</option>
							</select> </li>
							<li class="createtime">
							<input type="date" name="user_date" /></li>
						</ul>
						<button class="mybutton" type="submit" name="提交">注册</button>
						<button class="mybutton" type="" name="取消">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>