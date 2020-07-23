package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository PRepo;
	
	List<Person> getAllPeople(){
		return PRepo.findAll();
	}
	
	Boolean removePerson(Long id) {
		if(PRepo.findById(id) != null) {
			PRepo.deleteById(id);
			return true;
		}
		return false;
	}

}
