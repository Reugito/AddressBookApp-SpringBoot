package com.bridgelabz.addressbook.controller;

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

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@GetMapping(value = {"", "/", "/details"})
	public ResponseEntity<String> getAddressBookData()
	{
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	@GetMapping("/details/{personId}")
	public ResponseEntity<String> getAddressBookData(@PathVariable("personId") int personId)
	{
		return new ResponseEntity<String> ("Get Call Success for id: "+personId, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO)
	{
		ResponseDTO respDTO = new ResponseDTO("Address book data created", addressBookDTO);
		return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update/{personId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("personId") int personId,
													@RequestBody AddressBookDTO addressBookDTO)
	{
		ResponseDTO respDTO = new ResponseDTO("updated adressBook data", addressBookDTO);
		return new ResponseEntity<ResponseDTO> (respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<String> deleteAddressBookData(@PathVariable("personId") int personId)
	{
		ResponseDTO respDTO = new ResponseDTO("deleted adressBook data", personId);
		return new ResponseEntity<String> ("Delete Call Success for Id for: ", HttpStatus.OK);
	}

}
