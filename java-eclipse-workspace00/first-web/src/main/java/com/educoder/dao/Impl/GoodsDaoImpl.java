package com.educoder.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.educoder.dao.GoodsDao;
import com.educoder.entity.Goods;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public int deleteByPrimaryKey(String goodsId) {

		return 0;
	}

	@Override
	public boolean insert(Goods good) {
		String sql = "insert into t_goods (goodsId,goodsName,goodsImg,goodsPrice,goodsNum,goodsFrom,goodsDescribe,goodsclass)   values(?,?,?,?,?,?,?,?)";

		List<Object> parameters = new ArrayList<Object>();
		parameters.add(good.getGoodsId());
		parameters.add(good.getGoodsName());
		parameters.add(good.getGoodsImg());
		parameters.add(good.getGoodsPrice());
		parameters.add(good.getGoodsNum());
		parameters.add(good.getGoodsFrom());
		parameters.add(good.getGoodsDescribe());
		parameters.add(good.getGoodsClass());
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public int insertSelective(Goods good) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods selectByPrimaryKey(String goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goods> selectByShopsId(String shopsId) {
		String sql = "select * from t_goods  ";
		List<Object> parameters = new ArrayList<Object>();
		List<Goods> goodslist = null;
		try {
			goodslist = BaseDao.operQuery(sql, parameters, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (goodslist.size() == 0) {
			return null;
		}
//		System.out.println("查找orderlist" + orderlist);
		return goodslist;
	}

	@Override
	public boolean deleteByGoodsId(String shopsId) {
		String sql = "delete  from t_goods where goodsId = '" + shopsId + "' ";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteByPrimaryKey_c(String goodsId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insert_c(Goods good) {
		String sql = "insert into t_goodscheck (goodsId,goodsName,goodsImg,goodsPrice,goodsNum,goodsFrom,goodsDescribe,goodsclass)   values(?,?,?,?,?,?,?,?)";

		List<Object> parameters = new ArrayList<Object>();
		parameters.add(good.getGoodsId());
		parameters.add(good.getGoodsName());
		parameters.add(good.getGoodsImg());
		parameters.add(good.getGoodsPrice());
		parameters.add(good.getGoodsNum());
		parameters.add(good.getGoodsFrom());
		parameters.add(good.getGoodsDescribe());
		parameters.add(good.getGoodsClass());
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public int insertSelective_c(Goods good) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods selectByPrimaryKey_c(String goodsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective_c(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey_c(Goods goods) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Goods> selectByShopsId_c(String shopsId) {
		return null;
	}

	@Override
	public boolean deleteByGoodsId_c(String shopsId) {
		String sql = "delete  from t_goodscheck where goodsId = '" + shopsId + "' ";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Goods> selectAll() {
		String sql = "select * from t_goods ";
		List<Object> parameters = new ArrayList<Object>();
		List<Goods> goodslist = null;
		try {
			goodslist = BaseDao.operQuery(sql, parameters, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (goodslist.size() == 0) {
			return null;
		}
		return goodslist;
	}

	@Override
	public List<Goods> selectAll_c() {
		String sql = "select * from t_goodscheck  ";
		List<Object> parameters = new ArrayList<Object>();
		List<Goods> goodslist = null;
		try {
			goodslist = BaseDao.operQuery(sql, parameters, Goods.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (goodslist == null) {
			return null;
		}
		return goodslist;
	}

	@Override
	public boolean addByGoodsId_c(String goodsid) {
		String sql = "insert into t_goods (goodsId,goodsName,goodsImg,goodsPrice,goodsNum,goodsFrom,goodsDescribe,goodsclass) "
				+ " select * from t_goodscheck where goodsId = '" + goodsid + "'";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

}
