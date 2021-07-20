package com.example.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
