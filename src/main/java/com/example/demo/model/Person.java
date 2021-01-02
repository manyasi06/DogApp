package com.example.demo.model;

import java.util.Set;
import com.example.demo.model.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "persons")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	private String firstname;
	private String lastname;

	@OneToMany( 
			cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER,
			targetEntity = Dogs.class )
	@JoinColumn(name="person_id")
	private Set<Dogs> dogs;

	
	public Person() {
		super();
	}

	public Person(long id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Person(String firstname, String lastname) {
		// TODO Auto-generated constructor stub
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public Person(long id, String firstname, String lastname, Set<Dogs> dogs) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dogs = dogs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public Set<Dogs> getDogs() {
		return dogs;
	}

	public void setDogs(Set<Dogs> dogs) {
		this.dogs = dogs;
	}


}
