package com.bridgelabz.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {
	
	@Query(value = "SELECT * FROM addressbook WHERE name= :name", nativeQuery = true)
	List<AddressBookData> findByName(String name);
	
	@Query(value= "SELECT * FROM addressbook WHERE email_id = :email and password =:password", nativeQuery = true)
	AddressBookData VerifyIdPass(String email, String password);

}
