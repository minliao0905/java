package com.educoder.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.OrderDao;
import com.educoder.dao.Impl.OrderDaoImpl;
import com.educoder.entity.Order;
import com.educoder.entity.User;

@WebServlet("/goodsinfo.jsp")
public class BuyServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderDao orderdao = new OrderDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");// 客户端网页我们控制为UTF-8
		System.out.println("获取要添加的商品");
		Random random = new Random();
		int num = Integer.parseInt(req.getParameter("goodnum"));
		for (int i = 0; i < num; i++) {
			String goodIditem = "goodsid" + (i + 1);
			System.out.println(goodIditem);
			String orderId = req.getParameter(goodIditem) + random.nextInt(100);
			String goodsId = req.getParameter(goodIditem);
			String goodsname = req.getParameter("goodsname" + (i + 1));
			String price = req.getParameter("goodsprice" + (i + 1));
			String address = req.getParameter("uaddress");
			BigDecimal goodsprice = new BigDecimal(price);// 数据类型的转换
			System.out.println("订单信息" + orderId + goodsId + goodsname + goodsprice);
			Order order = new Order();
			Date date = new Date(121, 10, 11);
			order.setOrderTime(date);
			order.setOrderId(orderId);
			order.setGoodsId(goodsId);
			order.setGoodsName(goodsname);
			order.setGoodsPrice(goodsprice);
			order.setAddressId(address);
			User user = (User) req.getSession().getAttribute("user");
			order.setUserId(user.getUserId());
			System.out.println(order.toString());
			orderdao.insert(order);
		}

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CartServlet执行业务操作");
		doPost(req, resp);
		req.getRequestDispatcher("goodsInfo.jsp").forward(req, resp);
	}

	public void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
