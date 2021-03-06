package com.example.agenda.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.models.Address;
import com.example.agenda.models.Category;
import com.example.agenda.models.Contact;
import com.example.agenda.models.User;
import com.example.agenda.repositories.AddressRepository;
import com.example.agenda.repositories.CategoryRepository;
import com.example.agenda.repositories.ContactRepository;
import com.example.agenda.repositories.UserRepository;

@RestController
public class ContactController {

	@Autowired
	ContactRepository injection;
	
	@Autowired
	UserRepository userInjection;
	
	@Autowired
	AddressRepository addressInjection;
	
	@Autowired
	CategoryRepository categoryInjection;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("agenda/contact/user/{id}")
	public String postContact(@RequestBody Contact contact, @PathVariable("id") Long userId) {	
		User user = userInjection.getById(userId);
		contact.assignUser(user);
		injection.save(contact);		
		return("Salvo");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("agenda/contact")
	public List<Contact> getContacts(){
		return injection.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("agenda/contact/{id}")
	public String deleteContact(@PathVariable Long id) {
		injection.deleteById(id);
		return("Deletado");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("agenda/contact")
	public String updateContact(@RequestBody Contact contact) {
		injection.save(contact);
		return("Atualizado");
	}
		
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("agenda/contact/{contactId}/address/{addressId}")
	public String assignAddressToContact(
			@PathVariable Long contactId,
			@PathVariable Long addressId
			) {
		Contact contact = injection.getById(contactId);
		Address address = addressInjection.getById(addressId);
		contact.assignAddress(address);
		injection.save(contact);
		return("address assigned");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("agenda/contact/{contactId}/category/{categoryId}")
	public String assignCategoryToContact(
			@PathVariable Long contactId,
			@PathVariable Long categoryId
			) {
		Contact contact = injection.getById(contactId);
		Category category = categoryInjection.getById(categoryId);
		contact.assignCategory(category);
		injection.save(contact);
		return("category assigned");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("agenda/contact/user/{id}")	
	public List<Contact> getByUserId(@PathVariable("id") Long id) {
		return injection.findByUserId(id);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("agenda/contact/{id}")
	public Optional<Contact> getById(@PathVariable("id") Long id) {
		return injection.findById(id);
	}
	
}
