package com.educoder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.OrderDao;
import com.educoder.dao.Impl.OrderDaoImpl;
import com.educoder.entity.Order;

@WebServlet("/shoppingCart.jsp")
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	OrderDao orderdao = new OrderDaoImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");

		// 查找用户是否存在
		List<Order> orderlist = orderdao.selectByUserId(userId);
		if (orderlist != null) {
			System.out.println("查找购物车信息成功！" + orderlist);
			req.setAttribute("orderlist", orderlist);

		} else {
			System.out.println("该userId不存在，查找错误 ,重新跳转登录界面");
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("CartServlet执行业务操作");
		doPost(req, resp);

	}

	public void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 跳转到登录界面
		System.out.println("用户选择登录，跳转登录界面");

		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
	}

}
