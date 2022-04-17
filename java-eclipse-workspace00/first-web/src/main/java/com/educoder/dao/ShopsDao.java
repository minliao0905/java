package com.educoder.dao;

import java.util.List;

import com.educoder.entity.Shops;

public interface ShopsDao {
	public boolean insertShopsUser(Shops shops);

	public boolean updateShopsUser(Shops shops);

	public boolean updateUserAgile(Shops shops);

	public Shops selectShops(Shops shops);

	public List<Shops> selectAllShops();

	public boolean deleteShopByShopsId(String shopsId);

	/**
	 * @param userId
	 * @return
	 */
	public default Shops selectShopsById(String shopsId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param userId
	 * @param password
	 * @return
	 */
	public Shops selectShopsByIdAndPass(String shopsId, String password);

}
