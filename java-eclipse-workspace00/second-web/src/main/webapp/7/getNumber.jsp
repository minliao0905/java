<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:useBean id="GuessNumber" scope="session" class="entity.GuessNumber" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>猜数字游戏</title>
</head>
<body style="color:white; background-color:black;">
<%  
int num =Integer.parseInt(request.getParameter("num"));
int number = GuessNumber.getNumber();
String result= null;
if(GuessNumber.Compare(num)==0)
{
	 result = "恭喜您，您猜对了！";
}
else if(GuessNumber.Compare(num)==1){
	result = "您输入的数字要大于要猜的数字！";
}else {
	 result = "您输入的数字要小于要猜的数字！";
}
request.setAttribute("result", result);
%>

<p>您所填写的数字为：<%=num %><span id="guessnum"></span></p>
<p>您所猜的结果为： <%=result %></p>
</br>
<a href ="guess.jsp" style="color:white;">返回游戏界面</a>

</body>
</html>