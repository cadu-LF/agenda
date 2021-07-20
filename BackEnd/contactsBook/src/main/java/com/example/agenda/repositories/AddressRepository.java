package com.example.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
}
