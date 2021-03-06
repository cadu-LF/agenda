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
@Table(name="tb_addreses")
public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4018180864500377506L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_addres")
	private Long id;
	@Column(name="cep")
	private String cep;
	private String street, neighborhood, city, country;
	@Column(name="uf")
	private String uf;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="id_addres", referencedColumnName="id_addres")
	private List<Contact> contacts = new ArrayList<>();
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String state) {
		this.uf = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Address(Long id, String cep, String street, String neighborhood, 
					String city, String state, String country) {
		this.setId(id);
		this.setCep(cep);
		this.setStreet(street);
		this.setNeighborhood(neighborhood);
		this.setCity(city);
		this.setUf(state);
		this.setCountry(country);
	}
	public Address() {
		
	}
	
}
