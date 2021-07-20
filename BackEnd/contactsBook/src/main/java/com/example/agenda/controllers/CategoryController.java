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

import com.example.agenda.models.Category;
import com.example.agenda.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoryRepository injection;
	
	@PostMapping("agenda/category")
	public String postCategory(@RequestBody Category category) {
		injection.save(category);
		return("Salvo");
	}
	
	@GetMapping("agenda/category")
	public List<Category> getCategories(){
		return injection.findAll();
	}
	
	@DeleteMapping("agenda/category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		injection.deleteById(id);
		return("Deletado");
	}
	
	@PutMapping("agenda/category")
	public String updateCategory(@RequestBody Category category) {
		injection.save(category);
		return("Atualizado");
	}
	
}
