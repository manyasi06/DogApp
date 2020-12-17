package com.example.demo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Dogs;
import com.example.demo.repository.DogRepository;


@SpringBootTest
public class DogRepositoryTest {
		
	@Mock
	private DogRepository mockDogRepository;
	
	
	
	@Test
	public void testFindById() {
		//Todo
	}
	
	
	@Test
	void testDogsModel() {
		Dogs dog = new Dogs();
		dog.setBreed("Doodle");
		assertEquals(dog.getBreed().equals("Doodle"),true);
	}
	
	
}
