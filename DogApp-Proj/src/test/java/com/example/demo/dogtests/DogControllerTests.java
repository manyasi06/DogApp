package com.example.demo.dogtests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.*;


import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.example.demo.model.Dogs;
import com.example.demo.model.Person;

import junit.framework.Assert;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DogControllerTests {
	
	@LocalServerPort
	private int port;
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	public List<Dogs> createMockDogsList(){
		List<Dogs> j = new ArrayList<Dogs>();
		j.add(new Dogs(1, "labrodoodle", "John", null));
		j.add(new Dogs(2, "doodle","Leo", null));
		j.add(new Dogs(3, "berndoodle", "Frank", null));
		j.add(new Dogs(4, "pyredoodle", "Jake", null));
		j.add(new Dogs(5, "poodle", "Bryan", null));
		j.add(new Dogs(6, "poodle", "Jcole", null));
		return j;	
	}
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void ShouldReturnAListOfDogs() throws Exception {
		List<Dogs> shoul = this.createMockDogsList();
		System.out.println(shoul);
		Dogs[] returnedVal = this.restTemplate.getForObject("http://localhost:" + port + "/api/dogs",Dogs[].class);
//		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/dogs",
//				Dogs[].class)).containsAll(shoul);
		System.out.println(returnedVal);
		
		
	}

}
