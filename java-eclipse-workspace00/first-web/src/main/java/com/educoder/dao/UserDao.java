package com.educoder.dao;

import java.util.List;

import com.educoder.entity.User;

public interface UserDao {

	public boolean insertUser(User user);

	public boolean updateUser(User user);

	public boolean updateUserAgile(User user);

	public User selectUser(User user);

	public List<User> selectAllUser();

	public boolean deleteUserByUserId(String userId);

	/**
	 * @param userId
	 * @return
	 */
	public default User selectUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public User selectUserByIdAndPass(String userId, String password);

}
