package com.bridgelabz.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name = "addressbook")
public @Data class AddressBookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int person_id;
	
	private String first_name;
	private String last_name;
	private String gender;
	private String phone_no;
	private String city;
	private String state;
	private String zip_code;
	
	public AddressBookData() {}
	
	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);

	}
	public void updateAddressBookData(AddressBookDTO addressBookDTO) {
		
		this.first_name = addressBookDTO.first_name;
		this.last_name = addressBookDTO.last_name;
		this.gender = addressBookDTO.gender;
		this.phone_no = addressBookDTO.phone_no;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip_code = addressBookDTO.zip_code;
		
	}
}
