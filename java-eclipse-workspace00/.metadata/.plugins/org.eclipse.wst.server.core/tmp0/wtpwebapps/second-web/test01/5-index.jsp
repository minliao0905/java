
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>网上试题自动评判——试题</title>
    <link rel="stylesheet" type="text/css" href = "5.css">
  </head>
  <body>
  <form action="5.jsp" method="post">
      一、  2+3=？<br>
      <input type="radio" name="r1" value="2" checked="checked">2
      <input type="radio" name="r1" value="3">3
      <input type="radio" name="r1" value="4">4
      <input type="radio" name="r1" value="5">5<br>
      二、下列哪些是偶数？<br>
      <input type="checkbox" name="c1" value="2">2
      <input type="checkbox" name="c1" value="3">3
      <input type="checkbox" name="c1" value="4">4
      <input type="checkbox" name="c1" value="5">5<br>
      三、下列哪些是动态网页？<br>
      <select  size="4" name="list1" multiple="multiple">
          <option value="asp">ASP</option>
          <option value="php">PHP</option>
          <option value="jsp">JSP</option>
          <option value="html">HTML</option>
      </select><br>
      四、下列组件哪个是服务器端的？<br>
      <select size="1" name="list2">
          <option value="jsp">JSP</option>
          <option value="servlet">SERVLET</option>
          <option value="java">JAVA</option>
          <option value="jdbc">JDBC</option>
      </select><br>
      五、在服务器端用来接受用户请求的对象是：
      <input tpye="text" size="10" name="text1"><br>
      <div align="left" class="mybutton">
          <blockquote>
              <input type="submit" value="提交" name="button1">
              <input type="reset" value="重置" name="button2">
          </blockquote>
      </div>
  </form>
  </body>
</html>
