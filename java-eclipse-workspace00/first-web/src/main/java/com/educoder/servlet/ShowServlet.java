package com.educoder.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.educoder.entity.Goods;
import com.educoder.service.GoodsService;
import com.educoder.service.impl.GoodsServiceImpl;

@WebServlet("/home.jsp")
public class ShowServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	private GoodsService goodsService = new GoodsServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// index.jsp包含登录和注册模块，显示按键登录和注册
		request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
	}

	/**
	 * 首页商品页面跳转
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void mainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("显示main.jsp页面");
//		List<Goods> dessert = goodsService.getGoodsList();
//		request.setAttribute("dessert", dessert);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	public void goodsInfoPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("显示goodsInfo.jsp页面");
		// 查其详情 ，查找商品详情
//		String goodsId = request.getParameter("goodsId");
//		Goods goods = goodsService.getGoodsByGoodsId(goodsId);
//		request.setAttribute("goods", goods);
		request.getRequestDispatcher("WEB-INF/pages/goodsInfo.jsp").forward(request, response);
	}

	// searchGoods
	public void searchGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取页面的搜索信息
		String condition = request.getParameter("condition");
		System.out.println(condition);
		List<Goods> goodsList = goodsService.searchGoods(condition);

		request.getSession().setAttribute("goodsListBySearch", goodsList);
		// 特殊需要，暂时存在session，前台ajax收到消息后，转到result处理掉
		response.setContentType("text/html; charset=UTF-8");
		String stringer = null;
		if (goodsList.size() == 0) {
			stringer = "fail";
		} else {
			stringer = "success";
		}
		response.getOutputStream().write(stringer.getBytes("UTF-8"));
	}

	public void result(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Goods> goodsList = (List<Goods>) request.getSession().getAttribute("goodsListBySearch");
		request.getSession().removeAttribute("goodsListBySearch");
		request.setAttribute("goodsListBySearch", goodsList);
		request.getRequestDispatcher("WEB-INF/pages/goodsList.jsp").forward(request, response);
	}
}
