package sevlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dao.impl.userDaoimpl;
import entity.User;

@WebServlet("/sevlet_8")
public class sevlet_8 extends BaseServlet {

	private static final long serialVersionUID = 1L;
	userdao usersdao = new userDaoimpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 跳转到登录界面

		String userId = req.getParameter("userId");
		String username = req.getParameter("userName");
		String password = req.getParameter("passWord");
		// 查找用户是否存在
		User user = usersdao.selectUserById(userId);
		if (user != null) {
			System.out.println("查找结果为：" + user.toString() + "\n该跳转主界面--main界面" + "并且将user数据存入");
			req.setAttribute("user", user);
			req.getRequestDispatcher("8/paramsForm.jsp").forward(req, resp);

		} else {
			System.out.println("该userId不存在，查找错误 ,重新跳转主界面");
			req.setAttribute("usernumer", -1);
			req.getRequestDispatcher("8/paramsForm.jsp").forward(req, resp);
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Loginervlet执行业务操作");
		doPost(req, resp);

	}
}
