package com.example.demo.dogtests;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Dogs;
import com.example.demo.model.Person;
import com.example.demo.repository.DogRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DogRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DogRepository dogRepository;
	
	
	
	@Test
	public void findByBreedUniqueTest() {
		
		//Create a Person
		Person P = new Person("Bryan","Musungu");
		entityManager.persist(P);
		entityManager.flush();
		
		
		//Create a Dog
		Dogs G = new Dogs("Labradoodle","Larry",P);
		entityManager.persist(G);
		entityManager.flush();
		
		//When do is found
		Dogs found = dogRepository.findByBreedUnique(G.getBreed(),G.getNameOfDog());
		
		assertTrue(found.getNameOfDog().equalsIgnoreCase(G.getNameOfDog()));
		
		assertTrue(found.getBreed().equalsIgnoreCase(G.getBreed()));
	}
	
	

}
