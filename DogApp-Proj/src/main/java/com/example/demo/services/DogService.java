package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dogs;
import com.example.demo.repository.DogRepository;

@Service
public class DogService {
	
	@Autowired
	DogRepository dogRepository;

	public DogService() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Dogs> getAll(){
		return dogRepository.findAll();
	}
	
	public Optional<Dogs> getByNameofDog(Integer id) {
		return dogRepository.findById(id);
	}
	
	public void removeDog(Integer id) {
		dogRepository.deleteById(id);
	}
	
	public void createDog(Dogs dog) {
		dogRepository.save(dog);
	}
	
	
	
	
	

}
