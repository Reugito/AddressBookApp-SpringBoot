package com.bridgelabz.addressbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;

@Service
public class AddressBookServices implements IAddressBookServices {
	
	@Autowired
	AddressBookRepository addressBookRepo;

	/**
	 * @return list of AddressBook details from DB
	 */
	@Override
	public List<AddressBookData> getEmployeePayrollData() {
		return addressBookRepo.findAll();
	}

	/** 
	 * accepts the person id
	 * @param personId
	 * @return list of AddressBook details from DB 
	 */
	@Override
	public AddressBookData getAddressBookDataById(int personId) {
		return addressBookRepo.findById(personId).orElse(null);
	}
	
	/**
	 * accepts the person details in the form 
	 * of AddressBookDTO and stores it in List
	 * @param addressBookDTO
	 * @return accepted addressBookData object
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(addressBookDTO);
		return addressBookRepo.save(addressBookData);
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
		AddressBookData addressBookData = this.getAddressBookDataById(personId);
		addressBookData.updateAddressBookData(AddressBookDTO);
		return addressBookRepo.save(addressBookData);
	}

	/**
	 * deletes the data that matches the person id from DB
	 * @param personId
	 */
	@Override
	public void deleteAddressBookData(int personId) {
		AddressBookData addressBookData = this.getAddressBookDataById(personId);
		addressBookRepo.delete(addressBookData);
	}
}
