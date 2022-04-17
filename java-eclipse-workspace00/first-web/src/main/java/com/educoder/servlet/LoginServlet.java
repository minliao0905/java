package com.educoder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educoder.dao.MycontrolDao;
import com.educoder.dao.ShopsDao;
import com.educoder.dao.UserDao;
import com.educoder.dao.Impl.MycontrolDaoImpl;
import com.educoder.dao.Impl.ShopsDaoImpl;
import com.educoder.dao.Impl.UserDaoImpl;
import com.educoder.entity.Shops;
import com.educoder.entity.User;

@WebServlet("/login.jsp")
public class LoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserDao userdao = new UserDaoImpl();
	ShopsDao shopdao = new ShopsDaoImpl();
	MycontrolDao mycontroldao = new MycontrolDaoImpl();
	Object loginUser = null;
//

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 跳转到登录界面
		// 获取登录模式
//		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
//	    req.setCharacterEncoding("UTF-8"); // 客户端网页我们控制为UTF-8防止乱码---无效
		String modelId = req.getParameter("modelId");
		String userId = req.getParameter("userId");

		String username = req.getParameter("userName");
		username = new String(username.getBytes("ISO-8859-1"), "utf-8"); // 有效
//		System.out.println("username:" + username);
		String password = req.getParameter("passWord");
		System.out.println("modelId  " + modelId);
//
//		HttpSession session1 = req.getSession();
//		session1.setAttribute("modelId", modelId);
//		req.setAttribute("modelId", modelId);
//		Object loginUser = null;
		if (modelId != null) {
			if (modelId.equals("User")) {
				loginUser = (User) userdao.selectUserByIdAndPass(userId, password);
				if (loginUser != null) {
					System.out.println("查找结果为：" + loginUser.toString() + "\n该跳转主界面--main界面" + "并且将user数据存入");
					HttpSession session = req.getSession();
					session.setAttribute("user", loginUser);
					req.setAttribute("user", loginUser);

					req.setAttribute("message", "ok");
					req.getRequestDispatcher("main.jsp").forward(req, resp);
				} else {
					System.out.println("该userId不存在，查找错误 ,重新跳转主界面");
					req.setAttribute("message", "wrong");
					req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
				}
			} else if (modelId.equals("shops")) {
				// 2，进行shops数据库查找
				loginUser = (Shops) shopdao.selectShopsByIdAndPass(userId, password);
				if (loginUser != null) {
					System.out.println("商家用户进行登录,跳转商家界面" + loginUser.toString());
					HttpSession session = req.getSession();
					session.setAttribute("shops", loginUser);
					// 当切换用户时 出现了主页面的导航栏信息无法改变的错误
					req.setAttribute("shops", loginUser);
					req.setAttribute("message", "ok");
					req.getRequestDispatcher("/WEB-INF/shops/shops.jsp").forward(req, resp);
				} else {
					req.setAttribute("message", "wrong");
					req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
				}

			} else if (modelId.equals("mycontrol")) {
				// 查找操作
				loginUser = (User) mycontroldao.selectShopsByIdAndPass(userId, password);
				if (loginUser != null) {
					System.out.println("控制用户进行登录,跳转控制界面" + loginUser.toString());
					HttpSession session = req.getSession();
					session.setAttribute("control", loginUser);
					// 当切换用户时 出现了主页面的导航栏信息无法改变的错误
					req.setAttribute("control", loginUser);
					req.setAttribute("message", "ok");
					req.getRequestDispatcher("/WEB-INF/mycontrol/mycontrol.jsp").forward(req, resp);
				} else {
					req.setAttribute("message", "wrong");
					req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
				}
			}

		}
	}

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Loginervlet执行业务操作");
//		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
//		doPost(req, resp);
//    
//	}

	public void loginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("选择登录，跳转登录界面");
		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);

	}

}
