package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import java.util.*;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping(path = "/api")
public class PersonController {
	
	@Autowired
	PersonRepository userRepo;
	
	@GetMapping("/dog/user")
	ResponseEntity<List<Person>> getAllUser(){
		
		return new ResponseEntity<List<Person>>(userRepo.findAll(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/dog/user/{id}")
	ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
		
		userRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}

}
