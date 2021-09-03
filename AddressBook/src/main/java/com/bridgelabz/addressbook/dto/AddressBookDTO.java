package com.bridgelabz.addressbook.dto;

import lombok.Data;

public @Data class AddressBookDTO {
	
	public String first_name;
	
	public String last_name;
	
	public String gender;
	
	public String phone_no;
	
	private String city;
	
	private String state;
	
	private String zip_code;

	@Override
	public String toString() {
		return "AddressBookDTO [first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender
				+ ", phone_no=" + phone_no + ", city=" + city + ", state=" + state + ", zip_code=" + zip_code + "]";
	}
}
