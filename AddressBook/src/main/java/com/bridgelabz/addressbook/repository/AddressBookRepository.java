package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
