package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "dogs")
public class Dogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String breed;
	private String nameofdog;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	public Dogs( String breed, String nameofdog) 
	{	
		this.breed = breed;
		this.nameofdog = nameofdog;
		
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


	
	
	

}
