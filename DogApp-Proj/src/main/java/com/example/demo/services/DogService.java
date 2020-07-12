package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
	
	
	public boolean checkIfDogExists( String breed, 
			String nameofdog, 
			String ownerfirstname, 
			String ownerlastname) {
		Dogs val = dogRepository.findByBreedUnique(breed, 
				nameofdog, ownerfirstname, ownerlastname);
		if(val != null)
			return true;
		
		return false;
	}
	
	public List<Dogs> getAll(){
		return dogRepository.findAll();
	}
	
	public Optional<Dogs> getByIdofDog(Integer id) {
		return dogRepository.findById(id);
	}
	
	public void removeDog(Integer id) {
		dogRepository.deleteById(id);
	}
	
	public void createDog(Dogs dog) {
		dogRepository.save(dog);
	}
	
	public void editDog(Dogs newDog) {
		dogRepository.saveAndFlush(newDog);
	}
	
	
	
	
	

}
