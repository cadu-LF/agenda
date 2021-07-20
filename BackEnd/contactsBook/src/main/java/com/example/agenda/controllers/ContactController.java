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

import com.example.agenda.models.Contact;
import com.example.agenda.repositories.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	ContactRepository injection;
	
	@PostMapping("agenda/contact")
	public String postContact(@RequestBody Contact contact) {
		injection.save(contact);
		return("Salvo");
	}
	
	@GetMapping("agenda/contact")
	public List<Contact> getContacts(){
		return injection.findAll();
	}
	
	@DeleteMapping("agenda/contact/{id}")
	public String deleteContact(@PathVariable Long id) {
		injection.deleteById(id);
		return("Deletado");
	}
	
	@PutMapping("agenda/contact")
	public String updateContact(@RequestBody Contact contact) {
		injection.save(contact);
		return("Atualizado");
	}
	
}
