/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.108
 * Generated at: 2021-06-15 01:21:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.educoder.entity.*;

public final class shoppingCart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");

String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

List<Order>  orderlist=(List<Order>)request.getAttribute("orderList");
//System.out.println(orderlist+"owieiw");


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>我的购物车</title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0\">\r\n");
      out.write("<!-- 引入facicon.ico网页图标 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("css/shoppingCart.css\" type=\"text/css\">\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("js/jquery-1.11.3.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 购物车中心 -->\r\n");
      out.write("\t<div class=\"buycars-container\">\r\n");
      out.write("\t\t<div class=\"w\">\r\n");
      out.write("\t\t\t<div class=\"all\">\r\n");
      out.write("\t\t\t\t<em>全部商品</em>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 头部全选模块header -->\r\n");
      out.write("\t\t<div class=\"all-thead\">\r\n");
      out.write("\t\t\t<div class=\"t-checkbox\">\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" name=\"\" id=\"\" class=\"checkall\">\r\n");
      out.write("\t\t\t\t全选\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"t-goods\">商品</div>\r\n");
      out.write("\t\t\t<div class=\"t-price\">单价</div>\r\n");
      out.write("\t\t\t<div class=\"t-num\">数量</div>\r\n");
      out.write("\t\t\t<div class=\"t-sum\">小计</div>\r\n");
      out.write("\t\t\t<div class=\"t-action\">操作</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- 商品详情 -->\r\n");
      out.write("\t\t<div class=\"all-item-list\">\r\n");
      out.write("\t\t<!-- <div class=\"cart-item\" id=\"1\">\r\n");
      out.write("\t\t\t\t<div class=\"p-checkbox\">\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"\" id=\"\" class=\"j-checkbox\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"p-goods\">\r\n");
      out.write("\t\t\t\t\t<div class=\"p-img\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"img/OIP (3).jfif\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"p-msg\">【5本26.8元】经典儿童文学彩图青少版八十天环游地球中学生语文教学大纲</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"p-price\">￥12.60</div>\r\n");
      out.write("\t\t\t\t<div class=\"p-num\">\r\n");
      out.write("\t\t\t\t\t<div class=\"quantity-form\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"decrement\">-</a>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"itxt\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:;\" class=\"increment\">+</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"p-sum\">￥12.60</div>\r\n");
      out.write("\t\t\t\t<div class=\"p-action\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\">删除</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>  -->\r\n");
      out.write("\t\t    ");
 
		    if(orderlist!=null){
		    	for(int i=0;i<orderlist.size();i++){
			    	String str = "<div class='cart-item' id='"+orderlist.get(i).getOrderId()+"'><div class='p-checkbox'> <input type='checkbox'  class='j-checkbox'></div> "+
			    "<div class='p-goods'> <div class='p-img'> </div> <div class='p-msg'>"+orderlist.get(i).getGoodsName()+"</div></div> "
			    	+ "<div class='p-price'>￥"+orderlist.get(i).getGoodsPrice()+"</div> <div class='p-num'> <div class='quantity-form'>"
			    	+"<a href='javascript:;' class='decrement'>-</a><input type='text' class='itxt' value='1'><a href='javascript:;' class='increment'>+</a></div></div>"
			    +"<div class='p-sum'>￥"+orderlist.get(i).getGoodsPrice()+"</div><div class='p-action'><a href='javascript:;'>删除</a></div> </div>" ;
			    	out.print(str);
			    	
			    }
		    }    
		    
      out.write("\r\n");
      out.write("\t\t\t<div class=\"cart-floatbar\">\r\n");
      out.write("\t\t\t\t<div class=\"select-all\">\r\n");
      out.write("\t\t\t\t\t<input type=\"checkbox\" name=\"\" id=\"\" class=\"checkall\">\r\n");
      out.write("\t\t\t\t\t全选\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"operation\">\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" class=\"remove-batch\"> 删除选中的商品</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:;\" class=\"clear-all\">清空购物车</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"toolbar-right\">\r\n");
      out.write("\t\t\t\t\t<div class=\"amount-sum\">\r\n");
      out.write("\t\t\t\t\t\t已经选\r\n");
      out.write("\t\t\t\t\t\t<em>1</em>\r\n");
      out.write("\t\t\t\t\t\t件商品\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"price-sum\">\r\n");
      out.write("\t\t\t\t\t\t总价：\r\n");
      out.write("\t\t\t\t\t\t<em>￥12.60</em>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-area\"><a href=\"javascript:;\" class=\"all_pay\">支付</a></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\".checkall\").change(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t$(\".j-checkbox,.checkall\").prop(\"checked\",\r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).prop(\"checked\")); //全选的选择状态赋值\r\n");
      out.write("\t\t\t\t\t\tif ($(this).prop(\"checked\")) {\r\n");
      out.write("\t\t\t\t\t\t\t$(\".cart-item\").addClass(\"check-cart-item\");\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t$(\".cart-item\").removeClass(\"check-cart-item\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t$(\".j-checkbox\")\r\n");
      out.write("\t\t\t\t\t.change(\r\n");
      out.write("\t\t\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\t\t\tif ($(\".j-checkbox:checked\").length == $(\".j-checkbox\").length) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\".checkall\").prop(\"checked\", true);\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(\".checkall\").prop(\"checked\", false);\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif ($(this).prop(\"checked\")) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(this).parents(\".cart-item\").addClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\"check-cart-item\");\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t$(this).parents(\".cart-item\").removeClass(\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\"check-cart-item\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t$(\".increment\").click(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\tvar n = $(this).siblings(\".itxt\").val();\r\n");
      out.write("\t\t\t\t\t\tn++;\r\n");
      out.write("\t\t\t\t\t\t$(this).siblings(\".itxt\").val(n);\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t//查找parent元素 使用parents(\"elementname\");返回指定祖先元素\r\n");
      out.write("\t\t\t\t\t\tvar p = $(this).parents(\".p-num\").siblings(\".p-price\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.html();\r\n");
      out.write("\t\t\t\t\t\tp = p.substr(1);\r\n");
      out.write("\t\t\t\t\t\t$(this).parent().parent().siblings(\".p-sum\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"￥\" + (p * n).toFixed(2));\r\n");
      out.write("\t\t\t\t\t\tgetSum();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t$(\".decrement\").click(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\tvar n = $(this).siblings(\".itxt\").val();\r\n");
      out.write("\t\t\t\t\t\tif (n > 1) {\r\n");
      out.write("\t\t\t\t\t\t\tn--;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t$(this).siblings(\".itxt\").val(n);\r\n");
      out.write("\t\t\t\t\t\tvar p = $(this).parent().parent().siblings(\".p-price\")\r\n");
      out.write("\t\t\t\t\t\t\t\t.html();\r\n");
      out.write("\t\t\t\t\t\tp = p.substr(1);\r\n");
      out.write("\t\t\t\t\t\t// console.log(p);\r\n");
      out.write("\t\t\t\t\t\t$(this).parent().parent().siblings(\".p-sum\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"￥\" + (p * n).toFixed(2));//tofixed（）操作，保留两位小数\r\n");
      out.write("\t\t\t\t\t\tgetSum();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t$(\".itxt\").change(\r\n");
      out.write("\t\t\t\t\tfunction() {\r\n");
      out.write("\t\t\t\t\t\tvar n = $(this).val();\r\n");
      out.write("\t\t\t\t\t\tvar p = $(this).parents(\".p-num\").siblings(\".p-price\").html();\r\n");
      out.write("\t\t\t\t\t\tp = p.substr(1);\r\n");
      out.write("\t\t\t\t\t\t$(this).parent().parent().siblings(\".p-sum\").html(\r\n");
      out.write("\t\t\t\t\t\t\t\t\"￥\" + (p * n).toFixed(2));\r\n");
      out.write("\t\t\t\t\t\tgetSum();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t// 5. 计算总计和总额模块\r\n");
      out.write("\t\t\tgetSum();\r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction getSum() {\r\n");
      out.write("\t\t\t\tvar count = 0; // 计算总件数 \r\n");
      out.write("\t\t\t\tvar money = 0; // 计算总价钱\r\n");
      out.write("\t\t\t\t$(\".itxt\").each(function(i, ele) { //each遍历 第一个参数自定义 \r\n");
      out.write("\t\t\t\t\tcount += parseInt($(ele).val());\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\".amount-sum em\").text(count);\r\n");
      out.write("\t\t\t\t$(\".p-sum\").each(function(i, ele) {\r\n");
      out.write("\t\t\t\t\tmoney += parseFloat($(ele).text().substr(1));\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(\".price-sum em\").text(\"￥\" + money.toFixed(2));\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 由于只能写入string json.stringify 转了一下\r\n");
      out.write("\t\t\t//\tlocalStorage.setItem('orderlist', JSON.stringify(orderlist));\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t// 6. 删除商品模块\r\n");
      out.write("\t\t\t// (1) 商品后面的删除按钮\r\n");
      out.write("\t\t\t$(\".p-action a\").click(function() {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t//通过class获取id值\r\n");
      out.write("\t\t\t\tvar orderid = $(this).parents(\".cart-item\").attr(\"id\");\r\n");
      out.write("\t\t\t\t// 删除的是当前的商品 \r\n");
      out.write("\t\t\t\t$(this).parents(\".cart-item\").remove();\r\n");
      out.write("\t\t\t\tgetSum();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t// (2) 删除选中的商品\r\n");
      out.write("\t\t\t$(\".remove-batch\").click(function() {\r\n");
      out.write("\t\t\t\t// 删除的是小的复选框选中的商品\r\n");
      out.write("\t\t\t\t$(\".j-checkbox:checked\").parents(\".cart-item\").remove();\r\n");
      out.write("\t\t\t\tgetSum();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t// (3) 清空购物车 删除全部商品\r\n");
      out.write("\t\t\t$(\".clear-all\").click(function() {\r\n");
      out.write("\t\t\t\t$(\".cart-item\").remove();\r\n");
      out.write("\t\t\t\t$(\".cart-floatbar\").remove();\r\n");
      out.write("\t\t\t\tgetSum();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//7支付功能的实现\r\n");
      out.write("\t\t  $(\".all_pay\").click(function(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t  var goodsId=[];\r\n");
      out.write("\t\t\t  $(\".cart-item\").each(function(i, ele) { //each遍历 第一个参数自定义 \r\n");
      out.write("\t\t\t\t\tgoodsId.push($(ele).attr(\"id\"));\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t  console.log(goodsId);\r\n");
      out.write("\t\t\t  $(\".all-item-list\").after(\"<form action='myOrder.jsp' method='GET' class='form_delete'><form>\");\r\n");
      out.write("\t\t\t  for(var i=0;i<goodsId.length;i++){\r\n");
      out.write("\t\t\t\t  $(\".form_delete\").prepend(\"<input class='d_goodsid' name='d_goodsid\"+i+\"' value='\"+goodsId[i]+\"'> \");\r\n");
      out.write("\t\t\t  }\r\n");
      out.write("\t\t\t  $(\".form_delete\").append(\"<input class='d_num' name='d_numid' value='\"+goodsId.length+\"'>是否确定保存你所要保存的订单：<button type='submit'>确认</button>\")\r\n");
      out.write("\t\t              alert(\"支付成功！\"); \r\n");
      out.write("\t\t\t  })\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
