package com.educoder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.GoodsDao;
import com.educoder.dao.OrderDao;
import com.educoder.dao.Impl.GoodsDaoImpl;
import com.educoder.dao.Impl.OrderDaoImpl;

@WebServlet("/checkder.jsp")
public class checkorder extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsDao goodsdao = new GoodsDaoImpl();

	OrderDao orderdao = new OrderDaoImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int num = Integer.parseInt((String) req.getParameter("ch-num"));
		for (int i = 0; i < num; i++) {
			String ordersid = req.getParameter("ch-id" + i);
			System.out.println("修改的id" + ordersid);
			if (ordersid != null) {
				orderdao.changeCheck("已收货", ordersid);
			}
		}
	}

//		req.getRequestDispatcher("/WEB-INF/mycontrol/controllist.jsp").forward(req, resp);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("用户修改订单");
		doPost(req, resp);
	}
}
