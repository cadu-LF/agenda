package com.example.agenda.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_contacts")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1203286572253189459L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contact")
	private Long id;
	private String fulName, phone, email, note;
	
	@ManyToOne
	@JoinColumn(name="id_user", referencedColumnName = "id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_category", referencedColumnName = "id_category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="id_addres", referencedColumnName = "id_addres")
	private Address address;
	
	public String getFulName() {
		return fulName;
	}
	public void setFulName(String fulName) {
		this.fulName = fulName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	//fulName, phone, email, note;
	public Contact(String fulName, String phone, String email, String note, User user, 
			Address address, Category category) {
		this.setFulName(fulName);
		this.setPhone(phone);
		this.setEmail(email);
		this.setNote(note);
		this.setUser(user);
		this.setAddress(address);
		this.setCategory(category);
	}
	public Contact() {
		
	}
	public void assignUser(User user) {
		this.setUser(user);
	}
	public void assignAddress(Address address) {
		this.setAddress(address);
	}
	public void assignCategory(Category category) {
		this.setCategory(category);
	}
		
}
