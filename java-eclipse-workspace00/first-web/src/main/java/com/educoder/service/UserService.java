package com.educoder.service;

import com.educoder.entity.User;

public interface UserService {

	/**
	 * @param user
	 * @return
	 */
	User selectUser(User user);

	/**
	 * @param user
	 * @return
	 */
	boolean insertUser(User user);
	
}
