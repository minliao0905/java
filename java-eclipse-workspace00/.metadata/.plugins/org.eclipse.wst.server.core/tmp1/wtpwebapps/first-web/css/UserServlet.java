package com.educoder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educoder.dao.OrderDao;
import com.educoder.dao.UserDao;
import com.educoder.dao.Impl.OrderDaoImpl;
import com.educoder.dao.Impl.UserDaoImpl;
import com.educoder.entity.Address;
import com.educoder.entity.Order;
import com.educoder.entity.User;
import com.educoder.service.AddressService;
import com.educoder.service.impl.AddressServiceImpl;

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
@WebServlet("/user-main.jsp")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private AddressService addressService = new AddressServiceImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	// 跳至用户信息页面
	public void userInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("userinfoPage");
		request.getRequestDispatcher("/WEB-INF/user/userInfo.jsp").forward(request, response);
	}

	public void usermainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("usermainPage");
		request.getRequestDispatcher("/WEB-INF/user/user-main.jsp").forward(request, response);
	}

	public void checkOrderPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("checkorderPage");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			System.out.println(user.getUserId());
			List<Order> orderList = orderDao.selectByUserId(user.getUserId());

			request.setAttribute("orderList", orderList);
		}

		request.getRequestDispatcher("/WEB-INF/user/checkorder.jsp").forward(request, response);
	}

	// 读取用户订单信息，跳至订单页面
	public void orderPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("0rderPage");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			System.out.println("usermain的" + user.getUserId());
			List<Order> orderList = orderDao.selectByUserId(user.getUserId());
			request.setAttribute("orderList", orderList);
		}

		request.getRequestDispatcher("/WEB-INF/user/shoppingCart.jsp").forward(request, response);
	}

	public void myOrderPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("myorderPage");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {
			System.out.println(user.getUserId());
			List<Order> orderList = orderDao.selectByUserId(user.getUserId());

			request.setAttribute("orderList", orderList);
		}

		request.getRequestDispatcher("/WEB-INF/user/myOrder.jsp").forward(request, response);
	}

	// 读取用户地址信息，跳至地址页面
	public void addressPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Address> addressList = null;
		addressList = addressService.getAddressByUserId(user.getUserId());
		request.setAttribute("addressList", addressList);
		request.getRequestDispatcher("/WEB-INF/user/myAddress.jsp").forward(request, response);
	}

}
