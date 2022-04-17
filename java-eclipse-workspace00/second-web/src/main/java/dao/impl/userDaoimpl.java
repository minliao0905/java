package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.userdao;
import entity.User;

public class userDaoimpl implements userdao {
//	插入新用户
	public boolean insertUser(User user) {
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
		sql2 += "passWord)";
		sql3 += "?)";
		parameters.add(user.getPassWord());
		String sql = "insert into t_user " + sql2 + sql3;
		boolean res = BaseDao.operUpdate(sql, parameters);
		return res;
	}

	@Override
	public boolean updateUser(User user) {
		//
		String sql = "update t_user set userName = ?, passWord = ?, userHeadImg = ? " + " where userId = ?";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(user.getUserName());
		parameters.add(user.getPassWord());
		parameters.add(user.getUserHeadImg());
		parameters.add(user.getUserId());
		boolean res = BaseDao.operUpdate(sql, parameters);

		return res;
	}

	@Override
	public boolean updateUserAgile(User user) {
		//
//	（注意）只修改需要修改的部分，所以在定义user类的时候要定义多个构造方法，允许其他值为null

		String sql = "update t_user set ";
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
	public User selectUser(User user) {
		//
		String sql = " select * from t_user where userId = ? and passWord = ? ";
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(user.getUserId());
		parameters.add(user.getPassWord());
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
	public List<User> selectAllUser() {
		//
		String sql = "select * from t_user ";
		List<User> usersList = new ArrayList<User>();
		try {
			usersList = BaseDao.operQuery(sql, null, User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Override
	public boolean deleteUserByUserId(String userId) {
		String sql = "delete  from t_user where userId = '" + userId + "' ";
		boolean res = false;
		try {
			res = BaseDao.operUpdate(sql, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public User selectUserById(String userId) {
		String sql = " select * from t_user where userId =  '" + userId + "' ";
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

	@Override
	public User selectUserByIdAndPass(String userId, String password) {
		String sql = "select * from t_user where userId=? and passWord=?";
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
}
