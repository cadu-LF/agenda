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
@Table(name="tb_categories")
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2860597640787672524L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private Long id;
	private String description;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name="id_category", referencedColumnName="id_category")
	private List<Contact> contacts = new ArrayList<>();
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public Category(String description) {
		this.description = description;
	}
	public Category() {
		
	}
	

}
