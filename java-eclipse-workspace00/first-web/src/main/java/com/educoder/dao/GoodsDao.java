package com.educoder.dao;

import java.util.List;

import com.educoder.entity.Goods;

public interface GoodsDao {
	int deleteByPrimaryKey(String goodsId);

	boolean insert(Goods good);

	int insertSelective(Goods good);

	Goods selectByPrimaryKey(String goodsId);

	int updateByPrimaryKeySelective(Goods goods);

	int updateByPrimaryKey(Goods goods);

	/**
	 * @param userId
	 * @return
	 */
	List<Goods> selectByShopsId(String shopsId);

	List<Goods> selectAll();

	boolean deleteByGoodsId(String shopsId);

//////////////	////////////////////////////////////////////

	int deleteByPrimaryKey_c(String goodsId);

	boolean insert_c(Goods good);

	int insertSelective_c(Goods good);

	Goods selectByPrimaryKey_c(String goodsId);

	int updateByPrimaryKeySelective_c(Goods goods);

	int updateByPrimaryKey_c(Goods goods);

	/**
	 * @param userId
	 * @return
	 */
	List<Goods> selectByShopsId_c(String shopsId);

	List<Goods> selectAll_c();

	boolean deleteByGoodsId_c(String shopsId);

	boolean addByGoodsId_c(String goodsid);

}
