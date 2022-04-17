package com.educoder.service;

import java.util.List;

import com.educoder.entity.Goods;

public interface GoodsService {

	Goods getGoodsByGoodsId(String goodsId);

	/**
	 * @param condition
	 * @return
	 */
	List<Goods> searchGoods(String condition);

	/**
	 * @param string
	 * @return
	 */
	List<Goods> getGoodsList();

}
