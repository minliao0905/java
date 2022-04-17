package com.educoder.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.educoder.dao.ShopsDao;
import com.educoder.entity.Shops;

public class ShopsDaoImpl implements ShopsDao {

	@Override
	public boolean insertShopsUser(Shops shops) {
		// TODO Auto-generated method stub
		String sql2 = "(shopsId, ";
		String sql3 = "values(?, ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(shops.getShopsId());
		// 判断是否存在用户，存在用户名字和密码
		if (shops.getShopsName() != null) {
			sql2 += "shopsName, ";
			sql3 += "?, ";
			parameters.add(shops.getShopsName());
		}
		if (shops.getShopsManager() != null) {
			sql2 += "shopsManager, ";
			sql3 += "?, ";
			parameters.add(shops.getShopsManager());
		}
		if (shops.getShopsAddress() != null) {
			sql2 += "shopsAdress, ";
			sql3 += "?, ";
			parameters.add(shops.getShopsAddress());
		}
		if (shops.getShopsCreatetime() != null) {
			sql2 += "shopsCreatetime, ";
			sql3 += "?, ";
			parameters.add(shops.getShopsCreatetime());
		}
		if (shops.getShopsClassify() != null) {
			sql2 += "shopsClassify, ";
			sql3 += "?, ";
			parameters.add(shops.getShopsClassify());
		}

		sql2 += "shopspassWord)";
		sql3 += "?)";
		parameters.add(shops.getShopspassword());

		String sql = "insert into t_shops " + sql2 + sql3;
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public boolean updateShopsUser(Shops shops) {
		String sql = "update t_shops set shopsId = ?, shopspassWord = ?, shopsName = ?, shopsManager = ?,shopsAdress = ? shopsCreatetime = ? shopsClassify = ?, shopsNums = ?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(shops.getShopsId());
		parameters.add(shops.getShopspassword());
		parameters.add(shops.getShopsName());
		parameters.add(shops.getShopsManager());
		parameters.add(shops.getShopsAddress());
		parameters.add(shops.getShopsCreatetime());
		parameters.add(shops.getShopsClassify());
		parameters.add(shops.getShopsNums());
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public boolean updateUserAgile(Shops shops) {
//		（注意）只修改需要修改的部分，所以在定义user类的时候要定义多个构造方法，允许其他值为null
		String sql = "update t_shops set ";
		List<Object> parameters = new ArrayList<Object>();
		if (shops.getShopspassword() != null) {
			sql += "shopspassword=?, ";
			parameters.add(shops.getShopspassword());
		}
		if (shops.getShopsName() != null) {
			sql += "shopsName=?, ";
			parameters.add(shops.getShopsName());
		}
		if (shops.getShopsManager() != null) {
			sql += "shopsManager=?, ";
			parameters.add(shops.getShopsManager());
		}
		if (shops.getShopsAddress() != null) {
			sql += "shopsAdress=?, ";
			parameters.add(shops.getShopsAddress());
		}
		if (shops.getShopsCreatetime() != null) {
			sql += "shopsCreatetime=?, ";
			parameters.add(shops.getShopsCreatetime());
		}
		if (shops.getShopsClassify() != null) {
			sql += "shopsClassify=?, ";
			parameters.add(shops.getShopsClassify());
		}
		sql += "where shopsId = ? ";
		parameters.add(shops.getShopsId());
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public Shops selectShops(Shops shops) {
		String sql = " select * from t_shops where shopsId = ? and shopspassword = ? ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(shops.getShopsId());
		parameters.add(shops.getShopspassword());
		List<Shops> shopsList = null;
		try {
			shopsList = BaseDao.operQuery(sql, parameters, Shops.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (shopsList.size() == 0)
			return null;

		return shopsList.get(0);
	}

	@Override
	public List<Shops> selectAllShops() {
		String sql = "select * from t_shops ";
		List<Shops> shopsList = new ArrayList<Shops>();
		try {
			shopsList = BaseDao.operQuery(sql, null, Shops.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopsList;
	}

	@Override
	public boolean deleteShopByShopsId(String shopsId) {
		String sql = "delete  from t_shops where shopsId = '" + shopsId + "' ";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Shops selectUserById(String shopsId) {
		String sql = " select * from t_shops where shopsId =  '" + shopsId + "' ";
		List<Object> parameters = new ArrayList<Object>();
		List<Shops> shopsList = new ArrayList<Shops>();
		try {
			shopsList = BaseDao.operQuery(sql, parameters, Shops.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (shopsList.size() == 0) {
			System.out.println("没有查找到该商家！");
			return null;
		}

		return shopsList.get(0);
	}

	@Override
	public Shops selectShopsByIdAndPass(String shopsId, String password) {
		String sql = "select * from t_shops where shopsId=? and shopspassword=?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(shopsId);
		parameters.add(password);

		List<Shops> shopsList = null;
		try {
			shopsList = BaseDao.operQuery(sql, parameters, Shops.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (shopsList == null)
			return null;
		return shopsList.get(0);
	}

}
