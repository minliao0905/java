package com.educoder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.ShopsDao;
import com.educoder.dao.UserDao;
import com.educoder.dao.Impl.ShopsDaoImpl;
import com.educoder.dao.Impl.UserDaoImpl;
import com.educoder.entity.Shops;
import com.educoder.entity.User;

@WebServlet("/Register.jsp")
//注册新用户页面的servlet
public class RegisterServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserDao userdao = new UserDaoImpl();
	ShopsDao shopsdao = new ShopsDaoImpl();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String modelId = req.getParameter("modelId");
		String userId = req.getParameter("userId");
		String username = req.getParameter("userName");
		String password = req.getParameter("nowpwd");
		Object loginUser = new Object();
		if (userId == "" || username == "" || password == "") {
			System.out.println("无法确认信息");
			return;
		}
//		查找确定模式
		if (modelId != null) {
			if (modelId.equals("User")) {
				loginUser = userdao.selectUserById(userId);
				if (loginUser != null) {
					System.out.println("查找结果为：" + loginUser.toString() + "该跳转用户界面" + "当前用户id已经被占用无法注册");

					req.setAttribute("message", "wrong");
					req.getRequestDispatcher("/WEB-INF/user/Register.jsp").forward(req, resp);

				} else {
					User newuser = new User(userId, username, password);
					if (userdao.insertUser(newuser)) {
						System.out.println("注册成功！" + newuser.toString());
						req.setAttribute("message", "ok");
						req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
					}
				}
			} else if (modelId.equals("shops")) {
				// 未创建该类文件，进行shops数据库查找
				loginUser = shopsdao.selectShopsById(userId);
				if (loginUser != null) {
					System.out.println("查找结果为：" + loginUser.toString() + "该跳转用户界面" + "当前用户id已经被占用无法注册");

					req.setAttribute("message", "wrong");
					req.getRequestDispatcher("/WEB-INF/user/Register.jsp").forward(req, resp);

				} else {
					Shops newuser = new Shops(userId, username, password);
					if (shopsdao.insertShopsUser(newuser)) {
						System.out.println("注册成功！" + newuser.toString());
						req.setAttribute("message", "ok");
						req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
					}
				}

			} else if (modelId.equals("mycontrol")) {
				// 查找操作
//				loginUser = MycontrolDao.selectMycontrolById(userId);
			}
		}
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("registert执行业务操作");
//
//		req.getRequestDispatcher("/WEB-INF/user/Register.jsp").forward(req, resp);
//		doPost(req, resp);
////		req.getRequestDispatcher("main.jsp").forward(req, resp);
//		// 返回登录主界面
//	}

//	 跳至用户信息界面
//	public void userPage(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/user/userInfo.jsp").forward(request, response);
//	}
//
//	public void orderPage(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		List<Order> orderList = OrderService.getOrderByUserId(user.getUserId());
//		request.setAttribute("orderList", orderList);
//		request.getRequestDispatcher("/WEB-INF/user/myOrder.jsp").forward(request, response);
//	}

	public void registerPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("用户选择注册，跳转登录界面");
		req.getRequestDispatcher("/WEB-INF/user/Register.jsp").forward(req, resp);
	}
}
