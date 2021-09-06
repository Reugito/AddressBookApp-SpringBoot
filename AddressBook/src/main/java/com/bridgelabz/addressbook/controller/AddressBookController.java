package com.bridgelabz.addressbook.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.services.IAddressBookServices;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	@Autowired
	IAddressBookServices addressBookServices;

	/**
	 * @return list of AddressBook details from List
	 */
	@GetMapping(value = { "", "/", "/details" })
	public ResponseEntity<ResponseDTO> getAddressBookData() {
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO("Get Call Success", addressBookServices.getEmployeePayrollData()), HttpStatus.OK);
	}

	/**
	 * accepts the person id
	 * 
	 * @param personId
	 * @return list of AddressBook details from List
	 */
	@GetMapping("/details/{personId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("personId") int personId) {
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO("Get Call By Id Success", addressBookServices.getAddressBookDataById(personId)),
				HttpStatus.OK);
	}

	/**
	 * accepts the person details in the form of AddressBookDTO and stores it in
	 * List
	 * 
	 * @param addressBookDTOs
	 * @return accepted person details in JSON format
	 */
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<ResponseDTO>(
				new ResponseDTO("Address book data created", addressBookServices.createAddressBookData(addressBookDTO)),
				HttpStatus.OK);
	}

	/**
	 * accepts the person id and new person details in the form of AddressBookDTO
	 * and stores it in List
	 * 
	 * @param personId
	 * @param addressBookDTO
	 * @return updated person details in JSON format
	 */
	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
			@RequestBody AddressBookDTO addressBookDTO) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("updated adressBook data",
				addressBookServices.updateAddressBookData(personId, addressBookDTO)), HttpStatus.OK);
	}

	/**
	 * deletes the data that matches the person id from list
	 * 
	 * @param personId
	 * @return personId and Acknowledgement message
	 */
	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("personId") int personId) {
		addressBookServices.deleteAddressBookData(personId);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO("deleted adressBook data with personId :", personId),
				HttpStatus.OK);
	}
}
