package com.bridgelabz.addressbook.model;

import lombok.Data;

public @Data class AddressBookData {
	
	private int person_id;

	private String first_name;
	private String last_name;
	private String gender;
	private long phone_no;
	private String city;
	private String state;
	private String zip_code;

}
