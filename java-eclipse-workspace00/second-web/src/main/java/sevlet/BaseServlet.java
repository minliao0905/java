package sevlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)

			throws ServletException, IOException {

		String name = req.getParameter("page");

		@SuppressWarnings("rawtypes")
		Class c = this.getClass();
		Method method = null;
		if (name == null || name.isEmpty()) {
			try {
				method = c.getMethod("doPost", HttpServletRequest.class, HttpServletResponse.class);
				method.invoke(this, req, resp);
				return;
			} catch (SecurityException e) {
				throw new RuntimeException("未定义加载异常");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		try {
			method = c.getMethod(name, HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			req.getRequestDispatcher("/404.jsp").forward(req, resp);
		}

		try {
			method.invoke(this, req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
