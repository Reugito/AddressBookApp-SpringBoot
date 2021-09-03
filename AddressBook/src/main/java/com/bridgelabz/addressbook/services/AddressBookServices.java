package com.bridgelabz.addressbook.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

@Service
public class AddressBookServices implements IAddressBookServices {

	@Override
	public List<AddressBookData> getEmployeePayrollData() {
		return null;
	}

	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		return null;
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO AddressBookDTO) {
		return null;
	}

	@Override
	public AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO) {
		return null;
	}

	@Override
	public void deleteAddressBookData(int personId) {
		
	}
}
