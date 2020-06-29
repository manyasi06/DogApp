package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dogs;

@Repository
public interface DogRepository extends JpaRepository<Dogs, Integer> {
	@Query(value = "SELECT * FROM dogs  u WHERE u.breed= :breed and u.nameofdog= :nameofdog"
			+ " and u.ownerfirstname= :ownerfirstname and u.ownerlastname= :ownerlastname",
			nativeQuery = true)
	public Dogs findByBreedUnique( @Param("breed")String breed, 
			@Param("nameofdog")String nameofdog, 
			@Param("ownerfirstname")String ownerfirstname, 
			@Param("ownerlastname") String ownerlastname);
}
