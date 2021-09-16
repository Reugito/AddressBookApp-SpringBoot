package com.bridgelabz.addressbook.services;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

public interface IAddressBookServices {

	List<AddressBookData> getAddressBookData();
	
	List<AddressBookData> findByName(String name);
	
	AddressBookData VerifyIdPass(String email, String pass);
	
	AddressBookData getAddressBookDataById(int personId);
	
	List<AddressBookData>sortByName(String name);
	
	AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO);
	
	AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO);
	
	void deleteAddressBookData(int personId);
}
