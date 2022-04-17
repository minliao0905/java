package com.educoder.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educoder.dao.Impl.BaseDao;
import com.educoder.entity.Goods;
import com.educoder.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {

	/**
	 * 商品详情接口
	 */
	public Goods getGoodsByGoodsId(String goodsId) {
		/********* Begin *********/
		String sql = "select * from t_goods where goodsId =  '" + goodsId + "'";
		List<Goods> goodsList = null;
		try {
			goodsList = BaseDao.operQuery(sql, null, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return goodsList.get(0);
		/********* End *********/
	}

	/**
	 * 商品搜索接口
	 */
	public List<Goods> searchGoods(String condition) {
		/********* Begin *********/

		String sql = "select * from t_goods where goodsName like  '%" + condition + "%'";
		List<Goods> goodsList = null;
		try {
			goodsList = BaseDao.operQuery(sql, null, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return goodsList;

		/********* End *********/
	}

	/**
	 * 商品列表接口
	 */
	public List<Goods> getGoodsList() {
		/********* Begin *********/

		String username = "root";
		String password = "123123";
		String url = "jdbc:mysql://127.0.0.1:3306/online_shop?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";

		String sql = "select * from t_goods order  by salesNum desc limit 4";
		List<Goods> li = new ArrayList<Goods>();
		try {

			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			con = DriverManager.getConnection(url, username, password);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Goods good = new Goods();
				good.setGoodsId(rs.getString("goodsId"));
				good.setGoodsName(rs.getString("goodsName"));
				good.setGoodsImg(rs.getString("goodsImg"));
				good.setGoodsPrice(rs.getBigDecimal("goodsPrice"));
				good.setGoodsNum(rs.getInt("goodsNum"));
				good.setSalesNum(rs.getInt("salesNum"));
				good.setGoodsSize(rs.getString("goodsSize"));
				good.setGoodsFrom(rs.getString("goodsFrom"));
				good.setGoodsTime(rs.getString("goodsTime"));
				good.setGoodsSaveCondition(rs.getString("goodsSaveCondition"));
				good.setGoodsDescribe(rs.getString("goodsDescribe"));
				good.setGoodsExplain(rs.getString("goodsExplain"));
				good.setGoodsClass(rs.getString("goodsClass"));
				good.setGoodsDiscount(rs.getBigDecimal("goodsDiscount"));
				good.setDiscountStartTime(rs.getDate("discountStartTime"));
				good.setDiscountEndTime(rs.getDate("discountEndTime"));
				li.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return li;
		/********* End *********/
	}

}
