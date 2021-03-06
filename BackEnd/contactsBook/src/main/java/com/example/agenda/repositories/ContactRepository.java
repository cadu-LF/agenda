package com.example.agenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.agenda.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	public List<Contact> findByUserId(Long userId);
	
}
