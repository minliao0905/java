package com.educoder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.GoodsDao;
import com.educoder.dao.OrderDao;
import com.educoder.dao.UserDao;
import com.educoder.dao.Impl.GoodsDaoImpl;
import com.educoder.dao.Impl.OrderDaoImpl;
import com.educoder.dao.Impl.UserDaoImpl;
import com.educoder.service.AddressService;
import com.educoder.service.impl.AddressServiceImpl;

@WebServlet("/shops.jsp")
public class ShopsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AddressService addressService = new AddressServiceImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private UserDao userDao = new UserDaoImpl();
	private GoodsDao goodsdao = new GoodsDaoImpl();

	// 跳至用户信息页面
	public void shopsInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("shopsinfoPage");
		request.getRequestDispatcher("/WEB-INF/shops/shopsInfo.jsp").forward(request, response);
	}

	public void shopsmainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("shopsmainPage");
		request.getRequestDispatcher("/WEB-INF/shops/shops.jsp").forward(request, response);
	}

	public void shopslistPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("shopslistPage");
		request.getRequestDispatcher("/WEB-INF/shops/shopslist.jsp").forward(request, response);
	}

	public void shopsnewgoodsPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("shopsgoodsPage");
		request.getRequestDispatcher("/WEB-INF/shops/newgoods.jsp").forward(request, response);
	}

}
