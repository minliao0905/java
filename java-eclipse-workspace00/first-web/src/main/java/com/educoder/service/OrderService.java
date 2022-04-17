package com.educoder.service;

import java.util.List;

import com.educoder.entity.Order;

public interface OrderService {

	/**
	 * @param goodsIdArray
	 * @param goodsBuyNum
	 * @return
	 */
	Order submitOrder(String userId, String addressId, String[] goodsBuyNum, String[] isChoose);

	/**
	 * @param userId
	 * @return
	 */
	static List<Order> getOrderByUserId(String userId) {
		//
		return null;
	}

}
