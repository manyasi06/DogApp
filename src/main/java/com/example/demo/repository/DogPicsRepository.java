package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.DogPics;

public interface DogPicsRepository extends MongoRepository<DogPics, String> {

}
