package com.example.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agenda.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public User findByEmail(String email);
	
}
