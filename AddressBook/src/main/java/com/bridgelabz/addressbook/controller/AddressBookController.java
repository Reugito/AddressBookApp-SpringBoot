package com.bridgelabz.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.dto.AuthenticationResponse;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.model.AddressBookData;
import com.bridgelabz.addressbook.model.AuthenticationRequest;
import com.bridgelabz.addressbook.services.IAddressBookServices;
import com.bridgelabz.addressbook.services.MyUserDetailService;
import com.bridgelabz.addressbook.util.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
public class AddressBookController {

	@Autowired
	IAddressBookServices addressBookServices;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	/**
	 * @return list of AddressBook details from List
	 */
	@GetMapping(value = { "", "/", "/details" })
	public List<AddressBookData> getAddressBookData() {
		/*
		 * return new ResponseEntity<ResponseDTO>( new ResponseDTO("Get Call Success",
		 * addressBookServices.getAddressBookData()), HttpStatus.OK);
		 */
		return addressBookServices.getAddressBookData();
	}

	@GetMapping("/sort/{name}")
	public List<AddressBookData> sortAddressBookData(@PathVariable("name") String name) {
		return addressBookServices.sortByName(name);
	}

	/**
	 * accepts the person id
	 * 
	 * @param personId
	 * @return list of AddressBook details from List
	 */
	@GetMapping("/details/{personId}")
	public AddressBookData getAddressBookData(@PathVariable("personId") int personId) {
		/*
		 * return new ResponseEntity<ResponseDTO>( new
		 * ResponseDTO("Get Call By Id Success",
		 * addressBookServices.getAddressBookDataById(personId)), HttpStatus.OK);
		 */
		return addressBookServices.getAddressBookDataById(personId);
	}

	@GetMapping("/name/{name}")
	public List<AddressBookData> getAddressBookDataByName(@PathVariable("name") String name) {
		return addressBookServices.findByName(name);
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

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or Password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
