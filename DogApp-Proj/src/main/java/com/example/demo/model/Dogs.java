package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "dogs")
public class Dogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String breed;
	private String nameofdog;
	private String ownerfirstname;
	private String ownerlastname;
	
	public Dogs(Integer id, String breed, String nameofdog, String ownerfirstname, String ownerlastname) {
		super();
		this.id = id;
		this.breed = breed;
		this.nameofdog = nameofdog;
		this.ownerfirstname = ownerfirstname;
		this.ownerlastname = ownerlastname;
	}
	

	public Dogs() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBreed() {
		return breed;
	}


	public void setBreed(String breed) {
		this.breed = breed;
	}


	@JsonProperty(value = "nameofdog")
	public String getNameOfDog() {
		return nameofdog;
	}


	public void setNameOfDog(String nameOfDog) {
		this.nameofdog = nameOfDog;
	}


	public String getOwnerfirstname() {
		return ownerfirstname;
	}


	public void setOwnerfirstname(String ownerfirstname) {
		this.ownerfirstname = ownerfirstname;
	}


	public String getOwnerlastname() {
		return ownerlastname;
	}


	public void setOwnerlastname(String ownerlastname) {
		this.ownerlastname = ownerlastname;
	}
	
	

}
