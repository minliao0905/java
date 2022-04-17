package com.educoder.dao;

import java.util.List;

import com.educoder.entity.User;

public interface MycontrolDao {

	public boolean insertMycontrolUser(User user);

	public boolean updateMycontrolUser(User user);

	public boolean updateMycontrolAgile(User user);

	public User selectMycontrolById(String userId);

	public List<User> selectAllMycontrol();

	public boolean deleteMycontrolById(String userId);

	/**
	 * @param userId
	 * @return
	 */
	public default User selectShopsById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public User selectShopsByIdAndPass(String MycontrolId, String password);

}
