package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "dogs")
public class Dogs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private Integer id;
	private String breed;
	private String nameofdog;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	@JsonIgnore
	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Dogs( String breed, String nameofdog) 
	{	
		this.breed = breed;
		this.nameofdog = nameofdog;
		
	}
	
	public Dogs( Integer id, String breed, String nameofdog) 
	{	
		this.id = id;
		this.breed = breed;
		this.nameofdog = nameofdog;
		
	}
	
	public Dogs(String breed, String nameofdog, Person person) {
		super();
		
		this.breed = breed;
		this.nameofdog = nameofdog;
		this.person = person;
	}
	
	public Dogs(Integer id, String breed, String nameofdog, Person person) {
		super();
		this.id = id;
		this.breed = breed;
		this.nameofdog = nameofdog;
		this.person = person;
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

	@Override
	public String toString() {
		return "Dogs [id=" + id + ", breed=" + breed + ", nameofdog=" + nameofdog + ", person=" + person + "]";
	}


	
	
	

}
