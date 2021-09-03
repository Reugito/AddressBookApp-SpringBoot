package com.bridgelabz.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class AddressBookController {
	
	@GetMapping(value = {"", "/", "/details"})
	public ResponseEntity<String> getAddressBookData()
	{
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	@GetMapping("/details/{personId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("personId") int personId)
	{
		return new ResponseEntity<String> ("Get Call Success for id: "+personId, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData()
	{
		return new ResponseEntity<String> ("Created address book Data for: ", HttpStatus.OK);
	}
	
	@PutMapping("/update/{personId}")
	public ResponseEntity<String> updateEmployeePayrollData(@PathVariable("personId") int personId)
	{
		return new ResponseEntity<String> ("Updated address book Data for: "+personId, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{personId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("personId") int personId)
	{
		return new ResponseEntity<String> ("Delete Call Success for Id for: "+personId, HttpStatus.OK);
	}

}
