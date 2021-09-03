package com.bridgelabz.addressbook.services;

import java.util.List;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

public interface IAddressBookServices {

	List<AddressBookData> getEmployeePayrollData();
	
	AddressBookData getAddressBookDataById(int personId);
	
	AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO);
	
	AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO);
	
	void deleteAddressBookData(int personId);
}
