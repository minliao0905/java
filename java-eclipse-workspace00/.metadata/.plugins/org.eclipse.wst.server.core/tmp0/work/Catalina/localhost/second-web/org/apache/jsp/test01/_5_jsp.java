/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.108
 * Generated at: 2021-05-13 13:22:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.test01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class _5_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>网上试题自动评判——评测</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 String s1=request.getParameter("r1");
    if(s1!=null){
        out.println("一、 解答为2+3="+s1+" ");
        if(s1.equals("5"))
            out.println("正确"+"<br>");
        else
            out.println("错误"+"<br>");
    }
    else
        out.println("一、没有解答！"+"<br>");
    out.println("------------------<br>");
    String[] s2=request.getParameterValues("c1");
    if(s2!=null){
        out.println("二、 解答为:偶数有：");
        for(int i=0;i<s2.length;i++){
            out.println(s2[i]+" ");
        }
        if(s2.length==2&&s2[0].equals("2")&&s2[1].equals("4"))
            out.println("正确!"+"<br>");
        else
            if(s2.length==1&&(s2[0].equals("2")||s2[0].equals("4")))
                out.println("部分正确!"+"<br>");
            else
                out.println("错误!"+"<br>");

    }
    else
        out.println("二、没有解答！"+"<br>");
    out.println("------------------<br>");
    String[] s3=request.getParameterValues("list1");
    if(s3!=null){
        out.println("三、 解答为：动态网页有：");
        for(int i=0;i<s3.length;i++)
            out.println(s3[i]+" ");
        if(s3.length==3&&s3[0].equals("asp")&&s3[1].equals("php")&&s3[2].equals("jsp"))
            out.println("正确！"+"<br>");
        else
            out.println("错误！"+"<br>");
    }
    else
        out.println("三、没有解答！"+"<br>");
    out.println("------------------<br>");
    String s4=request.getParameter("list2");
    if(s4!=null){
        out.println("四、解答为：服务器端的组件有：");
        out.println(s4+" ");
        if(s4!=null&&s4.equals("servlet"))
            out.println("正确！"+"<br>");
        else
            out.println("错误！"+"<br>");
    }
    else
        out.println("四、没有解答！"+"<br>");
    out.println("------------------<br>");
    String s5=request.getParameter("text1");
    if(s1!=null){
        out.println("五、解答为：");
        out.println(s5+" ");
        if(s5!=null&&s5.equals("request"))
            out.println("正确!"+"<br>");
        else
            out.println("错误！"+"<br>");
    }
    else
        out.println("五、没有解答！"+"<br>");
    out.println("------------------<br>");

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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