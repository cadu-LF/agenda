package com.example.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.models.Address;
import com.example.agenda.repositories.AddressRepository;

@RestController
public class AddressController {
	
	@Autowired
	AddressRepository injection;
	
	@PostMapping("/agenda/address")
	public String saveAddress(@RequestBody Address address) {
		injection.save(address);
		return("Salvo!");
	}
	
	@GetMapping("/agenda/address")
	public List<Address> getAddress(){
		return injection.findAll();
	}
	
	@DeleteMapping("/agenda/address/{id}")
	public String deleteAddress(@PathVariable("id") Long id) {
		injection.deleteById(id);
		return("Deletado");
	}
	
	@PutMapping("/agenda/address")
	public String updateAddress(@RequestBody Address partialData) {
		injection.save(partialData);
		return("Atualizado");
	}
	
}
