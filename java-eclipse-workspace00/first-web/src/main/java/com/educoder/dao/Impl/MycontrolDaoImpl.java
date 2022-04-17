package com.educoder.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import com.educoder.dao.MycontrolDao;
import com.educoder.entity.User;

public class MycontrolDaoImpl implements MycontrolDao {

	@Override
	public boolean insertMycontrolUser(User user) {
		String sql2 = "(userId, ";
		String sql3 = "values(?, ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(user.getUserId());
		// 判断是否存在用户，存在用户名字和密码
		if (user.getUserName() != null) {
			sql2 += "userName, ";
			sql3 += "?, ";
			parameters.add(user.getUserName());

		}
		sql2 += "password)";
		sql3 += "?)";
		parameters.add(user.getPassWord());
		String sql = "insert into t_control " + sql2 + sql3;
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public boolean updateMycontrolUser(User user) {
		String sql = "update t_control set userName = ?, passWord = ?, userHeadImg = ? " + " where userId = ?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(user.getUserName());
		parameters.add(user.getPassWord());
		parameters.add(user.getUserHeadImg());
		parameters.add(user.getUserId());
		boolean res = BaseDao.operUpdate(sql, parameters);

		return res;
	}

	@Override
	public boolean updateMycontrolAgile(User user) {
		String sql = "update t_control set ";
		List<Object> parameters = new ArrayList<Object>();
		if (user.getUserName() != null) {
			sql += "userName=?, ";
			parameters.add(user.getUserName());
		}
		if (user.getPassWord() != null) {
			sql += "password=?, ";
			parameters.add(user.getPassWord());
		}
		if (user.getUserHeadImg() != null) {
			sql += "userHeadImg=? ";
			parameters.add(user.getUserHeadImg());
		}
		parameters.add(user.getUserId());
		sql += "where userId = ?";
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public List<User> selectAllMycontrol() {
		String sql = "select * from t_control ";
		List<User> usersList = new ArrayList<User>();
		try {
			usersList = BaseDao.operQuery(sql, null, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public boolean deleteMycontrolById(String userId) {
		String sql = "delete  from t_control where userId = '" + userId + "' ";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public User selectShopsByIdAndPass(String userId, String password) {
		String sql = "select * from t_control where userId=? and passWord=?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(userId);
		parameters.add(password);

		List<User> userList = null;
		try {
			userList = BaseDao.operQuery(sql, parameters, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0)
			return null;
		return userList.get(0);
	}

	@Override
	public User selectMycontrolById(String userId) {
		String sql = " select * from t_control where userId =  '" + userId + "' ";
		List<Object> parameters = new ArrayList<Object>();
		List<User> userList = new ArrayList<User>();
		try {
			userList = BaseDao.operQuery(sql, parameters, User.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userList.size() == 0) {
			System.out.println("没有查找到该用户！");
			return null;
		}

		return userList.get(0);
	}

}
