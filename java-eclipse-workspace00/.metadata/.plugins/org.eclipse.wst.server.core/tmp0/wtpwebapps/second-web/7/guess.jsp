<%@ page language="java" import="entity.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="GuessNumber" scope="session" class="entity.GuessNumber" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"  href="guess.css">
<title>猜数字游戏</title>
</head>
<body>
	<header>
		<h1>欢迎来到猜数字游戏界面！</h1>
	</header>
	<div class="box" style="border: 2px solid #eeeeee; margin-left: 500px; width: 500px;">
		<p>猜一猜!</p>
		<div class="container1">
			<p id="rules">游戏规则如下：</br>
			游戏会生成一个数字，请你猜一猜这个数字？若数字太大或太小，系统会给出提示，您只有三次机会哦！猜对即获胜。</p>
			<div class="text-new">
			<form action="getNumber.jsp" method="post">
				<%  GuessNumber.setNumber(100);
				    int number = GuessNumber.getNumber();		 
				 %>
				 <jsp:setProperty name="GuessNumber" property="number" value="<%=number%>"/>
				请输入数字：
				<input type="text" name="num" id="input_num"></input></br>
				<input type="text" name="guessnumber" id="guessnumber" style="display:none" value="${number }"></input></br>
			    <button  name="getnum" value="" type="submit" onclick="sell()">判断该数字是否正确</button>
			</form>
				
			</div>
		</div>
	</div>	
    <script type="text/javascript">
    window.onload = function(){
    	var sell= function(){
    		var num = document.getElementById("button_num");
    		var input_num = num.value;
    		
    		
    	}
    	
    }
    </script>
   
</body>
</html>