package com.bridgelabz.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;

@Service
public class AddressBookServices implements IAddressBookServices {
	
	List<AddressBookData> addressbookDataList = new ArrayList();

	/**
	 * @return list of AddressBook details from List 
	 */
	@Override
	public List<AddressBookData> getEmployeePayrollData() {
		return addressbookDataList;
	}

	/** 
	 * accepts the person id
	 * @param personId
	 * @return list of AddressBook details from List 
	 */
	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		return addressbookDataList.get(personId-1);
	}
	
	/**
	 * accepts the person details in the form 
	 * of AddressBookDTO and stores it in List
	 * @param addressBookDTO
	 * @return accepted addressBookData object
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(addressbookDataList.size()+1, addressBookDTO);
		addressbookDataList.add(addressBookData);
		return addressBookData;
	}
	
	/**
	 * accepts the person id and new person details in the form 
	 * of AddressBookDTO and stores it in List
	 * @param personId
	 * @param addressBookDTO
	 * @return updated addressBookData object
	 */
	@Override
	public AddressBookData updateAddressBookData(int personId, AddressBookDTO AddressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(personId-1);
		addressBookData.updateAddressBookData(AddressBookDTO);
		return addressBookData;
	}

	/**
	 * deletes the data that matches the person id from list
	 * @param personId
	 */
	@Override
	public void deleteAddressBookData(int personId) {
		addressbookDataList.remove(personId-1);
	}
}
