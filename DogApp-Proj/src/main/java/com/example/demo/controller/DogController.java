package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dogs;
import com.example.demo.repository.DogRepository;
import com.example.demo.services.DogService;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class DogController {
	
	
	@Autowired
	DogService dogService;
	

	
	
	@GetMapping("/dogs")
	public List<Dogs> getAllDogs(){	
		List<Dogs> myl = dogService.getAll();
		return myl;
	}
	
	@DeleteMapping("dogs/{id}")
	public void deleteDog(@RequestParam(required = true)int id ) {
		dogService.removeDog(id);
	}
	
	
	@PostMapping("/dogs")
	public ResponseEntity<String> createDog(@RequestBody Dogs dog) {
		
		
		if(dogService.checkIfDogExists(dog.getBreed(), dog.getNameOfDog(), 
				dog.getOwnerfirstname(), dog.getOwnerlastname()) == true) {
			System.out.println("This already exists");
			ResponseEntity<String> ret = new ResponseEntity<String>("Owner Exists", HttpStatus.CONFLICT);
			return ret;
		}
			
		
		
		
		dogService.createDog(dog);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	
	@GetMapping("/dogs/{id}")
	public Optional<Dogs> getDogById(@RequestParam(required = true)Integer id) {
		Optional<Dogs> dog = dogService.getByIdofDog(id);
		return dog;
	}
	
	
	



}
