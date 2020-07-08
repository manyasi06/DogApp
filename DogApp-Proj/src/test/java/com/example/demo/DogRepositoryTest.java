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
	public void testAddDogRepositoryFindAll() {
	
		
		Dogs d1 = new Dogs(1,"Doodle","Beany","Frank","Gore");
		Dogs d2 = new Dogs(2,"Doodle","Julie","Cole","Lee");
		Dogs d3 = new Dogs(3,"Doodle","Keenie","Leo","Messi");
		List<Dogs> myL = Arrays.asList(d1,d2,d3);
		
		when(mockDogRepository.findAll()).thenReturn(myL);
		
		//assertArrayEquals(mockDogRepository.findAll(), myL);
		Assertions.assertThat(mockDogRepository.findAll())
			.contains(d1,d2,d3);
	}
	
	
	@Test
	void testDogsModel() {
		Dogs dog = new Dogs();
		dog.setBreed("Doodle");
		assertEquals(dog.getBreed().equals("Doodle"),true);
	}
	
	
}
