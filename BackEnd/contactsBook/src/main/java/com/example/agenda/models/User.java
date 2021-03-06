package com.example.agenda.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_users")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -873494616698140938L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")	
	private Long id;
	private String email;
	@Column(name="passw")
	private String password;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="id_user", referencedColumnName="id_user")
	private List<Contact> contacts = new ArrayList<>();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public User() {
		
	}
	
}
