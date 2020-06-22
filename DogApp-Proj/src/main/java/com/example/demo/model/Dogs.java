package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity(name = "dogs")
public class Dogs {
	
	@Id
	private Integer id;
	private String breed;
	private String nameofdog;
	private String ownerfirstname;
	private String ownerlastname;
	
	public Dogs(Integer id, String breed, String nameOfDog, String ownerfirstname, String ownerlastname) {
		super();
		this.id = id;
		this.breed = breed;
		this.nameofdog = nameOfDog;
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
