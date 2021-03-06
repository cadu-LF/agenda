package com.example.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agenda.models.User;
import com.example.agenda.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository injection;
	
	@PostMapping("agenda/user")
	public String postUser(@RequestBody User user) {
		injection.save(user);
		return("Salvo");
	}
	
	@GetMapping("agenda/user")
	public List<User> getUsers(){
		return injection.findAll();
	}
	
	@DeleteMapping("agenda/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		injection.deleteById(id);
		return("Deletado");
	}
	
	@PutMapping("agenda/user")
	public String updateUser(@RequestBody User user) {
		injection.save(user);
		return("Atualizado");
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("agenda/user/email/{email}")	
	public User getByEmail(@PathVariable("email") String email) {
		return injection.findByEmail(email);
	}
	
}
