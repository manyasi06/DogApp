package com.example.demo.dogtests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Dogs;
import com.example.demo.model.Person;
import com.example.demo.repository.DogRepository;

@RunWith(SpringJUnit4ClassRunner.class)
class DogRepositoryTests {
	
	@Mock
	private DogRepository mockedDogRepository;
	private Set<Dogs> myDogList;
	private List<Dogs> myDogs;
	
	@BeforeEach
	public void mockRep() {
		MockitoAnnotations.initMocks(this);
		Person person1 = new Person(1,"Frank","Gore");
		Dogs dog1 = new Dogs(1,"jack terry","Benson",person1);
		Dogs dog2 = new Dogs(2,"jack terry","Little",person1);
		Dogs dog3 = new Dogs(3,"jack terry","Mac",person1);
		myDogList = new HashSet<>(Arrays.asList(new Dogs[]{dog1,dog2,dog3}));
		myDogs = Arrays.asList(new Dogs[] {dog1,dog2,dog3});
		person1.setDogs(myDogList);
		
		
	}


	@Test
	void testgetAllDogs() {
		when(mockedDogRepository.findAll()).thenReturn(myDogs);
		List<Dogs> returnedList = mockedDogRepository.findAll();
		Assert.assertEquals(returnedList, myDogs);
	}
	
	

}
