package com.example.demo.services;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DogPics;
import com.example.demo.repository.DogPicsRepository;

@Service
public class DogPicsService {
	
	@Autowired
	private DogPicsRepository dogPicRepo;
	
	public String addPhoto(String title, MultipartFile file) throws IOException {
		
		DogPics dogPics = new DogPics(title);
		
		dogPics.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
		dogPics = dogPicRepo.insert(dogPics);
		return dogPics.getId();
		
	}
	
	public DogPics getPhoto(String id) {
		return dogPicRepo.findById(id).get();
	}

}
