package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dogs;
import com.example.demo.repository.DogRepository;
import com.example.demo.services.DogService;
import com.sun.el.stream.Optional;

@RestController
public class DogController {
	
	

	DogService dogService;
	
	@Autowired
	DogRepository dogRepository;
	
	
	@GetMapping
	public List<Dogs> getAllDogs(){
		
		List<Dogs> myl = dogService.getAll();
		System.out.println(myl);
		return myl;
	}
	
	@GetMapping("/dogs")
	public List<Dogs> getAll(){
		 
		return dogRepository.findAll();
	}



}
