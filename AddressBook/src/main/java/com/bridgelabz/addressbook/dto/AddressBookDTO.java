package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

public @Data class AddressBookDTO {

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "{addressbook.error.firstname}")
	public String name;

	@Pattern(regexp = "^(0/91)?[7-9][0-9]{9}$", message = "{addressbook.error.phoneno}")
	public String phone_no;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "adddress error")
	public String address;

	@NotBlank(message = "{addressbook.error.city}")
	public String city;

	@NotBlank(message = "{addressbook.error.state}")
	public String state;

	@Pattern(regexp = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$", message = "{addressbook.error.zipcode}")
	public String zip_code;
	
	public String email_id;
	public String password;
}
