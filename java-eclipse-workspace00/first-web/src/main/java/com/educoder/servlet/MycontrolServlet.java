package com.educoder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.GoodsDao;
import com.educoder.dao.Impl.GoodsDaoImpl;
import com.educoder.entity.Goods;

@WebServlet("/mycontrol.jsp")
public class MycontrolServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	GoodsDao goodsdao = new GoodsDaoImpl();

	// 跳至用户信息页面
	public void MycontrolPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mycontrolPage");
		req.getRequestDispatcher("/WEB-INF/mycontrol/mycontrol.jsp").forward(req, resp);
	}

	public void controllistPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("mycontrollistPage");

		// 查找用户是否存在
		List<Goods> goodslist = goodsdao.selectAll_c();
		if (goodslist != null) {
			System.out.println("查找申请的商品信息成功！" + goodslist);
			req.setAttribute("goods_clist", goodslist);

		} else {
			System.out.println("查找错误");
//			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/WEB-INF/mycontrol/controllist.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("de-num"));
		for (int i = 0; i <= num1; i++) {
			String goodsid = req.getParameter("de-id" + i);
			System.out.println("当前删除的商品号为：" + goodsid);
			goodsdao.deleteByGoodsId_c(goodsid);
		}
		int num2 = Integer.parseInt(req.getParameter("ag-num"));
		for (int i = 0; i <= num2; i++) {
			String goodsid = req.getParameter("ag-id" + i);
			System.out.println("当前同意的商品号为：" + goodsid);
			goodsdao.addByGoodsId_c(goodsid);
		}

//		req.getRequestDispatcher("/WEB-INF/mycontrol/controllist.jsp").forward(req, resp);
	}

}
