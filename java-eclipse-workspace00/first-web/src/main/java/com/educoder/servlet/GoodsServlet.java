package com.educoder.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.dao.GoodsDao;
import com.educoder.dao.Impl.GoodsDaoImpl;
import com.educoder.entity.Goods;
import com.educoder.entity.Order;

@WebServlet("/goods.jsp")
public class GoodsServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private GoodsDao goodsdao = new GoodsDaoImpl();

	List<Order> orderlist = new ArrayList<Order>();

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("获取提交的商品存入数据库");
		req.setCharacterEncoding("UTF-8");// 客户端网页我们控制为UTF-8
		String goodsid = req.getParameter("p-id");
		String goodsname = req.getParameter("p-goods");
		String price = req.getParameter("p-price");
		BigDecimal goodsprice = new BigDecimal(price);
		Integer goodsnum = Integer.parseInt(req.getParameter("p-num"));
		String goodsfrom = req.getParameter("p-from");
		String goodsimg = req.getParameter("p-img");
		String goodsdescription = req.getParameter("p-description");
		String goodsclassfiy = req.getParameter("p-classfiy");
		Goods goods = new Goods();
		goods.setGoodsId(goodsid);
		goods.setGoodsName(goodsname);
		goods.setGoodsPrice(goodsprice);
		goods.setGoodsFrom(goodsfrom);
		goods.setGoodsNum(goodsnum);
		goods.setGoodsDescribe(goodsdescription);
		goods.setGoodsImg(goodsimg);
		goods.setGoodsClass(goodsclassfiy);

		goodsdao.insert_c(goods);

//		req.getRequestDispatcher("/WEB-INF/shops/.jsp").forward(req, resp);
//	 当提交表单时return false 即可实现页面不跳转但数据提交成功！

	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("商家添加商品");
		doPost(req, resp);
	}

}
