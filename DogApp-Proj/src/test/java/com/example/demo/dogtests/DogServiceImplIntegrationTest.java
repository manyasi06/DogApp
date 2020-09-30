package com.example.demo.dogtests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Dogs;
import com.example.demo.model.Person;
import com.example.demo.repository.DogRepository;
import com.example.demo.services.DogService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class DogServiceImplIntegrationTest {

	
	@TestConfiguration
	static class DogServiceImplIntegrationTestContextConfiguraton {
		
		@Bean
		public DogService DogService() {
			return new DogService();
		}
	}
	
	@Autowired
	private DogService dogService;
	
	@MockBean
	private DogRepository dogRespository;
	
	@Before
	public void setUp() {
		
		//create a person
		Person p = new Person("Frank","Lewis");
		Person p1 = new Person("Lisa","Lewis");
		
		
		Dogs dog1 = new Dogs("Giant Schnauzer", "Leo",p);
		
		Mockito.when(dogRespository.findByBreedUnique(dog1.getBreed(), dog1.getNameOfDog()))
			.thenReturn(dog1);
	}
	
	
	@Test
	public void testUsageForGetDogByNameandBreed() {
		String breed = "Giant Schnauzer";
		Dogs d = dogRespository.findByBreedUnique("Giant Schnauzer", "Leo");
		
		assertEquals(d.getBreed().equalsIgnoreCase(breed), true);
		
	}
	
	
}
