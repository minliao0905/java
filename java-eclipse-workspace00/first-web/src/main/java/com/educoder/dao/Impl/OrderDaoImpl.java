package com.educoder.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.educoder.dao.OrderDao;
import com.educoder.entity.Order;

public class OrderDaoImpl implements OrderDao {

	@Override
	public boolean deleteByOrderId(String orderId) {
		String sql = "delete from t_order where orderid = ?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(orderId);
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;

	}

	@Override
	public boolean insert(Order record) {
		// TODO Auto-generated method stub
		String sql = "insert into  t_order ";
		String sql2 = "(orderId,userId,orderTime,addressId,goodsId,goodsName,goodsImg,goodsPrice,goodsCheck) ";
		String sql3 = "values(?,?,?,?,?,?,?,?,?) ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(record.getOrderId());
		parameters.add(record.getUserId());
		parameters.add(record.getOrderTime());
		parameters.add(record.getAddressId());
		parameters.add(record.getGoodsId());
		parameters.add(record.getGoodsName());
		parameters.add(record.getGoodsImg());
		parameters.add(record.getGoodsPrice());
		parameters.add("未发货");
		sql = sql + sql2 + sql3;
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order selectByPrimaryKey(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> selectByUserId(String userId) {
		String sql = "select * from t_order where userId = ? ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(userId);
		List<Order> orderlist = null;
		try {
			orderlist = BaseDao.operQuery(sql, parameters, Order.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (orderlist.size() == 0) {
			return null;
		}
//		System.out.println("查找orderlist" + orderlist);
		return orderlist;
	}

	@Override
	public int deleteByPrimaryKey(String orderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean changeCheck(String check, String OrderId) {
		String sql = "update t_order set goodsCheck = '" + check + "' where orderId = '" + OrderId + "'";
		boolean res = BaseDao.operUpdate(sql, null);
		return res;
	}

}
