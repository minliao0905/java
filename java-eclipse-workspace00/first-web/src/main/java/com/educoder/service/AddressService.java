package com.educoder.service;

import java.util.List;

import com.educoder.entity.Address;

public interface AddressService {

	List<Address> getAddressByUserId(String userId);

}
