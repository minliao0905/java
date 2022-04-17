package com.educoder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.OrderDao;
import com.educoder.dao.Impl.OrderDaoImpl;
import com.educoder.entity.Order;

/**
 * Servlet implementation class helloServlet
 */
/**
 * 一。在Servlet 与 jsp 页面的交互中 主要存在 四种请求 1、jsp 请求 servlet
 * 
 * 2、servlet 重定向到 jsp
 * 
 * 3、servlet 重定向到 servlet
 * 
 * 4、jsp 请求 jsp
 * 
 *  1、jsp项目的根目录是 WebContent 这个文件夹
 * 
 *      2、servlet绝对路径：填写请求路径时最前面加了"/" 就是绝对路径，他的含义就是从根目录WebContent下开始查找
 * 
 *      3、servlet相对路径：填写请求路径时最前面不加"/" 就是相对路径，他的含义就是从该文件所在路径开始查找
 * 
 *      4、servlet中的注解：@WebServlet()中填写的内容为 路径+名称
 * 的形式，就可以看作是把这个servlet起名为名称然后把它映射到路径这个位置上（注解中的路径一般为绝对路径）
 * 
 *      5、jsp文件中填写的路径同html中的路径一样，在jsp文件中都使用相对路径，“./”表示当前目录，“/”表示下层目录，“../”表示上层目录
 */
//该界面可跳转用户信息
@WebServlet("/myOrder.jsp")
public class myOrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderDao orderdao = new OrderDaoImpl();

	List<Order> orderlist = new ArrayList<Order>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("myOrder执行业务操作");
		String userId = req.getParameter("userId");
		orderlist = orderdao.selectByUserId(userId);
		// 查找用户是否存在
		List<Order> orderlist = orderdao.selectByUserId(userId);
		if (orderlist != null) {
			System.out.println("查找购物车信息成功！" + orderlist);
			req.setAttribute("orderlist", orderlist);

		} else {
			System.out.println("该userId不存在，查找错误 ,重新跳转登录界面");
//			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("获取保存的商品Id");
		int num = Integer.parseInt(req.getParameter("d_numid"));

		for (int i = 0; i < num; i++) {
			int flag = 0;
			String d_goodid = "d_goodsid" + i;
			String ordersid = req.getParameter(d_goodid);
			System.out.println("获取的商品id" + ordersid);
			if (orderlist != null) {
				for (int j = 0; i < orderlist.size(); j++) {
					if (orderlist.get(j).getOrderId() == ordersid) {
						flag = 1;
					}
				}
			}
			if (flag == 0) {
				System.out.println("删除当前Order" + ordersid);
				orderdao.deleteByOrderId(ordersid);

			}
		}
		req.getRequestDispatcher("/WEB-INF/user/myOrder.jsp").forward(req, resp);

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("用户查看订单");
		doPost(req, resp);
		if (req.getParameter("d_goodsid1") != null) {
			doGet(req, resp);
		}

	}

	public void myOrderPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("用户查看订单");
//		req.getRequestDispatcher("/WEB-INF/user/myOrder.jsp").forward(req, resp);
	}

}
