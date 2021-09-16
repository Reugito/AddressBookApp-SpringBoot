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

	private String name;
	private String phone_no;
	private String address;
	private String state;
	private String city;
	private String zip_code;
	private String email_id;
	private String password;

	public AddressBookData() {
	}

	public AddressBookData(AddressBookDTO addressBookDTO) {
		this.updateAddressBookData(addressBookDTO);
	}

	public void updateAddressBookData(AddressBookDTO addressBookDTO) {

		this.name = addressBookDTO.name;
		this.phone_no = addressBookDTO.phone_no;
		this.address = addressBookDTO.address;
		this.city = addressBookDTO.city;
		this.state = addressBookDTO.state;
		this.zip_code = addressBookDTO.zip_code;
	}
}
