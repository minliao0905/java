package com.educoder.dao;

import java.util.List;

import com.educoder.entity.Order;

public interface OrderDao {
	int deleteByPrimaryKey(String orderId);

	boolean insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(String orderId);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	/**
	 * @param userId
	 * @return
	 */
	public boolean changeCheck(String check, String OrderId);

	List<Order> selectByUserId(String userId);

	boolean deleteByOrderId(String orderId);
}